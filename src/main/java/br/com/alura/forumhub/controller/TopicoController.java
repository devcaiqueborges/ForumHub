package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.domain.curso.CursoRepository;
import br.com.alura.forumhub.domain.topico.*;
import br.com.alura.forumhub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoTopico> cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        if (topicoRepository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            return ResponseEntity.badRequest().build();
        }

        var autor = usuarioRepository.findById(dados.autorId()).orElseThrow();
        var curso = cursoRepository.findById(dados.cursoId()).orElseThrow();

        var topico = new Topico(null, dados.titulo(), dados.mensagem(), java.time.LocalDateTime.now(), "ATIVO", autor, curso, new java.util.ArrayList<>());
        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoTopico>> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = topicoRepository.findAll(paginacao).map(DadosDetalhamentoTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);

        if (topicoOptional.isPresent()) {
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topicoOptional.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTopico dados) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);

        if (topicoOptional.isPresent()) {
            var topico = topicoOptional.get();

            if (dados.titulo() != null) {
                topico.setTitulo(dados.titulo());
            }
            if (dados.mensagem() != null) {
                topico.setMensagem(dados.mensagem());
            }

            return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        if (!topicoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
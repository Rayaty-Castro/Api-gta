package com.dt2.GTAVI.controller;

import com.dt2.GTAVI.entities.Missao;
import com.dt2.GTAVI.repository.MissaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/missoes")
public class MissaoController {

    private final MissaoRepository repository;

    public MissaoController(MissaoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Missao> criarMissao(@RequestBody Missao viceCity) {
        try {
            Missao missaoSalva = repository.save(viceCity);
            return ResponseEntity.ok(missaoSalva);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Missao> mostrar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Missao> buscarId(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Missao> atualizar(@PathVariable int id, @RequestBody Missao m) {
        return repository.findById(id).map(missao -> {
            missao.setNome(m.getNome());
            missao.setLocal(m.getLocal());
            missao.setDificudade(m.getDificudade());
            missao.setDescricao(m.getDescricao());
            missao.setImagem(m.getImagem());
            return ResponseEntity.ok(repository.save(missao));
        }).orElse(ResponseEntity.notFound().build());
    }
}
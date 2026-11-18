package com.dt2.GTAVI.controller;

import com.dt2.GTAVI.entities.Arma;
import com.dt2.GTAVI.entities.Missao;
import com.dt2.GTAVI.repository.ArmaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/armas")
public class ArmaController {

    private final ArmaRepository repository;

    public ArmaController(ArmaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String criarArma(@RequestBody Arma glock19mm) {
        try {
            return "Salvo com Sucesso: " + repository.save(glock19mm);
        } catch (Exception e) {
            return "Dados incorretos";
        }
    }

    @GetMapping
    public List<Arma> mostrar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Arma> buscarId(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        repository.deleteById(id);
    }
    @PutMapping("/{id}")
    public void atualizar(@PathVariable  int id, @RequestBody Arma a){

        com.dt2.GTAVI.entities.Arma arma = repository.getReferenceById(id);
        arma.setNome(a.getNome());
        arma.setCategoria(a.getCategoria());
        arma.setFabricante(a.getFabricante());
        arma.setDescricao(a.getDescricao());
        arma.setImagem(a.getImagem());
        repository.save(arma);

    }
}
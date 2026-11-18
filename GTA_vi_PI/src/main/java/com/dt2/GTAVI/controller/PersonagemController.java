package com.dt2.GTAVI.controller;

import com.dt2.GTAVI.entities.Arma;
import com.dt2.GTAVI.entities.Personagem;
import com.dt2.GTAVI.repository.PersonagemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/personagens")
public class PersonagemController {

    private final PersonagemRepository repository;

    public PersonagemController(PersonagemRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String criarPersonagem(@RequestBody Personagem per) {
        try {

            return "Calvo com Sucesso" + repository.save(per);
        } catch (Exception e) {
            return "dados incorretos";
        }
    }
    @GetMapping
    public List<Personagem>mostrar(){
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Optional<Personagem> buscarId(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        repository.deleteById(id);
    }
    @PutMapping("/{id}")
    public void atualizar(@PathVariable  int id, @RequestBody Personagem p){

        Personagem personagem = repository.getReferenceById(id);

        personagem.setNome(p.getNome());
         personagem.setApelido(p.getApelido());
         personagem.setCategoria(p.getCategoria());
         personagem.setDescricao(p.getDescricao());
         personagem.setImagem(p.getImagem());
         repository.save(personagem);

    }

}

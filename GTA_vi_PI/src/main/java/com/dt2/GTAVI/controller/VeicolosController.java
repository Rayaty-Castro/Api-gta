package com.dt2.GTAVI.controller;

import com.dt2.GTAVI.entities.Arma;
import com.dt2.GTAVI.entities.Veicolos;
import com.dt2.GTAVI.repository.VeicolosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
public class VeicolosController {

    private final VeicolosRepository repository;

    public VeicolosController(VeicolosRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String criarVeicolos(@RequestBody Veicolos bugate) {
        try {
            return "Salvo com Sucesso: " + repository.save(bugate);
        } catch (Exception e) {
            return "Dados incorretos";
        }
    }

    @GetMapping
    public List<Veicolos> mostrar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Veicolos> buscarId(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        repository.deleteById(id);
    }
    @PutMapping("/{id}")
    public void atualizar(@PathVariable  int id, @RequestBody Veicolos v){

        com.dt2.GTAVI.entities.Veicolos veicolos = repository.getReferenceById(id);
        veicolos.setNome(v.getNome());
        veicolos.setCategoria(v.getCategoria());
        veicolos.setMarca(veicolos.getMarca());
        veicolos.setDescricao(v.getDescricao());
        veicolos.setImagem(v.getImagem());
        repository.save(veicolos);

    }
}
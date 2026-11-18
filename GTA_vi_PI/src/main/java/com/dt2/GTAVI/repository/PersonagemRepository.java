package com.dt2.GTAVI.repository;

import com.dt2.GTAVI.entities.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem,Integer> {
}

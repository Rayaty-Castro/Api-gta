package com.dt2.GTAVI.repository;

import com.dt2.GTAVI.entities.Veicolos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeicolosRepository extends JpaRepository<Veicolos, Integer>{
}

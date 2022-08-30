package com.miportfolio.christian.Repository;

import com.miportfolio.christian.Entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHabilidades extends JpaRepository<Habilidades, Integer> {
     public Optional<Habilidades>findByPorcentajeH(String porcentajeH);
    public boolean existsByPorcentajeH(Integer porcentajeH); 
    
}

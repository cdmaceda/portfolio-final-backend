package com.miportfolio.christian.Repository;

import com.miportfolio.christian.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia> findByNombreE(String nomnreE);
    public boolean existsByNombreE(String nombreE);
    
}

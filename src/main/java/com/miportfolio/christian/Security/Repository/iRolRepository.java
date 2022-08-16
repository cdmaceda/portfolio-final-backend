package com.miportfolio.christian.Security.Repository;

import com.miportfolio.christian.Security.Entity.Rol;
import com.miportfolio.christian.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}

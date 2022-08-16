package com.miportfolio.christian.Security.Service;

import com.miportfolio.christian.Security.Entity.Rol;
import com.miportfolio.christian.Security.Enums.RolNombre;
import com.miportfolio.christian.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolnombre){
        return irolRepository.findByRolNombre(rolnombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}

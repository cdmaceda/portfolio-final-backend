package com.miportfolio.christian.Service;

import com.miportfolio.christian.Entity.Habilidades;
import com.miportfolio.christian.Repository.RHabilidades;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SHabilidades {
    @Autowired
    RHabilidades rHabilidades;
    
    public List<Habilidades> list(){
        return rHabilidades.findAll();    
    }
    
    public Optional<Habilidades> getOne(int id){
        return rHabilidades.findById(id);    
    }
    
    public Optional<Habilidades>getByPorcentajeH(String porcentajeH){
        return rHabilidades.findByPorcentajeH(porcentajeH);
    }
    
    public void save(Habilidades habilidades){
        rHabilidades.save(habilidades);
    }
    
    public void delete(int id){
        rHabilidades.deleteById(id);
    }
    
    public boolean existsbyId(int id){
        return rHabilidades.existsById(id);
    }
    
    public boolean existsByPorcentajeH(Integer porcentajeH){
        return rHabilidades.existsByPorcentajeH(porcentajeH);
    }
    
}

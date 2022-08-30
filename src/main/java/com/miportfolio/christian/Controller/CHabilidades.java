package com.miportfolio.christian.Controller;

import com.miportfolio.christian.Entity.Habilidades;
import com.miportfolio.christian.Security.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/habilidades")
@CrossOrigin(origins = "http://localHost:4200")
public class CHabilidades {
    @Autowired
    SHabilidades sHabilidades;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list(){
        List<Habilidades> list = sHabilidades.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id){
        if(!sHabilidades.existsbyId(id)){
            return new ResponseEntity(new Mensaje("no existe el Id"), HttpStatus.NOT_FOUND);
        }
         Habilidades habilidades = sHabilidades.getOne(id).get();
        return new ResponseEntity(habilidades, HttpStatus.OK);
    }
       
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sHabilidades.existsbyId(id)) {
            return new ResponseEntity(new Mensaje("No existe esa habilidad"), HttpStatus.NOT_FOUND);
        }
        sHabilidades.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHabilidades dtohabilidades){
        if(StringUtils.isBlank(dtohabilidades.getPorcentajeH())){
            return new ResponseEntity(new Mensaje("El nombre es oligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sHabilidades.existsByPorcentajeH(dtohabilidades.getPorcentajeH())){
            return new ResponseEntity (new Mensaje("Ese habilidades ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Habilidades  habilidades = new Habilidades(dtohabilidades.getPorcentaH(), dtohabilidades.getDescripcionH());
        sHabilidades.save(habilidades);
        return new ResponseEntity(new Mensaje ("Habilidad agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHablidades dtohabilidades){
        //si existe el ID
        if(!sHabilidades.existsbyId(id)){
            return new ResponseEntity(new Mensaje("El ID ingresado no existe"), HttpStatus.NOT_FOUND);
        }
        //Compara nombres
        if(sHabilidades.existsByPorcentajeH(dtohabilidades.getPorcentajeH()) && sHabilidades.getByPorcentajeH(dtohabilidades.getPorcentajeH()).get().getId()!= id){
            return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
        }
        //El nombre no puede estar vacio
        if(StringUtils.isBlank(dtohabilidades.getPorcentajeH())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Habilidades habilidades = sHabilidades.getOne(id).get();
        habilidades.setPorcentajeH(dtohabilidades.getPorcentajeH()); 
        habilidades.setDescripcionH((dtohabilidades.getDescripcionH()));
        
        sHabilidades.save(habilidades);
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
        
    }
    
}

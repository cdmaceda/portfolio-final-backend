package com.miportfolio.christian.InterFace;

import com.miportfolio.christian.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //llamar una lista de usuarios
    public List<Persona> getPersona();
    
    //Guardar un usuario
    public void savePersona(Persona persona);
    
    //Eliminar un usuario por su Id
    public void deletePersona(Long id);
    
    //buscar un usuario por Id
    public Persona findPersona (Long id);
}

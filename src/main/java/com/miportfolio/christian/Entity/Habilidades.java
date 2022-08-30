package com.miportfolio.christian.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Habilidades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int porcentajeH;
    private String descripcionH;

    public Habilidades() {
    }

    public Habilidades(int porcentajeH, String descripcionH) {
        this.porcentajeH = porcentajeH;
        this.descripcionH = descripcionH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPorcentajeH() {
        return porcentajeH;
    }

    public void setPorcentajeH(int porcentajeH) {
        this.porcentajeH = porcentajeH;
    }

    public String getDescripcionH() {
        return descripcionH;
    }

    public void setDescripcionH(String descripcionH) {
        this.descripcionH = descripcionH;
    }
    
    
    
}

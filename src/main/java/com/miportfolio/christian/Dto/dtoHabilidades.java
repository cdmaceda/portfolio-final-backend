package com.miportfolio.christian.Dto;

import javax.validation.constraints.NotBlank;




public class dtoHabilidades {
    @NotBlank
    private int porcentajeH;
    @NotBlank
    private String descripcionH;

    public dtoHabilidades() {
    }

    public dtoHabilidades(int porcentajeH, String descripcionH) {
        this.porcentajeH = porcentajeH;
        this.descripcionH = descripcionH;
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


package br.com.hbsis.padawan.posmanagement.model;

import java.io.Serializable;

public class Endereco implements Serializable {
    String rua;


    public Endereco(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }


    public boolean ruaCampo(){
        return this.rua.isEmpty();
    }

}
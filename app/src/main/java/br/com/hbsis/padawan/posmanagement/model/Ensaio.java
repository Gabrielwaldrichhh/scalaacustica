package br.com.hbsis.padawan.posmanagement.model;


public class Ensaio {
    String Ensaio;

    public String getEnsaio() {
        return Ensaio;
    }

    public void setEnsaio(String Ensaio) {
        this.Ensaio = Ensaio;
    }

    public Ensaio(String Ensaio) {
        this.Ensaio = Ensaio;
    }

    @Override
    public String toString() {
        return getEnsaio();
    }
}

package br.com.hbsis.padawan.posmanagement.model;

public class CDD {
    String CDD;

    public String getCDD() {
        return CDD;
    }

    public void setCDD(String CDD) {
        this.CDD = CDD;
    }

    public CDD(String CDD) {
        this.CDD = CDD;
    }

    @Override
    public String toString() {
        return getCDD();
    }
}
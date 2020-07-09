package br.com.hbsis.padawan.posmanagement.model;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Cliente implements Serializable {

    private String name = "";
    private String email = "";
    private String telefone = "";
    private String identificador = "";
    private String proposta = "";
    private String temperatura = "";
    private String aptoemissor = "";
    private String aptoreceptor = "";
    private String bloco = "";
    private String umidade = "";
    private String obs = "";
    private Endereco endereco = new Endereco("");
    public int id;
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private CDD cdd = new CDD("");
    private Ensaio ensaio = new Ensaio("");



    public Cliente(String name, CDD cdd, Ensaio ensaio, Endereco endereco, String proposta,String temperatura,String aptoemissor,String aptoreceptor,String bloco,String umidade,String obs) {
        this.name = name;
        this.cdd = cdd;
        this.ensaio = ensaio;
        this.endereco = endereco;
        this.proposta = proposta;
        this.temperatura = temperatura;
        this.aptoemissor = aptoemissor;
        this.aptoreceptor = aptoreceptor;
        this.bloco = bloco;
        this.umidade = umidade;
        this.obs = obs;
        this.id = ID_GENERATOR.getAndIncrement();
    }


    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }


    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getAptoemissor() {
        return aptoemissor;
    }

    public void setAptoemissor(String aptoemissor) {
        this.aptoemissor = aptoemissor;
    }

    public String getAptoreceptor() {
        return aptoreceptor;
    }

    public void setAptoreceptor(String aptoreceptor) {
        this.aptoreceptor = aptoreceptor;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getUmidade() {
        return umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public CDD getCdd() {
        return cdd;
    }


    public Cliente() {
        this.setNome(name);
    }


    public Endereco getEndereco() {
        return endereco;
    }


    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public Ensaio getEnsaio() {
        return ensaio;
    }

    public void setEnsaio(Ensaio ensaio) {
        this.ensaio = ensaio;
    }

    public String getProposta() {
        return proposta;
    }

    public void setProposta(String proposta) {
        this.proposta = proposta;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + name + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                ", email='" + email + '\'' +
                ", identificador='" + identificador + '\'' +
                '}';
    }

}

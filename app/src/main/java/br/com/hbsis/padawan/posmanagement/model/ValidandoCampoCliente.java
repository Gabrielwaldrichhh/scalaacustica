package br.com.hbsis.padawan.posmanagement.model;

import java.util.regex.Pattern;

public class ValidandoCampoCliente {

    public boolean nomeCampo(String nome) {
        if (nome.trim().length() > 2){
        return true;
    }
        return false;
    }

    public boolean telefoneCampo(String telefone) {
        if (telefone.trim().length() == 15) {
            return true;
        }
        return false;
    }

    public boolean ruaCampo(String rua) {
        return rua.trim().length() > 3;
    }

    public boolean bairroCampo(String bairro) {
        return bairro.trim().length() > 2;
    }

    public boolean cidadeCampo(String cidade) {
        return cidade.trim().length() > 2;

    }

    public boolean estadoCampo(String estado) {
        return estado.trim().length() == 2;
    }

    public boolean cepCampo(String cep) {
        if (cep.trim().length() == 10) {
            return true;
        }
        return false;
    }
    public boolean cddCampoPreenchido(String cdd) {
        if (cdd.trim().length() != 0) {
            return true;
        }
        return false;
    }

    public boolean emailCampo(String email) {
            String emailregex = "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$";
            Pattern pattern = Pattern.compile(emailregex);
            return pattern.matcher(email).matches();
        }
    }


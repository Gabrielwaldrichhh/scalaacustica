package br.com.hbsis.padawan.posmanagement;

import org.junit.Test;

import br.com.hbsis.padawan.posmanagement.model.ValidandoCampoCliente;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class UnitTestCliente {
    private ValidandoCampoCliente validandoCampoCliente = new ValidandoCampoCliente();


    @Test
    public void deveRetornarNomeValido() {
        String nome = "Felipe";
        boolean resultado = validandoCampoCliente.nomeCampo(nome);
        assertTrue(resultado);
    }


    @Test
    public void deveRetornarNomeInvalidoQuandoTiver2Caracteres() {
        String nome = "Fe";
        boolean resultado = validandoCampoCliente.nomeCampo(nome);
        assertFalse(resultado);
    }

    @Test
    public void deveRetornarNomeInvalidoQuandoTiver1Caracter() {
        String nome = "F";
        boolean resultado = validandoCampoCliente.nomeCampo(nome);
        assertFalse(resultado);
    }

    @Test
    public void deveRetornarNomeInvalido() {
        String nome = "";
        boolean resultado = validandoCampoCliente.nomeCampo(nome);
        assertFalse(resultado);
    }

    @Test
    public void deveRetornarEmailValido_QuandoReceberEmailComBr() {
        String email = "teste.teste@hbsis.com.br";
        boolean resultado = validandoCampoCliente.emailCampo(email);
        assertTrue(resultado);
    }

    @Test
    public void deveRetornarEmailValido_QuandoReceberEmailCom() {
        String email = "teste.teste@hbsis.com";

        boolean resultado = validandoCampoCliente.emailCampo(email);

        assertTrue(resultado);
    }

    @Test
    public void deveRetornarEmailInvalido_QuandoReceberEmailSemArroba() {
        String email = "teste.testehbsis.com.br";

        boolean resultado = validandoCampoCliente.emailCampo(email);

        assertFalse(resultado);
    }

    @Test
    public void deveRetornarTelefoneValido() {
        String telefone = "(47) 9992214578";
        boolean resultado = validandoCampoCliente.telefoneCampo(telefone);
        assertTrue(resultado);
    }

    @Test
    public void deveRetornarTelefoneInvalido() {
        String telefone = "";
        boolean resultado = validandoCampoCliente.telefoneCampo(telefone);
        assertFalse(resultado);
    }

    @Test
    public void deveRetornarRuaValida() {
        String rua = "Rua Carlos Roesel";
        boolean resultado = validandoCampoCliente.ruaCampo(rua);
        assertTrue(resultado);
    }

    @Test
    public void deveRetornarRuaInvalida() {
        String rua = "";
        boolean resultado = validandoCampoCliente.ruaCampo(rua);
        assertFalse(resultado);
    }
    @Test
    public void deveRetornarBairroValido(){
        String bairro = "itoupava central";
        boolean resultado = validandoCampoCliente.bairroCampo(bairro);
        assertTrue(resultado);
    }
    @Test
    public void deveRetornarBairroInvalido(){
        String bairro = "";
        boolean resultado = validandoCampoCliente.bairroCampo(bairro);
        assertFalse(resultado);
    }
    @Test
    public void deveRetornarCidadeValida(){
        String cidade = "Blumenau";
        boolean resultado = validandoCampoCliente.cidadeCampo(cidade);
        assertTrue(resultado);
    }
    @Test
    public void deveRetornarCidadeInvalida(){
        String cidade = "";
        boolean resultado = validandoCampoCliente.cidadeCampo(cidade);
        assertFalse(resultado);
    }
    @Test
    public void deveRetornarCepValido(){
        String cep = "89.069-250";
        boolean resultado = validandoCampoCliente.cepCampo(cep);
        assertTrue(resultado);
    }
    @Test
    public void deveRetornarCepInvalido(){
        String cep = "";
        boolean resultado = validandoCampoCliente.cepCampo(cep);
        assertFalse(resultado);
    }
    @Test
    public void deveRetornarEstadoValido(){
        String estado = "sc";
        boolean resultado = validandoCampoCliente.estadoCampo(estado);
        assertTrue(resultado);
    }
    @Test
    public void deveRetornarEstadoInvalido(){
        String estado = "";
        boolean resultado = validandoCampoCliente.estadoCampo(estado);
        assertFalse(resultado);
    }

    @Test
    public void deveRetornarCDDValido(){
        String cdd = "a";
        boolean resultado = validandoCampoCliente.cddCampoPreenchido(cdd);
        assertTrue(resultado);
    }
    @Test
    public void deveRetornarCDDInvalido(){
        String cdd = "";
        boolean resultado = validandoCampoCliente.cddCampoPreenchido(cdd);
        assertFalse(resultado);
    }

}

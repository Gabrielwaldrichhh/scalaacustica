package br.com.hbsis.padawan.posmanagement.model;

import java.util.ArrayList;
import java.util.Comparator;

import br.com.hbsis.padawan.posmanagement.database.DAO;

public class Repository {
    private static DAO clientDAO = new DAO();

    public static void save(Cliente client) {
        clientDAO.save(client);
    }
    public void remove(Cliente client) {
        clientDAO.remove(client);
    }
    public ArrayList<Cliente> getClient() {
        return clientDAO.getClient();
    }

    public static class Sortbyname implements Comparator<Cliente> {
        public int compare(Cliente o1, Cliente o2) {
            return o1.getNome().compareTo(o2.getNome());
        }
    }

    public void atualizar(Cliente cliente) {
        clientDAO.atualizar(cliente);

    }

    public Cliente getClientById(int Id){
        return clientDAO.getClientById(Id);
    }


}


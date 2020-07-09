package br.com.hbsis.padawan.posmanagement.database;

import java.util.ArrayList;
import java.util.List;

import br.com.hbsis.padawan.posmanagement.model.Cliente;

public class DAO {
    private final static List<Cliente> list = new ArrayList<>();

    public void save(Cliente client) {
        list.add(client);
    }

    public void remove(Cliente client) {
        list.remove(client);
    }

    public ArrayList<Cliente> getClient() {
        return new ArrayList<>(list);
    }


    public void atualizar(Cliente... clientes) {
        for (Cliente clientUpdate : clientes) {
            for (Cliente dbCliente : list) {
                if (dbCliente.getId() == clientUpdate.getId()) {
                    list.set(list.indexOf(dbCliente), clientUpdate);
                }
            }
        }
    }

    public Cliente getClientById(int id) {
        for (Cliente client : list) {
            if (client.getId() == id) {
                return client;
            }

        }
        throw new ArrayIndexOutOfBoundsException("ID não existe");


        }

    }



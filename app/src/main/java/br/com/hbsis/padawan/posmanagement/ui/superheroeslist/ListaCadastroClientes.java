package br.com.hbsis.padawan.posmanagement.ui.superheroeslist;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;

import br.com.hbsis.padawan.posmanagement.R;
import br.com.hbsis.padawan.posmanagement.model.AdapterClientes;
import br.com.hbsis.padawan.posmanagement.model.Cliente;
import br.com.hbsis.padawan.posmanagement.model.Repository;


public class ListaCadastroClientes extends AppCompatActivity implements AdapterClientes.OnClienteListener {
    private RecyclerView rvUser;
    public static String EXTRA_CLIENT_ID = "CLIENTID";
    private AdapterClientes adapterclientes;
    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listacadastroclientes);
        rvUser = findViewById(R.id.recycler_view);

        FloatingActionButton intent = findViewById(R.id.btfloat);
        intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaCadastroClientes.this, Cadastro.class);
                startActivity(intent);
            }
        });
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateClientList();
    }

    private void updateClientList() {
        adapterclientes.setClientes(addSetClient());
    }

    private void initView() {
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvUser.setLayoutManager(linearLayoutManager);
        adapterclientes = new AdapterClientes(new ArrayList<Cliente>(), this);
        rvUser.setAdapter(adapterclientes);
    }

    private ArrayList<Cliente> addSetClient() {
        Repository clientRepository = new Repository();
        if (clientRepository.getClient().isEmpty()) {
            Cliente cliente = new Cliente();
        }
        ArrayList<Cliente> arrayClients = clientRepository.getClient();
        Collections.sort(arrayClients, new Repository.Sortbyname());
        return arrayClients;
    }

    @Override
    public void clickCliente(int id) {
        Intent intent = new Intent(this, Cadastro.class);
        intent.putExtra(EXTRA_CLIENT_ID, id);
        startActivity(intent);
    }









    //Implementar Mapa











    @Override
    public void clickDeletar(final Cliente client ) {
        AlertDialog.Builder msdelet = new AlertDialog.Builder(this);
        msdelet.setTitle("Aviso");
        msdelet.setMessage("Tem certeza que deseja excluir este cliente?");
        msdelet.setCancelable(false);
        msdelet.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                repository = new Repository();
                repository.remove(client);
                adapterclientes.deletar(client);
            }
        });
        msdelet.setNegativeButton("Cancelar", null);
        msdelet.create().show();
    }
}

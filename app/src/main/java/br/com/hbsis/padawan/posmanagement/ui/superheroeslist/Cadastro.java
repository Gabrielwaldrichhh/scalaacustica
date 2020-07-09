package br.com.hbsis.padawan.posmanagement.ui.superheroeslist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import java.util.ArrayList;

import br.com.hbsis.padawan.posmanagement.R;
import br.com.hbsis.padawan.posmanagement.model.CDD;
import br.com.hbsis.padawan.posmanagement.model.Cliente;
import br.com.hbsis.padawan.posmanagement.model.Endereco;
import br.com.hbsis.padawan.posmanagement.model.Ensaio;
import br.com.hbsis.padawan.posmanagement.model.Repository;
import br.com.hbsis.padawan.posmanagement.model.ValidandoCampoCliente;

public class Cadastro extends AppCompatActivity {

    private EditText editTextNome, editTextRua, editTextProposta, editTextTemperatura, editTextReceptor, editTextEmissor, editTextBloco, editTextUmidade, editTextObs;
    private Button botaoSalvar;
    AutoCompleteTextView autoCompleteCdd;
    AutoCompleteTextView autoCompleteEnsaio;
    private Endereco endereco;
    private Repository repository;
    public boolean EhEdicao = false;
    private Cliente cliente, proposta;
    private CDD cdd;
    private Ensaio ensaio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telacadastro);
        autoCompleteCdd = findViewById(R.id.autoCompletarCdd);
        autoCompleteEnsaio = findViewById(R.id.autoCompletarEnsaio);
        repository = new Repository();
        ArrayList<CDD> arrayCDD = addCDDTeste();
        addCDDTeste();
        ArrayList<Ensaio> arrayEnsaio = addEnsaioTeste();
        addCDDTeste();
        inicializarViews();
        iniciarView(arrayCDD);
        iniciarView2(arrayEnsaio);
        System.out.println(arrayCDD.toString());
        salvar();
        verificaParametro();
        editarCliente();

    }

    private void verificaParametro() {
        Bundle bundle = getIntent().getExtras();
        cliente = new Cliente();
        if ((bundle != null) && (bundle.containsKey(ListaCadastroClientes.EXTRA_CLIENT_ID))) {
            EhEdicao = true;
            cliente = repository.getClientById(bundle.getInt(ListaCadastroClientes.EXTRA_CLIENT_ID));
            editTextNome.setText(cliente.getNome());
            autoCompleteCdd.setText(cliente.getCdd().getCDD());
            autoCompleteEnsaio.setText(cliente.getEnsaio().getEnsaio());
            editTextRua.setText(cliente.getEndereco().getRua());
            editTextProposta.setText(cliente.getProposta());
            editTextTemperatura.setText(cliente.getTemperatura());
            editTextEmissor.setText(cliente.getAptoemissor());
            editTextReceptor.setText(cliente.getAptoreceptor());
            editTextBloco.setText(cliente.getBloco());
            editTextUmidade.setText(cliente.getUmidade());
            editTextObs.setText(cliente.getObs());

        }
    }

    private void iniciarView(ArrayList<CDD> cddArrayList) {
        ArrayAdapter<CDD> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, cddArrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        autoCompleteCdd.setAdapter(adapter);
    }
    private void iniciarView2(ArrayList<Ensaio> ensaioArrayList) {
        ArrayAdapter<Ensaio> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, ensaioArrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        autoCompleteEnsaio.setAdapter(adapter);
    }

    private ArrayList<CDD> addCDDTeste() {
        ArrayList<CDD> cdd = new ArrayList<>();
        cdd.add(new CDD("SVVI"));
        cdd.add(new CDD("SVVE"));
        cdd.add(new CDD("RAP"));
        cdd.add(new CDD("RIP"));
        cdd.add(new CDD("HIDRO"));
        cdd.add(new CDD("EQUIP"));

        return cdd;
    }
    private ArrayList<Ensaio> addEnsaioTeste() {
        ArrayList<Ensaio> ensaio = new ArrayList<>();
        ensaio.add(new Ensaio("1"));
        ensaio.add(new Ensaio("2"));
        ensaio.add(new Ensaio("3"));
        ensaio.add(new Ensaio("4"));
        ensaio.add(new Ensaio("5"));
        ensaio.add(new Ensaio("6"));
        ensaio.add(new Ensaio("7"));
        ensaio.add(new Ensaio("8"));
        ensaio.add(new Ensaio("9"));
        ensaio.add(new Ensaio("10"));
        ensaio.add(new Ensaio("11"));
        ensaio.add(new Ensaio("12"));
        ensaio.add(new Ensaio("13"));
        ensaio.add(new Ensaio("14"));
        ensaio.add(new Ensaio("15"));
        ensaio.add(new Ensaio("16"));
        ensaio.add(new Ensaio("17"));
        ensaio.add(new Ensaio("18"));
        ensaio.add(new Ensaio("19"));
        ensaio.add(new Ensaio("20"));
        return ensaio;
    }

    private void inicializarViews() {
        editTextNome = findViewById(R.id.txtNome);
        editTextRua = findViewById(R.id.txtRua);
        autoCompleteCdd = findViewById(R.id.autoCompletarCdd);
        autoCompleteEnsaio = findViewById(R.id.autoCompletarEnsaio);
        editTextProposta = findViewById(R.id.txtProposta);
        editTextTemperatura = findViewById(R.id.txtTemperatura);
        editTextReceptor = findViewById(R.id.txtAptoReceptor);
        editTextEmissor = findViewById(R.id.txtAptoEmissor);
        editTextBloco = findViewById(R.id.txtBloco);
        editTextUmidade = findViewById(R.id.txtUmidade) ;
        editTextObs = findViewById(R.id.txtOBS);
        botaoSalvar = findViewById(R.id.btnSalvar);
    }



    public void salvar() {
        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                repository = new Repository();
                    if (!EhEdicao) {
                        cdd = new CDD(autoCompleteCdd.getText().toString());

                        ensaio = new Ensaio(autoCompleteEnsaio.getText().toString());

                        endereco = new Endereco(editTextRua.getText().toString().trim());

                        cliente = new Cliente(editTextNome.getText().toString().trim(), cdd, ensaio, endereco, editTextProposta.getText().toString().trim(),editTextTemperatura.getText().toString().trim(),editTextEmissor.getText().toString().trim(),editTextReceptor.getText().toString().trim(),editTextBloco.getText().toString().trim(),
                                editTextUmidade.getText().toString().trim(),editTextObs.getText().toString().trim());


                        repository.save(cliente);
                        Toast.makeText(getApplicationContext(), "Cliente " + cliente.getNome() + " adicionado com sucesso", Toast.LENGTH_SHORT).show();
                    } else {
                        cliente.setNome(editTextNome.getText().toString().trim());
                        cliente.getCdd().setCDD(autoCompleteCdd.getText().toString().trim());
                        cliente.getEnsaio().setEnsaio(autoCompleteEnsaio.getText().toString().trim());
                        cliente.getEndereco().setRua(editTextRua.getText().toString());
                        cliente.setProposta(editTextProposta.getText().toString().trim());
                        cliente.setTemperatura(editTextTemperatura.getText().toString().trim());
                        cliente.setAptoemissor(editTextEmissor.getText().toString().trim());
                        cliente.setAptoreceptor(editTextReceptor.getText().toString().trim());
                        cliente.setBloco(editTextReceptor.getText().toString().trim());
                        cliente.setUmidade(editTextUmidade.getText().toString().trim());
                        cliente.setObs(editTextObs.getText().toString().trim());
                        repository.atualizar(cliente);
                        Toast.makeText(getApplicationContext(), "Cliente " + cliente.getNome() + " foi alterado", Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(Cadastro.this, ListaCadastroClientes.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
            }
        });
    }

    public void editarCliente() {
        if (getIntent().hasExtra("Selecionar Cliente!")) {
            int Id = getIntent().getIntExtra("Selecionar Cliente!", 0);
            cliente = repository.getClientById(Id);
            cliente.setNome(editTextNome.getText().toString().trim());
            cliente.getCdd().setCDD(autoCompleteCdd.getText().toString().trim());
            cliente.getEnsaio().setEnsaio(autoCompleteEnsaio.getText().toString().trim());
            cliente.getEndereco().setRua(editTextRua.getText().toString());
            cliente.setProposta(editTextProposta.getText().toString().trim());
            cliente.setTemperatura(editTextTemperatura.getText().toString().trim());
            cliente.setAptoemissor(editTextEmissor.getText().toString().trim());
            cliente.setAptoreceptor(editTextReceptor.getText().toString().trim());
            cliente.setBloco(editTextReceptor.getText().toString().trim());
            cliente.setUmidade(editTextUmidade.getText().toString().trim());
            cliente.setObs(editTextObs.getText().toString().trim());
        }
    }
}
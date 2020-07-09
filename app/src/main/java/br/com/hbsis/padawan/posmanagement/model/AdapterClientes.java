package br.com.hbsis.padawan.posmanagement.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.hbsis.padawan.posmanagement.R;


public class AdapterClientes extends RecyclerView.Adapter<AdapterClientes.ListaClienteViewHolder> {

    private List<Cliente> clientes;
    private OnClienteListener onClienteListener;
    private AdapterView.OnItemClickListener mlistener;

    public AdapterClientes(List<Cliente> clientes, OnClienteListener onClienteListener) {
        this.clientes = clientes;
        this.onClienteListener = onClienteListener;
    }

    public void setOnClickLitener(AdapterView.OnItemClickListener listener){
        mlistener = listener;
    }
    @NonNull
    @Override
    public ListaClienteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cliente, parent, false);
        return new ListaClienteViewHolder(view,mlistener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaClienteViewHolder holder, int posicao) {
        holder.nomeCliente.setText(clientes.get(posicao).getNome());
    }

    @Override
    public int getItemCount() {
        return clientes != null ? clientes.size() : 0;

    }

    public void setClientes(ArrayList<Cliente> arrayClients) {
        this.clientes = arrayClients;
        notifyDataSetChanged();
    }
    public void deletar(Cliente client){
        int index = clientes.indexOf(client);
        clientes.remove(index);
        notifyItemRemoved(index);
    }

    public class ListaClienteViewHolder extends RecyclerView.ViewHolder{

        private TextView nomeCliente;
        private ImageView deletar;

        public ListaClienteViewHolder(@NonNull View itemView, final AdapterView.OnItemClickListener listener) {
            super(itemView);
            nomeCliente = itemView.findViewById(R.id.text_cliente);
            deletar = itemView.findViewById(R.id.imagemDeletar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClienteListener.clickCliente(clientes.get(getAdapterPosition()).getId());
                }
            });

            deletar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClienteListener.clickDeletar(clientes.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnClienteListener {
        void clickCliente(int id);
        void clickDeletar(Cliente cliente);
    }
}



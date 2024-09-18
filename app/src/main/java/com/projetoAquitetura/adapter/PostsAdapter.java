package com.projetoAquitetura.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.projetoAquitetura.databinding.PostFuncionarioBinding;
import com.projetoAquitetura.model.Funcionario;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.FuncionarioVH> {
    private final ArrayList<Funcionario> listaFuncionario;
    private final Context context;

    public PostsAdapter(ArrayList<Funcionario> listaFuncionario, Context context) {
        this.listaFuncionario = listaFuncionario;
        this.context = context;
    }

    @NonNull
    @Override
    public FuncionarioVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostFuncionarioBinding funcionarioItem;
        funcionarioItem = PostFuncionarioBinding.inflate(LayoutInflater.from(context), parent, false);
        return new FuncionarioVH(funcionarioItem);
    }

    @Override
    public int getItemCount() {
        return listaFuncionario.size();
    }

    @Override
    public void onBindViewHolder(@NonNull FuncionarioVH holder, int position) {
        Funcionario funcionario = listaFuncionario.get(position);

        // Verifica se os valores não são nulos antes de definir o texto
        if (funcionario.getIdefuncionario() != null) {
            holder.binding.txtIdFuncionarios.setText("CODIGO: "+funcionario.getIdefuncionario().toString());
        }
        if (funcionario.getNomfuncionario() != null) {
            holder.binding.txtNomeFuncionarios.setText("NOME: "+funcionario.getNomfuncionario());
        }
        if (funcionario.getDesemail() != null) {
            holder.binding.txtEmailFuncionarios.setText("E-mail: "+funcionario.getDesemail());
        }
        if (funcionario.getNrotelefone() != null) {
            holder.binding.txtTelefoneFuncionarios.setText("TELEFONE: "+funcionario.getNrotelefone());
        }
        if (funcionario.getDeslogin() != null) {
            holder.binding.txtLoginFuncionarios.setText("LOGIN: "+funcionario.getDeslogin());
        }
    }

    public static class FuncionarioVH extends RecyclerView.ViewHolder {
        PostFuncionarioBinding binding;

        public FuncionarioVH(PostFuncionarioBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

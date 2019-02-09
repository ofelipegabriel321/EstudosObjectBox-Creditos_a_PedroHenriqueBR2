package com.example.estudoobjectbox.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.estudoobjectbox.R;
import com.example.estudoobjectbox.models.Data;

import org.w3c.dom.Text;

import java.util.List;

// Vai adaptar um Layout para uma View (inflando)
// OBS: Vai usar muito Alt Enter aqui!!!
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private Context context;
    private List<Data> datas;

    public DataAdapter(Context context, List<Data> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Serve para Inflar a View e devolver a classe ViewHolder
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_data, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int posicao) {
        // primeiro ele pega um objeto Data da lista em determinada posição posicao
        Data data = datas.get(posicao);

        // agora ele obtem o atributo data de data
        String strData = data.getData();

        // faz com que o txtData do ViewHolder receba o valor de strData
        viewHolder.txtData.setText(strData);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Bind
            txtData = itemView.findViewById(R.id.txt_data);
        }
    }
}

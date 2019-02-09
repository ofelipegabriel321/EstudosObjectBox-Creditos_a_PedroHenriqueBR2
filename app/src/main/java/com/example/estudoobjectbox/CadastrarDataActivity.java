package com.example.estudoobjectbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.estudoobjectbox.dal.App;
import com.example.estudoobjectbox.models.Data;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class CadastrarDataActivity extends AppCompatActivity {
    BoxStore store;
    Box<Data> dataBox;
    EditText txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_data);

        store = ((App) getApplication()).getBoxStore();
        dataBox = store.boxFor(Data.class);

        // bind
        txtData = findViewById(R.id.txt_data_cadastro);
    }

    public void salvar(View view){
        String strData = txtData.getText().toString().trim();

        if (!strData.isEmpty()) {
            Data data = new Data(strData);
            // salva o objeto data dentro do box do ObjectBox

            dataBox.put(data);

            // o Intent serve para mudar de Activity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

package com.example.estudoobjectbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.estudoobjectbox.Adapter.DataAdapter;
import com.example.estudoobjectbox.dal.App;
import com.example.estudoobjectbox.models.Data;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvDatas;
    private Box<Data> dataBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Bind: fazer a ligação do rvDatas ao Recycler View do Layout
        rvDatas = findViewById(R.id.rv_datas);

        // instancia o ObjectBox na classe
        // acessa o App e pega o BoxStore
        BoxStore store = ((App) getApplication()).getBoxStore();
        // utiliza o boxStore para buscar todos os elementos da classe Data... o que estiver
        // salvo da classe Data ele vai pegar
        // esse .class é porque ele fará isso em tempo de execução
        dataBox = store.boxFor(Data.class);

        // Preencher o RecycleView com dados
        List<Data> dataList = dataBox.getAll();
        DataAdapter adapter = new DataAdapter(this, dataList);

        // Atribui ao RecyclerView os dados do DataAdapter que foi instanciado no adapter
        rvDatas.setAdapter(adapter);
        // Seta de que forma o layout do RecyclerView será exibido
        rvDatas.setLayoutManager(new LinearLayoutManager(this));

        // Botão flutuante, criado pelo AndroidStudio
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivityCadastrar();
            }
        });
    }

    private void abrirActivityCadastrar(){
        Intent intent = new Intent(this, CadastrarDataActivity.class);
        startActivity(intent);
        finish();
    }

    // Menu criado automaticamente pelo AndroidStudio porque foi um Blank Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Menu criado automaticamente pelo AndroidStudio porque foi um Blank Activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

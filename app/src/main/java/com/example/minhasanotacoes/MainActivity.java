package com.example.minhasanotacoes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editAnotacao;
    private AnotacoesPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = new AnotacoesPreferences(getApplicationContext());

        this.editAnotacao = findViewById(R.id.editAnotacao);

        if ( !preferences.obterAnotacao().equals("") ) {
            editAnotacao.setText(preferences.obterAnotacao());
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String anotacao = editAnotacao.getText().toString();

                if ( anotacao.equals("") ) {
                    Snackbar.make(view, "Favor inserir alguma anotação!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    preferences.salvar(anotacao);

                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }
}
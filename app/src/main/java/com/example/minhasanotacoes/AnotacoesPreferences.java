package com.example.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacoesPreferences {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private static final String PREFERENCES_FILENAME = "preference.anotacao";
    private static final String PREFERENCE_KEY = "anotacao";

    public AnotacoesPreferences(Context context) {
        this.context = context;
        this.preferences = preferences = context.getSharedPreferences("", 0);
        this.editor = preferences.edit();
    }

    public String obterAnotacao() {
        return this.preferences.getString(PREFERENCE_KEY, "");
    }

    public void salvar(String anotacao) {
        this.editor.putString(PREFERENCE_KEY, anotacao);
        this.editor.commit();
    }

}

package com.projetoAquitetura;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SocialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        // Botão Instagram
        ImageButton btnInstagram = findViewById(R.id.btnInstagram);
        btnInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("https://www.instagram.com/barbaram.arquiteta");
            }
        });

        // Botão Portfólio
        ImageButton btnPortfolio = findViewById(R.id.btnPortfolio);
        btnPortfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("https://bit.ly/PortfólioProjetosBárbara");
            }
        });

        // Botão YouTube
        ImageButton btnYoutube = findViewById(R.id.btnYoutube);
        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("https://m.youtube.com/channel/UCdlqj9Ol3CPO2NHw04sqNKw?sub_confirmation=1");
            }
        });

        // Botão LinkedIn
        ImageButton btnLinkedin = findViewById(R.id.btnLinkedin);
        btnLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("https://www.linkedin.com/in/b%C3%A1rbara-monteiro-991608186/");
            }
        });
    }

    // Método para abrir o link no navegador
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}

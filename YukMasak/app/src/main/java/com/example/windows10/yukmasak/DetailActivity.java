package com.example.windows10.yukmasak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class DetailActivity extends AppCompatActivity {
    //deklrasi global objek
    WebView webView;

    //pada method on create diberikan intent untuk menuju layout judul masakan yang diinginka sesuai nama judul yang dipilih
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        DataModel dataModel= (DataModel) bundle.getSerializable("dataModel");
        // setting judul bar
        setTitle(dataModel.getJudul());

        //tampil data konten
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/"+dataModel.getKonten());
    }
}

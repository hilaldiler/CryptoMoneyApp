package com.hilal.cryptomoneyapp.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hilal.cryptomoneyapp.R;
import com.hilal.cryptomoneyapp.adapter.CryptoAdapter;
import com.hilal.cryptomoneyapp.model.Crypto;
import com.hilal.cryptomoneyapp.service.CryptoAPI;
import com.hilal.cryptomoneyapp.service.RetrofitClientInstance;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CryptoDescriptionActivity extends AppCompatActivity {

    Crypto crypto = new Crypto();
    TextView txtCryptoName = findViewById(R.id.cryptoName);
    TextView cryptoDesc = findViewById(R.id.cryptoDesc);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_description);

        //String name = getIntent().getExtras().getString("name");
        //txtCryptoName.setText(name);





        }


}

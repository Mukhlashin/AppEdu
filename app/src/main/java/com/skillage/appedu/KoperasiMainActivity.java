package com.skillage.appedu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.skillage.appedu.fragments.LogbookFragment;
import com.skillage.appedu.fragments.ManagementFragment;
import com.skillage.appedu.fragments.MarketplaceFragment;
import com.skillage.appedu.fragments.StockFragment;

public class KoperasiMainActivity extends AppCompatActivity {
    TextView txtHasil;
    Button btnMarketplace, btnLogbook, btnManagement, btnStock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koperasi_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

//        txtHasil= findViewById(R.id.txtHasil);
        btnMarketplace = findViewById(R.id.btn_marketplace);
        btnLogbook = findViewById(R.id.btn_logbook);
        btnManagement = findViewById(R.id.btn_management);
        btnStock = findViewById(R.id.btn_stock);

        btnMarketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, MarketplaceFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("")
                        .commit();
            }
        });

        btnLogbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, LogbookFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("")
                        .commit();
            }
        });

        btnManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, ManagementFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("")
                        .commit();
            }
        });

        btnStock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, StockFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("")
                        .commit();
            }
        });

        DBAndroid db=new DBAndroid();
        db.getRecords("Select * from kop_barang");
        for (int i=0; i<=db.Records.size()-1; i++) {
            String nama_barang = db.Records.get(i).get("nama_barang");
            String kode_supplier = db.Records.get(i).get("kode_supplier");

//            txtHasil.setText(nama_barang);
        }
    }
}
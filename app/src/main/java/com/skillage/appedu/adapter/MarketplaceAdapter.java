package com.skillage.appedu.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.skillage.appedu.DBAndroid;
import com.skillage.appedu.GlobalFunction;
import com.skillage.appedu.GlobalVar;
import com.skillage.appedu.LoginActivity;
import com.skillage.appedu.R;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceAdapter extends RecyclerView.Adapter<MarketplaceAdapter.ViewHolder> {

    private Context context;
    private String namaBarang, hargaBarang, soldBarang;
    private Image imgBarang;

    public MarketplaceAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MarketplaceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.marketplace_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        DBAndroid db=new DBAndroid();
        String SQL= "Select * from kop_barang";
        db.getRecords(SQL);
        for (int i=0; i<=db.Records.size()-1; i++) {
            namaBarang=db.Records.get(i).get("nama_barang");
            hargaBarang=db.Records.get(i).get("harga");
            soldBarang="soldbarang";
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MarketplaceAdapter.ViewHolder holder, int position) {
        holder.txtNama.setText(namaBarang);
        holder.txtHarga.setText(hargaBarang);
        holder.txtSold.setText(soldBarang);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item Selected", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        DBAndroid db=new DBAndroid();
        String SQL= "Select * from kop_barang";
        db.getRecords(SQL);
        return db.Records.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNama,txtHarga, txtSold;
        private ImageView imgFoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txt_nama_barang);
            txtHarga = itemView.findViewById(R.id.txt_harga_barang);
            txtSold = itemView.findViewById(R.id.txt_sold_barang);
            imgFoto = itemView.findViewById(R.id.img_foto_barang);
        }
    }
}
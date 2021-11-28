package com.example.asus.ublib_admin.View.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.ublib_admin.Interface.DetailBukuInterface;
import com.example.asus.ublib_admin.Model.DetailResource;
import com.example.asus.ublib_admin.Model.DetailResponse;
import com.example.asus.ublib_admin.R;
import com.example.asus.ublib_admin.Service.Config;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailBukuActivity extends AppCompatActivity {

    TextView btnEdit;

    TextView txtJudul, txtPengarang, txtJenis, txtDeskripsi, txtStatus;
    ImageView imgBuku;

    List<DetailResource> detail = new ArrayList<>();
    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

        txtJudul = findViewById(R.id.text_judul_buku);
        txtPengarang = findViewById(R.id.text_pengarang_buku);
        txtJenis = findViewById(R.id.text_jenis_buku);
        txtDeskripsi = findViewById(R.id.text_desc_buku);
        imgBuku = findViewById(R.id.img_buku);

        btnEdit = findViewById(R.id.btn_edit_buku);

        Intent intent = getIntent();
        final String id = intent.getStringExtra("id_buku");
        Log.d("dataaaaa", "id_buku = "+id);
        sharedPreferences = getSharedPreferences(KEYPREF, MODE_PRIVATE);
        SharedPreferences.Editor data = sharedPreferences.edit();
        data.putString("id_buku", id);
        data.commit();
        data.apply();

        DetailBukuInterface detailBukuInterface = Config.builder(DetailBukuActivity.this)
                .create(DetailBukuInterface.class);
        Call<DetailResponse> detaikKendaraan = detailBukuInterface.detail(id);
        detaikKendaraan.enqueue(new Callback<DetailResponse>() {
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response) {
                Log.d("dataaaaa", "masuk response");
                detail = response.body().getSuccess();
                Log.d("dataaaaa", "data = "+detail);
                if (detail != null){

                    Glide.with(DetailBukuActivity.this)
                            .load("http://192.168.1.3/ublib/public/uploads/file/"+detail.get(0).getGambar().toString())
                            .into(imgBuku);
                    txtJudul.setText(detail.get(0).getJudul().toString());
                    txtPengarang.setText(detail.get(0).getPengarang().toString());
                    txtJenis.setText(detail.get(0).getJenis().toString());
                    txtDeskripsi.setText(detail.get(0).getDeskripsi().toString());

                }

            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t) {

            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(DetailBukuActivity.this, EditBukuActivity.class);
                startActivity(edit);
            }
        });
    }
}

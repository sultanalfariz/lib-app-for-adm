package com.example.asus.ublib_admin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asus.ublib_admin.Interface.StatusPemesananInterface;
import com.example.asus.ublib_admin.Model.PeminjamanVerifyResource;
import com.example.asus.ublib_admin.Model.StatusPemesanan;
import com.example.asus.ublib_admin.Model.StatusPemesananResource;
import com.example.asus.ublib_admin.Model.StatusPemesananResponse;
import com.example.asus.ublib_admin.R;
import com.example.asus.ublib_admin.Service.Config;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListPeminjamanVerifyAdapter  extends RecyclerView.Adapter<ListPeminjamanVerifyAdapter.PeminjamanVerifyViewHolder> {

    Context context;
    List<PeminjamanVerifyResource> pinjam;

    StatusPemesanan mPemesanan = new StatusPemesanan();

    public ListPeminjamanVerifyAdapter(Context context, List<PeminjamanVerifyResource> pinjam){
        this.context = context;
        this.pinjam = pinjam;
    }

    @NonNull
    @Override
    public PeminjamanVerifyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutList = LayoutInflater.from(context).inflate(R.layout.item_peminjaman_verify, parent, false);
        PeminjamanVerifyViewHolder peminjamanVerifyViewHolder = new PeminjamanVerifyViewHolder(layoutList);

        return peminjamanVerifyViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PeminjamanVerifyViewHolder holder, final int position) {
        Glide.with(context)
                .load("http://192.168.1.3/ublib/public/uploads/file/"+pinjam.get(position).getGambar().toString())
                .into(holder.imgBuku);
        holder.txtJudul.setText(pinjam.get(position).getJudul().toString());
        holder.txtPengarang.setText(pinjam.get(position).getNama().toString());
        holder.txtJenis.setText(pinjam.get(position).getNim().toString());
        holder.txtStatus.setText(pinjam.get(position).getStatusPeminjaman().toString());
        holder.txtTanggal.setText(pinjam.get(position).getId().toString());

        holder.btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String sPemesanan = "Selesai";
//                mPemesanan.setStatusPemesanan(sPemesanan);
//                Log.d("dataaaaa", "mPemesanan "+mPemesanan.getStatusPemesanan().toString());

                String id = pinjam.get(position).getId().toString();
                Log.d("dataaaaa", "id pesan "+id);

                StatusPemesananInterface statusPemesananInterface = Config.builder(context)
                        .create(StatusPemesananInterface.class);
                Call<StatusPemesananResponse> ubahPesan = statusPemesananInterface.statusPemesanan(id, mPemesanan);
                ubahPesan.enqueue(new Callback<StatusPemesananResponse>() {
                    @Override
                    public void onResponse(Call<StatusPemesananResponse> call, Response<StatusPemesananResponse> response) {
                        Log.d("dataaaaaa", "mauk response 2");
                        StatusPemesananResource mstatus = response.body().getSuccess();
                        Log.d("dataaaaaa", "resp = "+mstatus);

                        if (mstatus != null){

                            Toast.makeText(context, "Berhasil", Toast.LENGTH_LONG).show();

                        }

                    }

                    @Override
                    public void onFailure(Call<StatusPemesananResponse> call, Throwable t) {

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return pinjam.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class PeminjamanVerifyViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView imgBuku;
        TextView txtJudul, txtPengarang, txtJenis, txtStatus, txtTanggal, btnSelesai;
        CardView itemBuku;

        public PeminjamanVerifyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBuku =itemView.findViewById(R.id.gambar_buku);
            txtJudul = itemView.findViewById(R.id.text_judul_buku);
            txtPengarang = itemView.findViewById(R.id.text_nama_user);
            txtJenis = itemView.findViewById(R.id.text_nim);
            txtStatus = itemView.findViewById(R.id.text_status_peminjaman);
            txtTanggal = itemView.findViewById(R.id.text_kode_peminjaman);

            btnSelesai = itemView.findViewById(R.id.btn_selesai);
        }
    }
}
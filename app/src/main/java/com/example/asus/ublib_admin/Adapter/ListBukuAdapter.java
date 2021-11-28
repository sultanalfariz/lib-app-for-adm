package com.example.asus.ublib_admin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.ublib_admin.Model.ListBukuResource;
import com.example.asus.ublib_admin.R;
import com.example.asus.ublib_admin.View.Activity.DetailBukuActivity;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class ListBukuAdapter extends RecyclerView.Adapter<ListBukuAdapter.BukuViewHolder> {

    Context context;
    List<ListBukuResource> buku;

    public ListBukuAdapter(Context context, List<ListBukuResource> buku) {
        this.context = context;
        this.buku = buku;
    }

    @NonNull
    @Override
    public BukuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutList = LayoutInflater.from(context).inflate(R.layout.item_buku, parent, false);
        BukuViewHolder kendaraanViewHolder = new BukuViewHolder(layoutList);

        return kendaraanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BukuViewHolder holder, final int position) {
        Glide.with(context)
                .load("http://192.168.1.3/ublib/public/uploads/file/" + buku.get(position).getGambar().toString())
                .into(holder.imgBuku);
        holder.txtJudul.setText(buku.get(position).getJudul().toString());
        holder.txtPengarang.setText(buku.get(position).getPengarang().toString());
        holder.txtJenis.setText(buku.get(position).getJenis().toString());
        holder.txtStatus.setText(buku.get(position).getStatus().toString());

        holder.itemBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailBukuActivity.class);
                intent.putExtra("id_buku", buku.get(position).getId().toString());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return buku.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class BukuViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView imgBuku;
        TextView txtJudul, txtPengarang, txtJenis, txtStatus;
        CardView itemBuku;

        public BukuViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBuku = itemView.findViewById(R.id.gambar_buku);
            txtJudul = itemView.findViewById(R.id.text_judul_buku);
            txtPengarang = itemView.findViewById(R.id.text_pengarang_buku);
            txtJenis = itemView.findViewById(R.id.text_jenis_buku);
            txtStatus = itemView.findViewById(R.id.text_status_buku);

            itemBuku = itemView.findViewById(R.id.card_buku);
        }
    }
}

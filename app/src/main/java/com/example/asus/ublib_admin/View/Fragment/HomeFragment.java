package com.example.asus.ublib_admin.View.Fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.ublib_admin.Adapter.ListBukuAdapter;
import com.example.asus.ublib_admin.Interface.ListBukuInterface;
import com.example.asus.ublib_admin.Model.ListBukuResource;
import com.example.asus.ublib_admin.Model.ListBukuResponse;
import com.example.asus.ublib_admin.Service.Config;
import com.example.asus.ublib_admin.View.Activity.DetailBukuActivity;
import com.example.asus.ublib_admin.View.Activity.TambahBukuActivity;
import com.example.asus.ublib_admin.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView rvListBuku;
    ImageView btnAddBook;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferencesId;

    List<ListBukuResource> buku = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View homeFrg = inflater.inflate(R.layout.fragment_home, container, false);

        btnAddBook = homeFrg.findViewById(R.id.btn_tambah_buku);

        rvListBuku = homeFrg.findViewById(R.id.rv_list_buku);

        sharedPreferencesId = getActivity().getSharedPreferences(KEYPREF, getContext().MODE_PRIVATE);
        String id = sharedPreferencesId.getString("id_user", null);
        Log.d("dataaaa", "id = "+id);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvListBuku.setLayoutManager(linearLayoutManager);

        ListBukuInterface listKendaraanInterface = Config.builder(getContext())
                .create(ListBukuInterface.class);
        Call<ListBukuResponse> listBuku = listKendaraanInterface.buku();
        listBuku.enqueue(new Callback<ListBukuResponse>() {
            @Override
            public void onResponse(Call<ListBukuResponse> call, Response<ListBukuResponse> response) {
                Log.d("dataaaa", "masuk");
                buku = response.body().getSuccess();
                Log.d("dataaaa", "kendaraan = "+buku);
                if (buku != null){
                    ListBukuAdapter listBukuAdapter = new ListBukuAdapter(getContext(), buku);
                    rvListBuku.setAdapter(listBukuAdapter);
                    listBukuAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<ListBukuResponse> call, Throwable t) {

            }
        });

        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tambah = new Intent(getActivity(), TambahBukuActivity.class);
                startActivity(tambah);
            }
        });

        return homeFrg;
    }

}

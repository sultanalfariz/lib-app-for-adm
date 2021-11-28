package com.example.asus.ublib_admin.View.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.ublib_admin.Adapter.ListPeminjamanVerifyAdapter;
import com.example.asus.ublib_admin.Interface.ListPeminjamanVerifyInterface;
import com.example.asus.ublib_admin.Model.PeminjamanVerifyResource;
import com.example.asus.ublib_admin.Model.PeminjamanVerifyResponse;
import com.example.asus.ublib_admin.R;
import com.example.asus.ublib_admin.Service.Config;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPeminjamanVerifyFragment extends Fragment {

    RecyclerView rvPeminjaman;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferencesId;

    List<PeminjamanVerifyResource> pinjam = new ArrayList<>();

    public ListPeminjamanVerifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View peminjamanFrg = inflater.inflate(R.layout.fragment_list_peminjaman_verify, container, false);

        rvPeminjaman = peminjamanFrg.findViewById(R.id.rv_list_peminjaman_verify);

        sharedPreferencesId = getActivity().getSharedPreferences(KEYPREF, getContext().MODE_PRIVATE);
        String id = sharedPreferencesId.getString("id_user", null);
        Log.d("dataaaa", "id = "+id);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvPeminjaman.setLayoutManager(linearLayoutManager);

        ListPeminjamanVerifyInterface listPeminjamanVerifyInterface = Config.builder(getContext())
                .create(ListPeminjamanVerifyInterface.class);
        Call<PeminjamanVerifyResponse> listBuku = listPeminjamanVerifyInterface.peminjamanVerify();
        listBuku.enqueue(new Callback<PeminjamanVerifyResponse>() {
            @Override
            public void onResponse(Call<PeminjamanVerifyResponse> call, Response<PeminjamanVerifyResponse> response) {
                Log.d("dataaaa", "masuk");
                pinjam = response.body().getSuccess();
                Log.d("dataaaa", "kendaraan = "+pinjam);
                if (pinjam != null){
                    ListPeminjamanVerifyAdapter listPeminjamanAdapter = new ListPeminjamanVerifyAdapter(getContext(), pinjam);
                    rvPeminjaman.setAdapter(listPeminjamanAdapter);
                    listPeminjamanAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<PeminjamanVerifyResponse> call, Throwable t) {

            }
        });
        return peminjamanFrg;
    }

}

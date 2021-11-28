package com.example.asus.ublib_admin.View.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asus.ublib_admin.Model.LoginResponse;
import com.example.asus.ublib_admin.R;
import com.example.asus.ublib_admin.View.Activity.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    RelativeLayout btnLogout;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View accFrg = inflater.inflate(R.layout.fragment_account, container, false);

        btnLogout = accFrg.findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keluar = new Intent(getActivity(), LoginActivity.class);
                startActivity(keluar);
            }
        });

        return accFrg;
    }

}

package com.example.asus.ublib_admin.View.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.asus.ublib_admin.View.Fragment.AccountFragment;
import com.example.asus.ublib_admin.View.Fragment.HomeFragment;
import com.example.asus.ublib_admin.View.Fragment.ListPeminjamanFragment;
import com.example.asus.ublib_admin.View.Fragment.ListPeminjamanVerifyFragment;
import com.example.asus.ublib_admin.R;

public class MainActivity extends AppCompatActivity {

    RelativeLayout btnHome, btnPinjaman, btnPinVerify, btnAccount;
    ImageView icHome, icPinjaman, icPinVerify, icAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome = findViewById(R.id.btn_home);
        btnPinjaman = findViewById(R.id.btn_pinjaman);
        btnPinVerify = findViewById(R.id.btn_pinjaman_verify);
        btnAccount = findViewById(R.id.btn_account);

        icHome = findViewById(R.id.icon_home);
        icPinjaman = findViewById(R.id.icon_pinjaman);
        icPinVerify = findViewById(R.id.icon_pinjaman_verify);
        icAccount = findViewById(R.id.icon_akun);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new HomeFragment());
                icHome.setImageResource(R.drawable.ic_home_klik);
                icPinjaman.setImageResource(R.drawable.ic_list);
                icPinVerify.setImageResource(R.drawable.ic_list_verify);
                icAccount.setImageResource(R.drawable.ic_account);
            }
        });

        btnPinjaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new ListPeminjamanFragment());
                icPinjaman.setImageResource(R.drawable.ic_list_klik);
                icPinVerify.setImageResource(R.drawable.ic_list_verify);
                icAccount.setImageResource(R.drawable.ic_account);
                icHome.setImageResource(R.drawable.ic_home);
            }
        });

        btnPinVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new ListPeminjamanVerifyFragment());
                icPinVerify.setImageResource(R.drawable.ic_list_verify_klik);
                icPinjaman.setImageResource(R.drawable.ic_list);
                icHome.setImageResource(R.drawable.ic_home);
                icAccount.setImageResource(R.drawable.ic_account);
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new AccountFragment());
                icAccount.setImageResource(R.drawable.ic_account_klik);
                icPinjaman.setImageResource(R.drawable.ic_list);
                icPinVerify.setImageResource(R.drawable.ic_list_verify);
                icHome.setImageResource(R.drawable.ic_home);
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }

    }

    private void  loadFragment(Fragment fragment){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}

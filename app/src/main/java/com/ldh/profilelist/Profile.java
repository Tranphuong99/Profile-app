package com.ldh.profilelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Profile extends AppCompatActivity {
    MenuView.ItemView item;
    NavigationView navigationView ;
    TextView name,username;
    ImageView avatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        name = findViewById(R.id.txtView_name);
        username = findViewById(R.id.txtView_username);
        avatar = findViewById(R.id.avatar);
        name.setText(intent.getStringExtra("name")+"");
        username.setText(intent.getStringExtra("username")+"");
        int img = intent.getIntExtra("avatar",0);
        avatar.setImageResource(img);
        Log.v("TAG",intent.getIntExtra("avatar",0)+"");
        navigationView = findViewById(R.id.navigationView);
        Menu menu = navigationView.getMenu();
        String email = intent.getStringExtra("email")+"";
        menu.findItem(R.id.inf_email).setTitle(email);
        menu.findItem(R.id.inf_house).setTitle(intent.getStringExtra("address_suite")+", "+intent.getStringExtra("address_street")+", "+intent.getStringExtra("address_city"));
        menu.findItem(R.id.inf_zipcode).setTitle(intent.getStringExtra("address_zipcode"));
        menu.findItem(R.id.inf_x).setTitle(intent.getStringExtra("address_geo_lat"));
        menu.findItem(R.id.inf_y).setTitle(intent.getStringExtra("address_geo_lng"));
        menu.findItem(R.id.inf_phone).setTitle(intent.getStringExtra("phone"));
        menu.findItem(R.id.inf_website).setTitle(intent.getStringExtra("website"));
        menu.findItem(R.id.inf_company_name).setTitle("Name: "+intent.getStringExtra("company_name"));
        menu.findItem(R.id.inf_company_catchPhrase).setTitle("Catch phrase: "+intent.getStringExtra("company_catchPhrase"));
        menu.findItem(R.id.inf_company_bs).setTitle("Bs: "+intent.getStringExtra("company_bs"));
    }
}

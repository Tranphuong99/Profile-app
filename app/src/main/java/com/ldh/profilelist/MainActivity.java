package com.ldh.profilelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements ProfileClickListener{
    private List<Person> persons = new ArrayList<>();
    private RecyclerView recyclerView;
    String str;
    JSONArray jArr;
    List<Integer> imgList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgList = new ArrayList<>();
        imgList.add(new Integer(R.drawable.anh_1));
        imgList.add(new Integer(R.drawable.anh_2));
        imgList.add(new Integer(R.drawable.anh_3));
        imgList.add(new Integer(R.drawable.anh_4));
        imgList.add(new Integer(R.drawable.anh_5));
        imgList.add(new Integer(R.drawable.anh_6));
        imgList.add(new Integer(R.drawable.anh_7));
        imgList.add(new Integer(R.drawable.anh_8));
        imgList.add(new Integer(R.drawable.anh_9));
        imgList.add(new Integer(R.drawable.anh_10));

        new ReadJSONObject().execute("https://lebavui.github.io/jsons/users.json");
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.main_constraintLayout).setBackgroundResource(R.drawable.custom_layout);
                try {
             jArr = new JSONArray(str);
            for (int i=0;i<jArr.length();i++)
            {
                JSONObject j = jArr.getJSONObject(i);
                int id = j.getInt("id");
                String name = j.getString("name");
                String username = j.getString("username");
                String email = j.getString("email");
                int avatar = imgList.get(i).intValue();
                JSONObject address = j.getJSONObject("address");
                String address_street = address.getString("street");
                String address_suite = address.getString("suite");
                String address_city = address.getString("city");
                String address_zipcode = address.getString("zipcode");
                JSONObject geo = address.getJSONObject("geo");
                String address_geo_lat = geo.getString("lat");
                String address_geo_lng = geo.getString("lng");
                String phone = j.getString("phone");
                String website = j.getString("website");
                JSONObject company = j.getJSONObject("company");
                String company_name = company.getString("name");
                String company_catchPhrase = company.getString("catchPhrase");
                String company_bs = company.getString("bs");
                persons.add(new Person(id,
                        avatar,
                        name,
                        username,
                        email,
                        address_street,
                        address_suite,
                        address_city,
                        address_zipcode,
                        address_geo_lat,
                        address_geo_lng,
                        phone,
                        website,
                        company_name,
                        company_catchPhrase,
                        company_bs));
                               Log.v("TAG",id+" "+name+" "+email+" "+company_name+" "+company_catchPhrase);
                recyclerView = findViewById(R.id.recycleView_profile_list);
                recyclerView.setHasFixedSize(true);
                ProfileAdapter adapter = new ProfileAdapter(persons,
                        MainActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                        MainActivity.this,
                        LinearLayoutManager.VERTICAL,
                        false
                );
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
            }
        });
      //====================================================================================================================


    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getApplicationContext(),persons.get(position).getName()+" profile is clicked",Toast.LENGTH_SHORT).show();


        String name = persons.get(position).getName();

        String username = persons.get(position).getUsername();
        String email = persons.get(position).getEmail();
        int avatar = persons.get(position).getAvatar();
        String address_street = persons.get(position).getAddress_street();

        String address_suite = persons.get(position).getAddress_suite();

        String address_city = persons.get(position).getAddress_city();

        String address_zipcode = persons.get(position).getAddress_zipcode();

        String address_geo_lat = persons.get(position).getAddress_geo_lat();

        String address_geo_lng = persons.get(position).getAddress_geo_lng();
        String phone = persons.get(position).getPhone();
        String website = persons.get(position).getWebsite();
        String company_name = persons.get(position).getCompany_name();
        String company_catchPhrase = persons.get(position).getCompany_catchPhrase();
        String company_bs = persons.get(position).getCompany_bs();

        Log.v("TAG","email "+email);
        openProfile(name,username,email,avatar,address_street,address_suite,address_city,address_zipcode,address_geo_lat,address_geo_lng,phone,website,company_name,company_catchPhrase,company_bs);
    }

    private class ReadJSONObject extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    content.append(line);
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            str = s;
        }
    }
    public void openProfile(String name,
                            String username,
                            String email,
                            int avatar,
                            String address_street,
                            String address_suite,
                            String address_city,
                            String address_zipcode,
                            String address_geo_lat,
                            String address_geo_lng,
                            String phone,
                            String website,
                            String company_name,
                            String company_catchPhrase,
                            String company_bs)
    {
        Intent intent = new Intent(this,Profile.class);
        intent.putExtra("name",name);
        intent.putExtra("username",username);
        intent.putExtra("email",email);
        intent.putExtra("avatar",avatar);
        intent.putExtra("address_street",address_street);
        intent.putExtra("address_suite",address_suite);
        intent.putExtra("address_city",address_city);
        intent.putExtra("address_zipcode",address_zipcode);
        intent.putExtra("address_geo_lat",address_geo_lat);
        intent.putExtra("address_geo_lng",address_geo_lng);
        intent.putExtra("phone",phone);
        intent.putExtra("website",website);
        intent.putExtra("company_name",company_name);
        intent.putExtra("company_catchPhrase",company_catchPhrase);
        intent.putExtra("company_bs",company_bs);
        startActivity(intent);
    }

}
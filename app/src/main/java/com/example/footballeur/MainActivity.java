package com.example.footballeur;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Football App";
    Button btn_add;
    Menu menu;

    MyApplication myApplication = (MyApplication) this.getApplication();
    List<Footballeur> footballeurList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        footballeurList = myApplication.getFootballeurList();

        Log.d(TAG, "onCreate: " + footballeurList.toString());
        btn_add = findViewById(R.id.btn_add);
        Toast.makeText(this, "Football count = " + footballeurList.size(), Toast.LENGTH_SHORT).show();
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditOne.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.lv_footballeurList);
        // use this set knting to improve performance if you know that changes
        //in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        //use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //specify an adapter (see also next example)
        mAdapter = new RecyclerViewAdapter(footballeurList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_aToz:
          // Sort a to z
                Collections.sort(footballeurList, Footballeur.presidentNameAZComparator);
                Toast.makeText(MainActivity.this, "Trier de A a Z", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
          return true;

            case R.id.menu_zToa:
            // Sort z to a
                Collections.sort(footballeurList, Footballeur.presidentNameZAComparator);
            Toast.makeText(MainActivity.this, "Trier de Z a A", Toast.LENGTH_SHORT).show();
            mAdapter.notifyDataSetChanged();
            return true;

            case R.id.menu_dateAscending:
                // Sort z to a
                Collections.sort(footballeurList, Footballeur.presidentNameAscendingComparator);
                Toast.makeText(MainActivity.this, "Trier date par ordre croissant", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menu_dateDescending:
                // Sort z to a
                Collections.sort(footballeurList, Footballeur.presidentNamedescendingComparator);
                Toast.makeText(MainActivity.this, "Trier date par ordre decroissant", Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
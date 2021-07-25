package com.example.footballeur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddEditOne extends AppCompatActivity {

    Button btn_valide, btn_cancel;
    List<Footballeur> footballeurList;
    EditText etfootname, etdate, etpicture;
    TextView tvfootid;
    MyApplication myApplication = (MyApplication) this.getApplication();
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        footballeurList = myApplication.getFootballeurList();

        btn_valide = findViewById(R.id.btn_valide);
        btn_cancel = findViewById(R.id.btn_cancel);
        etfootname = findViewById(R.id.et_footballName);
        etdate = findViewById(R.id.et_dateNaissance);
        etpicture = findViewById(R.id.et_pictureURL);
        tvfootid = findViewById(R.id.tv_footballeurId);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        Footballeur footballeur = null;

        if (id >= 0){
            //Edit the footballeur
            for (Footballeur f: footballeurList){
                if (f.getId() == id){
                    footballeur = f;
                }
            }
            etfootname.setText(footballeur.getNom());
            etdate.setText(String.valueOf(footballeur.getDateNaissance()));
            etpicture.setText(footballeur.getImageURl());
            tvfootid.setText(String.valueOf(id));
        }
        else{
            //create new footballeur
        }

        btn_valide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (id >= 0){
                    //Update
                    Footballeur updatedFootballeur = new Footballeur(id, etfootname.getText().toString(), Integer.parseInt(etdate.getText().toString()), etpicture.getText().toString());
                    footballeurList.set(id, updatedFootballeur);
                }
                else{
                    // Add new football
                    //Create Football object
                    int nextId = myApplication.getNextId();
                    Footballeur newFootballeur = new Footballeur(nextId, etfootname.getText().toString(), Integer.parseInt(etdate.getText().toString()), etpicture.getText().toString());

                    //Add the object of the global list of footballeurs
                    footballeurList.add(newFootballeur);
                    myApplication.setNextId(nextId++);
                }


                //go back to main activity


                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
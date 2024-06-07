package com.example.gyvunai;

import android.graphics.Color;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    Sukurti klasę gyvūnas - Vardas, amžius, rūšis.
//    Sukurti gyvūnų sąrašą ir sukurti pridėjimą į jį įvedant duomenis kaip EditText.
//    Pridėti TextView kuris rodytų kiek gyvūnų yra pridėta į sąrašą.
//    Pridėjus gyvūną, suvesta informacija iš EditText laukelių turi būti išvalyta.
//    BONUS:  Pridėti sąrašo atvaizdavimą

    TextView rezultatas;
    Button button;
    Gyvunas gyvunas = new Gyvunas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
    }

    public void addAnimal(View v){
        //Button buttonAdd = findViewById(R.id.button1);
        TextView tName = findViewById(R.id.fieldName);
        TextView tAge = findViewById(R.id.fieldAge);
        TextView tType = findViewById(R.id.fieldType);
        try {
            String name = tName.getText().toString();
            int age = Integer.parseInt(tAge.getText().toString());
            String type = tType.getText().toString();
            if(!name.equals("") && !type.equals("") && age > 0){
                gyvunas.addGyvunasToList(new Gyvunas(name, age, type));
                Toast.makeText(this, "Pridėta", Toast.LENGTH_SHORT).show();
                tName.setText("");
                tAge.setText("");
                tType.setText("");
            } else Toast.makeText(this, "Įveskite visas reikšmes", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Neteisingas amžius", Toast.LENGTH_SHORT).show();
        }


    }





}
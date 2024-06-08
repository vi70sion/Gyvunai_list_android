package com.example.gyvunai;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    Sukurti klasę gyvūnas - Vardas, amžius, rūšis.
//    Sukurti gyvūnų sąrašą ir sukurti pridėjimą į jį įvedant duomenis kaip EditText.
//    Pridėti TextView kuris rodytų kiek gyvūnų yra pridėta į sąrašą.
//    Pridėjus gyvūną, suvesta informacija iš EditText laukelių turi būti išvalyta.
//    BONUS:  Pridėti sąrašo atvaizdavimą

    TextView rezultatas;
    Button button;
    Gyvunas gyvunas = new Gyvunas();
    String kiekis = "";

    ListView listView;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        listView = findViewById(R.id.listview);
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
                kiekis = Integer.toString(gyvunas.getGyvunaiList().size());
                Toast.makeText(this, kiekis, Toast.LENGTH_SHORT).show();
            } else Toast.makeText(this, "Įveskite visas reikšmes", Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Neteisingas amžius", Toast.LENGTH_SHORT).show();
        }

    }

    public void printList(View v){
        List<String> items = new ArrayList<>();
        for(Gyvunas item: gyvunas.getGyvunaiList()){
            items.add(item.toString());
        }
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }





}
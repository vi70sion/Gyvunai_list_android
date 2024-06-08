package com.example.gyvunai;

import java.util.ArrayList;
import java.util.List;

public class Gyvunas {
    private String vardas;
    private int amzius;
    private String rusis;
    private List<Gyvunas> gyvunuList;

    public Gyvunas() {
        this.gyvunuList = new ArrayList<>();
    }

    public Gyvunas(String vardas, int amzius, String rusis) {
        this.vardas = vardas;
        this.amzius = amzius;
        this.rusis = rusis;
    }

    public void addGyvunasToList(Gyvunas gyvunas){
        gyvunuList.add(gyvunas);
    }
    public List<Gyvunas> getGyvunaiList(){
        return gyvunuList;
    }

    @Override
    public String toString(){
        return "Vardas: " + vardas + ", amžius: " + amzius + ", rūšis: " + rusis;
    }
}

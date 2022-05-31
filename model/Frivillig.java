package model;

import java.util.ArrayList;

public class Frivillig implements Comparable<Frivillig>{
    private String navn;
    private String mobil;
    private int maksAntalTimer;
    private final ArrayList<Vagt> vagter = new ArrayList<>();

    public Frivillig(String navn, String mobil, int maksAntalTimer){
        this.navn = navn;
        this.mobil = mobil;
        this.maksAntalTimer = maksAntalTimer;
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public void addVagt(Vagt vagt) {
        if(!vagter.contains(vagt)){
            vagter.add(vagt);
            vagt.setFrivillig(this);
        }
    }

    public void removeVagt(Vagt vagt) {
        if(vagter.contains(vagt)){
            vagter.remove(vagt);
            vagt.setFrivillig(null);
        }
    }

    public int ledigeTimer(){
        int timer = 0;
        for (Vagt v : vagter){
            timer += getMaksAntalTimer() - v.getTimer();
        }
        return timer;
    }


    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public int getMaksAntalTimer() {
        return maksAntalTimer;
    }

    public int antalGaver(){
        int gave = 0;
        if(this.ledigeTimer() < maksAntalTimer){
            gave = 1;
        }
        return gave;
    }

    @Override
    public int compareTo(Frivillig o) {
        int comp = this.navn.compareTo(o.getNavn());
        return comp;
    }
}

package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Job {
    private String kode;
    private String beskrivelse;
    private LocalDate dato;
    private int timeHonorar;
    private int antalTimer;
    private final ArrayList<Vagt> vagter = new ArrayList<>();

    Job(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer){
        this.kode = kode;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.timeHonorar = timeHonorar;
        this.antalTimer = antalTimer;
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public Vagt createVagt(int timer, Frivillig frivillig){
        Vagt vagt = new Vagt(timer,this, frivillig);
        vagter.add(vagt);
        return vagt;
    }

    public void removeVagt(Vagt vagt){
        if(vagter.contains(vagt)){
            vagter.remove(vagt);
        }
    }

    public int getAntalTimer() {
        return antalTimer;
    }

    public int ikkeBesatteTimer(){
        int antalIkkeBesatteTimer = 0;
        for(Vagt v : vagter){
            antalIkkeBesatteTimer += v.getFrivillig().ledigeTimer();
        }
        return antalIkkeBesatteTimer;
    }

    public String getKode() {
        return kode;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getTimeHonorar() {
        return timeHonorar;
    }
    @Override
    public String toString(){
        return kode + " " + beskrivelse + " antal timer " + antalTimer;
    }
}

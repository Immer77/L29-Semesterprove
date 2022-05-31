package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;


public class Festival {
    private String navn;
    private LocalDate fraDato;
    private LocalDate tilDato;
    private ArrayList<Job> jobs = new ArrayList<>();

    public Festival(String navn, LocalDate fraDato, LocalDate tilDato){
        this.navn = navn;
        this.fraDato = fraDato;
        this.tilDato = tilDato;

    }

    public ArrayList<Job> getJobs() {
        return new ArrayList<>(jobs);
    }

    public Job createJob(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer){
        Job job = new Job(kode,beskrivelse,dato,timeHonorar,antalTimer);
        jobs.add(job);
        return job;
    }

    public int budgetteretJobUdgift(){
        int result = 0;
        for (Job j : jobs){
            result = j.getTimeHonorar() * j.getAntalTimer();
        }
        return result;
    }

    public int realiseretJobUdgift(){
        int result = 0;
        for(Job j : jobs){
            for(Vagt v : j.getVagter()){
                result = v.getTimer() * j.getTimeHonorar();
            }
        }

        return result;
    }

    public ArrayList<String> gaverTilFrivillige(){
        ArrayList<String> frivilligeGaver = new ArrayList<>();
        for(Job j : jobs){
            for(Vagt v : j.getVagter()){
                Frivillig frivillig = v.getFrivillig();
                if(frivillig instanceof FrivilligForening){

                    frivilligeGaver.add(frivillig.getNavn() + " " + frivillig.antalGaver() + " " + ((FrivilligForening) frivillig).getForeningsNavn());
                }else{
                    frivilligeGaver.add(frivillig.getNavn() + " " + frivillig.antalGaver());
                }
            }
        }
        Collections.sort(frivilligeGaver);

        return frivilligeGaver;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }
}

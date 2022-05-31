package model;

public class Vagt {
    private int timer;
    private Job job;
    private Frivillig frivillig;


    Vagt(int timer, Job job, Frivillig frivillig){
        this.timer = timer;
        this.job = job;
        this.frivillig = frivillig;
    }

    /* Note: Nullable return value. */

    public Frivillig getFrivillig() {
        return frivillig;
    }

    public void setFrivillig(Frivillig frivillig){
        if(this.frivillig != frivillig){
            Frivillig oldFrivillig = this.frivillig;
            if(oldFrivillig != null){
                oldFrivillig.removeVagt(this);
            }
            this.frivillig = frivillig;
            if(frivillig != null){
                frivillig.addVagt(this);
            }
        }
    }

    public Job getJob() {
        return job;
    }

    public int getTimer() {
        return timer;
    }
    @Override
    public String toString(){
        return timer + " ";
    }
}

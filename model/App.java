package model;

import controller.Controller;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Festival northside = Controller.createFestival("Northside", LocalDate.of(2020, 6, 4), LocalDate.of(2020, 6, 6));
        Frivillig f1 = Controller.createFrivillig("Jane Jensen", "12345677", 20);
        Frivillig f2 = Controller.createFrivillig("Lone Hansen", "78787878", 25);
        Frivillig f3 = Controller.createFrivillig("Anders Mikkelsen", "55555555", 10);

        Frivillig f4 = Controller.createFrivilligForening("Christian Madsen", "23232323", 100, "Erhvervsakademi Aarhus", 40);

        Job j1 = northside.createJob("T1", "Rengøring af toilet", LocalDate.of(2020, 4, 4), 100, 5);
        Job j2 = northside.createJob("T2", "Rengøring af toilet", LocalDate.of(2020, 4, 4), 100, 5);
        Job j3 = northside.createJob("T3", "Rengøring af toilet", LocalDate.of(2020, 4, 4), 100, 5);

        Job j4 = northside.createJob("T4", "Rengøring af toilet", LocalDate.of(2020, 4, 5), 100, 5);
        Job j5 = northside.createJob("T5", "Rengøring af toilet", LocalDate.of(2020, 4, 5), 100, 5);
        Job j6 = northside.createJob("T6", "Rengøring af toilet", LocalDate.of(2020, 4, 5), 100, 5);

        Job j7 = northside.createJob("T7", "Rengøring af toilet", LocalDate.of(2020, 4, 6), 100, 5);
        Job j8 = northside.createJob("T8", "Rengøring af toilet", LocalDate.of(2020, 4, 6), 100, 5);
        Job j9 = northside.createJob("T9", "Rengøring af toilet", LocalDate.of(2020, 4, 6), 100, 5);
        j1.createVagt(1,f1);
        j2.createVagt(1,f2);
        j3.createVagt(1,f3);
        j4.createVagt(1,f4);

        System.out.println(Controller.findFrivillig(northside, f1.getNavn()));


        System.out.println(northside.gaverTilFrivillige());
    }
}

package Kampf;

import java.util.Scanner;

import Helden.Waffen.Held;

public class HeldenUndMonsterService {
    protected Held[] Helden = new Held[3];
    Scanner input = new Scanner(System.in);

    public HeldenUndMonsterService(){
        Helden[0] = new Held(100, 10, "Frank der Rächer der Kontenaks");
        Helden[1] = new Held(100, 10, "Gert der Weisse Ritter");
        Helden[2] = new Held(100, 10, "Klaus Nikolaus der Schreckliche Weyand");
    }

    public Held selectHeld(){
        int auswahl = -1;
        do {
            System.out.printf("\n\n\n\n\n\n\n");
            System.out.printf("Wähle deinen Helden!: \n");
            for (int i = 1; i < Helden.length; i++) {
                System.out.printf("\n\n Held Nr. %d: %s\n", i + 1, Helden[i].getName());
                System.out.printf("HP: %d\n", Helden[i].getGesundheit());
                System.out.printf("Schaden: %d\n", Helden[i].getSchaden());
                System.out.printf("\n\n");

                // Eingabe entscheidet welcher Held ausgewählt wird   
                try {
                    System.out.printf("Gib die Nummer des Helden ein, den du auswählen möchtest: ");
                    auswahl = input.nextInt();
                    if (auswahl < 1 || auswahl > Helden.length) {
                        System.out.printf("Ungültige Auswahl. Bitte wähle eine Zahl zwischen 1 und %d.\n", Helden.length);
                        auswahl = -1; // Loop restarten bei ungültiger Eingabe     
                        break;
                    }
                } catch (Exception e) {
                    System.out.printf("Ungültige Eingabe. Bitte gib eine Zahl ein!\n");
                    input.nextLine();
                    auswahl = -1; // Loop restarten bei ungültiger Eingabe
                }
            }
        } while (auswahl < 1 || auswahl > Helden.length);

        // return selected Hero
        return Helden[auswahl - 1];
    }




}
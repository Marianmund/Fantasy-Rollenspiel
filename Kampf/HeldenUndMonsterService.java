package Kampf;

import Helden.Waffen.Held;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class HeldenUndMonsterService {
    protected Held[] Helden = new Held[3];
    

    Scanner input = new Scanner(System.in);

    public HeldenUndMonsterService(){
        // Standard Helden
        Helden[0] = new Held(100, 10, "Frank der Rächer der Kontenaks");
        Helden[1] = new Held(100, 10, "Gerd der Weisse Ritter");
        Helden[2] = new Held(100, 10, "Klaus Nikolaus der Schreckliche Weyand");

        // Standard Monster in Wellen
    }

    public Held selectHeld(){
        int auswahl = -1;
        do {
            System.out.printf("\n\n\n\n\n\n\n");
            System.out.printf("Wähle deinen Helden!: \n \n \n");

            Sleep(1);

            for (int i = 1; i <= Helden.length; i++) {
                System.out.printf("Held Nr. %d: %s\n", i, Helden[i - 1].getName());
                System.out.printf("HP: %d\n", Helden[i - 1].getGesundheit());
                System.out.printf("Schaden: %d\n", Helden[i - 1].getSchaden());
                System.out.printf("\n\n");

                Sleep(1); // Sleep for 1 second between each hero display
            }
            
                // Eingabe entscheidet welcher Held ausgewählt wird   
                try {
                    System.out.printf("Gib die Nummer des Helden ein, den du auswählen möchtest: ");
                    auswahl = input.nextInt();
                    if (auswahl < 1 || auswahl > Helden.length) {
                        System.out.printf("\n\nUngültige Auswahl. Bitte wähle eine Zahl zwischen 1 und %d.\n", Helden.length);
                        auswahl = -1; // Loop restarten bei ungültiger Eingabe     
                        Sleep(1);
                    }
                } catch (Exception e) {
                    System.out.printf("\n\nUngültige Eingabe. Bitte gib eine Zahl ein!\n");
                    Sleep(1);
                    input.nextLine();
                    auswahl = -1; // Loop restarten bei ungültiger Eingabe
                }
        } while (auswahl < 1 || auswahl > Helden.length);

        // return selected Hero
        return Helden[auswahl - 1];
    }

    public static void Sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
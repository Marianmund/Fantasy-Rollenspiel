package Kampf;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/* Notiz an uns:

- Würfel soll solange weiter würfeln, bis keine sechs mehr gewürfelt wird. 
    - > D20 oder D6? 
    - > aber immer info zwischendurch
    - > gesamte Augenzahl + Einzelwürfe zurückgeben!
- Monster sollen einen eigenen Würfel haben 

*/
public class Wuerfel {

    // Würfel mit einer bestimmten Anzahl von Seiten
    private final int seiten;

    public Wuerfel(int seiten) {
        this.seiten = seiten;
    }

    // Methode zum Würfeln
    public int wuerfeln() throws InterruptedException{
        
        Scanner enter = new Scanner(System.in);

        int ergebnis = 0;
        int wurf;

        boolean bonus = false;
        

        do {
            System.out.printf("\nDrücke enter um zu würfeln! ");
            enter.nextLine();

            wurf = (int) (Math.random() * seiten) + 1;

            // Würfel Animation
            int zahl = 0;
            int schritte = 25;

            for (int i = 0; i < schritte; i++){
                if (i == schritte - 1){
                    zahl = wurf;
                } else {
                    int neu;
                    do {
                        neu = (int) (Math.random() * seiten) + 1;
                    } while (neu == zahl);

                    zahl = neu;
                }

                System.out.print("\rWürfle... [" + zahl + "] ");
                System.out.flush();

                Thread.sleep(40 + (long) i * i / 3);
            }

            System.out.println("\r\033[KErgebnis: " + wurf);

            if (wurf == this.seiten){
                System.out.printf("Du hast eine %d gewürfelt! Du kannst noch einmal würfeln! %n", wurf);
                bonus = true;
                Sleep(1);
            }

            Sleep(1);

            ergebnis += wurf;
        } while (wurf == this.seiten);

        if (bonus){
            System.out.printf("Insgesamt hast du %d gewürfelt! ", ergebnis);
        }

        System.out.println("\n");

        enter.close();
        return ergebnis;
    }



/*
* add. Methods
*/

    // Pause für eine bestimmte Anzahl von Sekunden
    public static void Sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

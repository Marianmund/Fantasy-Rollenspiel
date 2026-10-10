import Kampf.HeldenUndMonsterService;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static HeldenUndMonsterService service;
    public static boolean gameIsActive;

    public static void main(String[] args) throws InterruptedException {
        // Spiel starten mit "Loading Screen" (falls man das so nennen kann...)

        GlücksspielService GSS = new GlücksspielService();

        startScreen();


        // Spiellogik und Gewinn Counter
        do {
            boolean gewonnen; 
            
            // Spielgeschehen
            gewonnen = Spiel();

            if (gewonnen == true){
                GSS.Siege++;
                gameIsActive = erneutSpielen();
            } else {
                GSS.Siege = 0;
                gameIsActive = false;
            }

            // Spieler wird gefragt, ob er erneut spielen möchte
            
            

        } while (gameIsActive == true);



        // Geld Ausgabe
        System.out.println("\n\n####################\n");
        Sleep(2);
        System.out.println("Eingezahlt: " + GSS.getGeldEin());
        Sleep(1);
        System.out.println("Ausgezahlt: " + GSS.calculateGeldAus(GSS.Siege));
        Sleep(1);
        System.out.println("Gewinn: " + (GSS.calculateGeldAus(GSS.Siege) - GSS.getGeldEin()));
        Sleep(1);
        System.out.println("\n####################\n");

        input.close();
    }



/*
*
* Spielelemente
*
*/
    // Startbildschirm mit Begrüßung und Spielbeschreibung
    public static void startScreen() {
        System.out.println("\n\nWillkommen zum Fantasy-Rollenspiel!\n\n");
        Sleep(1);
        System.out.println("In diesem Spiel kannst du einen Helden auswählen und gegen Monster kämpfen!");
        Sleep(1);
        System.out.println("Drücke die Eingabetaste, um fortzufahren...");
        input.nextLine(); // Wait for user to press Enter
        System.out.println("Viel Spaß beim Spielen!\n\n");
        Sleep(1);
        System.out.println("\n\n\n");
        Sleep(1);
    }


    // gesamtes Spielgeschehen findet hier statt 
    // ruft auch KampfService auf, um den Kampf zwischen Helden und Monstern zu starten
    // gibt true zurück falls gewonnen, false bei Niederlage
    public static boolean  Spiel(){
        // Heldenauswahl
        boolean gewonnen;
        service = new HeldenUndMonsterService(input);

        service.setHeld(service.selectHeld());

        Sleep(1);

        System.out.println("Gewaehlter Held: " + service.getHeld().getName());



        // Gewonnen? -> ausgabe

        // noch nciht implementiert
        if (true){
            gewonnen = true;
        } else {
            gewonnen = false;
        }

        return gewonnen;
    }


    // Möchte Spieler erneut spielen? (y/n) - return true/false
    public static boolean erneutSpielen() {
        while (true) {
            input.nextLine();

            System.out.print("\nMöchtest du erneut spielen? (y/n): ");

            String answer = input.nextLine().trim().toLowerCase();

            switch (answer) {
                case "y" -> {
                    Sleep(1);
                    System.out.println("\n\n\n\n");
                    Sleep(1);
                    System.out.println("Neues Spiel wird gestartet...\n\n");
                    Sleep(3);
                    return true;
                }
                case "n" -> {
                    Sleep(1);
                    System.out.println("\n\n\n\n");
                    Sleep(1);
                    System.out.println("Vielen Dank fürs Spielen!\n\n");
                    Sleep(1);
                    System.out.println("Auf Wiedersehen!\n\n");
                    Sleep(1);
                    return false;
                }
                default -> System.out.println(
                    "Ungültige Eingabe. Bitte gib 'y' oder 'n' ein.\n"
                );
            }
        }
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
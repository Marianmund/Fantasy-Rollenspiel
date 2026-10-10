import Kampf.HeldenUndMonsterService;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static HeldenUndMonsterService service;
    public static boolean gameIsActive;

    public static void main(String[] args) throws InterruptedException {
        // Spiel starten mit "Loading Screen" (falls man das so nennen kann...)

        startScreen();

        do {
            
            // Spielgeschehen
            Spiel();

            // Spieler wird gefragt, ob er erneut spielen möchte
            gameIsActive = erneutSpielen();

        } while (gameIsActive == true);

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
    public static void Spiel(){
        // Heldenauswahl
        service = new HeldenUndMonsterService(input);

        service.setHeld(service.selectHeld());

        Sleep(1);

        System.out.println("Gewaehlter Held: " + service.getHeld().getName());
    }


    // Möchte Spieler erneut spielen? (y/n) - return true/false
    public static boolean erneutSpielen() {
        while (true) {
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
                    System.out.println("Das Spiel wird beendet...\n\n");
                    Sleep(1);
                    System.out.println("Auf Wiedersehen!\n\n");
                    Sleep(1);
                    System.exit(0);
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
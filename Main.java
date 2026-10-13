import Kampf.HeldenUndMonsterService;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static HeldenUndMonsterService service;
    public static boolean gameIsActive;

    public static void main(String[] args) throws InterruptedException {
        // Spiel starten mit "Loading Screen" (falls man das so nennen kann...)

        // Glücksspielservice mit Dialog aktiviert; 
        // Abfrage Geld einzahlen findet auch statt
        GlücksspielService GSS = new GlücksspielService(input);

        startScreen();


        // Spiellogik und Gewinn Counter
        do {
            boolean gewonnen; 
            
            // Spielgeschehen
            gewonnen = Spiel();

            if (gewonnen){
                GSS.Siege++;
                Sleep(1);
                System.out.println("\n\nDu hast gewonnen!!!");
                Sleep(1);
                System.out.printf("Dein Geld: %d\n", GSS.calculateGeldAus(GSS.Siege));
                Sleep(1);
                gameIsActive = erneutSpielen();
            } else {
                GSS.Siege = 0;
                gameIsActive = false;
            }

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
    public static boolean Spiel() throws InterruptedException{
        // Heldenauswahl
  
        service = new HeldenUndMonsterService(input);

        service.setHeld(service.selectHeld());

        Sleep(1);

        System.out.println("Gewaehlter Held: " + service.getHeld().getName());

        System.out.println();
        Sleep(1);
        System.out.println();
        Sleep(1);

        // Tür öffnen: Welche Monster kommen? (Pseudo Auswahl)
        System.out.println("Du stehst vor drei Türen!");
        Sleep(1);

        int tür = -1;
        do {
            System.out.print("Welche möchtest du öffnen? (1/2/3): ");
            String eingabe = input.nextLine().trim();

            try {
                tür = Integer.parseInt(eingabe);
            } catch (NumberFormatException e) {
                System.out.println("Eingabe muss eine Zahl sein!");
                tür = -1;
            }

            if (tür < 1 || tür > 3) {
                System.out.println("Eingabe muss 1, 2 oder 3 sein!");
            }
        } while (tür < 1 || tür > 3);

        Sleep(1);
        System.out.println("Du gehst durch Tür Nr. " + tür + "!");
        Sleep(1);
        service.setMonster();
        System.out.println();
        System.out.printf("Vor dir steht eine Horde von %s!%n%n", service.getMonsterTyp());
        Sleep(1);
        

        do {
            int MonsterPos = 0;
            service.MonsterAusgeben();

            // ? Welches Monster wird angegriffen?
            do {
                System.out.print("Welches Monster möchtest du angreifen?: ");
                String monsterEingabe = input.nextLine().trim();

                try {
                    MonsterPos = Integer.parseInt(monsterEingabe);
                    System.out.println();
                } catch (NumberFormatException e) {
                    System.out.println("Eingabe muss eine Zahl sein!");
                    MonsterPos = -1;
                }

                if (MonsterPos < 1 || MonsterPos > service.getMonsterLength()) {
                    System.out.printf("Eingabe muss zwischen 1 und %d liegen! ", service.getMonsterLength());
                }
            } while (MonsterPos < 1 || MonsterPos > service.getMonsterLength());
            
            // Kampf wird ausgeführt
            service.Kampf(MonsterPos - 1);
        } while (service.getHeld().getGesundheit() > 0 && service.hasMonsters());
        
        
        
        boolean gewonnen;
        // Gewonnen? -> ausgabe
        gewonnen = service.getHeld().getGesundheit() > 0;

        return gewonnen;
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
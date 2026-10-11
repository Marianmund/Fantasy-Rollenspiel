package Kampf;

import Helden.Waffen.Held;
import Monster.Lehrer;
import Monster.Monster;
import Monster.Orcs;
import Monster.Schueler;
import Monster.Skelett;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


// Zusatz für uns: Wenn Monster tot muss auf jeden Fall eine Random Waffe mit 
// Random Schaden gedroppt werden,
// Welche dem Schaden gewisse Punkte hinzufügt
// Jede Waffe im Inventar fügt Schaden hinzu ohne dass man sie 
// aktiv auswählen muss
public final class HeldenUndMonsterService {
    protected Monster[] selectedMonster = new Monster[5];
    int monsterType;

    protected Held[] Helden = new Held[3];
    protected Held Held;
    private final Scanner input;


    // KampfService
    protected KampfService KS;

    public HeldenUndMonsterService(Scanner input) {
        this.input = input;
        this.KS = new KampfService(input);

        // Standard Helden
        Helden[0] = new Held(240, 12, "Frank der Rächer der Kontenaks");
        Helden[1] = new Held(100, 70, "Gerd der Weisse Ritter");
        Helden[2] = new Held(160, 23, "Klaus Nikolaus der Schreckliche Weyand");

        // Standard Monster in Wellen
        this.setMonster();
    }

    public String getMonsterTyp() {
        return switch (monsterType) {
            case 0 -> "Orcs";
            case 1 -> "Skeletten";
            case 2 -> "Lehrern";
            case 3 -> "Schülern";
            default -> throw new IllegalStateException("Unbekannter Monster-Typ: " + monsterType);
        };
    }

    public void setMonster() {
        monsterType = (int) (Math.random() * 4);

        String[] namen = switch (monsterType) {
            case 0 -> Orcs.getMöglicheNamen();
            case 1 -> Skelett.getMöglicheNamen();
            case 2 -> Lehrer.getMöglicheNamen();
            case 3 -> Schueler.getMöglicheNamen();
            default -> throw new IllegalStateException("Unbekannter Monster-Typ: " + monsterType);
        };

        for (int i = 0; i < selectedMonster.length; i++) {
            int selectedName = (int) (Math.random() * namen.length);
            int leben = 30 + (int) (Math.random() * 70);
            int schaden = (int) (Math.random() * 20);

            selectedMonster[i] = switch (monsterType) {
                case 0 -> new Orcs(namen[selectedName], leben, schaden);
                case 1 -> new Skelett(namen[selectedName], leben, schaden);
                case 2 -> new Lehrer(namen[selectedName], leben, schaden);
                case 3 -> new Schueler(namen[selectedName], leben, schaden);
                default -> throw new IllegalStateException("Unbekannter Monster-Typ: " + monsterType);
            };
        }
    }

    public boolean hasMonsters() {
        for (Monster monster : selectedMonster) {
            if (monster != null && monster.getLeben() > 0) {
                return true;
            }
        }
        return false;
    }

    public void removeDeadMonsters() {
        int index = 0;
        int lebendig = 0;

        for (Monster n : selectedMonster){
            if (n != null && n.getLeben() > 0){
                lebendig++;
            }
        }

        Monster[] MonsterRückgabe = new Monster[lebendig];

        for (Monster n : selectedMonster){
            if (n != null && n.getLeben() > 0){
                MonsterRückgabe[index] = n;
                index++;
            }
        }

        this.selectedMonster = MonsterRückgabe;
    }



    public int getMonsterLength(){
        int count = 0;
        for (Monster monster : selectedMonster) {
            if (monster != null && monster.getLeben() > 0) {
                count++;
            }
        }
        return count;
    }

    public void MonsterAusgeben(){
        removeDeadMonsters();
        System.out.println("\n");
        Sleep(1);

        System.out.printf("Du stehst folgenden Monstern gegenüber: ");
        Sleep(1);
        
        int n = 1;
        for (Monster m : selectedMonster){
            if (m != null && m.getLeben() > 0) {
                System.out.print("[" + n + "] " + m.getName() + " (" + m.getLeben() + ") \t");
                n++;
            }
        }

        System.out.println("\n");
    }

    /**
     * 
     * @param MonsterPos
     * @throws InterruptedException
     * Kampf Methode -> Zuerst wird Monster angegriffen, dann erhält Held Schaden zurück
     * 
     */
    public void Kampf(int MonsterPos) throws InterruptedException {
        

        if (MonsterPos < 0 || MonsterPos >= selectedMonster.length || selectedMonster[MonsterPos] == null) {
            System.out.println("Ungültige Monsterposition.");
            return;
        }

        // Kampf Dialog
        System.out.println("Kampf! ");
        Sleep(1);
        System.out.printf("Du greifst %s an! %n%n", selectedMonster[MonsterPos].getName());
        Sleep(1);
        System.out.println("Drücke Enter um fortzufahren.");
        input.nextLine();

        int vorher = selectedMonster[MonsterPos].getLeben();
        int schaden = KS.SchadenMachen(Held);
        int nachher = Math.max(0, vorher - schaden);

        selectedMonster[MonsterPos].setLeben(nachher);

        // print Monster mit neuen Lebenspunkten
        System.out.printf("%s: %d HP -> %d HP (%d Schaden) %n",
                selectedMonster[MonsterPos].getName(), vorher, nachher, schaden);
                Sleep(1);

        if (selectedMonster[MonsterPos].getLeben() <= 0) {
            System.out.println("Das Monster wurde besiegt!");

            // ! hier bald noch Waffenservice einbinden, damit Held durch besiegtes Monster
            // ! upgrades bekommt

            removeDeadMonsters();

        } else {
            System.out.println();
        }

        Sleep(1);

        /*
        *
        * Monster geben ihren Schaden zurück:
        * +/- Zufallszahl von -5 bis +3
        *
        */

        if (hasMonsters()){
            int[] schadenMonsterIndex = new int[selectedMonster.length];
            for (int i = 0; i < schadenMonsterIndex.length; i++){
                schadenMonsterIndex[i] = (int) (Math.random() * 9) - 3;
                
                if (selectedMonster[i].getSchaden() + schadenMonsterIndex[i] < 0) {
                    schadenMonsterIndex[i] = -selectedMonster[i].getSchaden();
                }
            }

            

            System.out.println("\n\nDie Monster schlagen zurück! \n");
            Sleep(1);  

            for (int i = 0; i < selectedMonster.length; i++){
                if (selectedMonster[i] != null && selectedMonster[i].getLeben() > 0) {
                    System.out.print(selectedMonster[i].getName() + " " 
                                        + (selectedMonster[i].getSchaden() + schadenMonsterIndex[i]) 
                                        + "dmg \t");
                }
            }
            
            System.out.println();

            Sleep(1);

            int gesamtSchaden = 0;

            for (int i = 0; i < selectedMonster.length; i++){
                if (selectedMonster[i] != null && selectedMonster[i].getLeben() > 0) {
                    gesamtSchaden += selectedMonster[i].getSchaden() + schadenMonsterIndex[i];
                }
            }

            int vorherigeHP = this.Held.getGesundheit();
            this.Held.setGesundheit(this.Held.getGesundheit() - gesamtSchaden); 

            Sleep(1);
            if (this.Held.getGesundheit() > 0){
                System.out.printf("%s: %d - %d -> %d", this.Held.getName(), vorherigeHP,
                                                            gesamtSchaden, this.Held.getGesundheit());
                Sleep(1);
            } else {
                Sleep(1);
                System.out.println("\n\nDu hast verloren!!! ");
                Sleep(1);
                System.out.printf("(%s: %d - %d -> 0)%n", this.Held.getName(), vorherigeHP,
                                                            gesamtSchaden, this.Held.getGesundheit());
                Sleep(2);
                System.out.println("Gib mir dein Geld ahahaha");
                Sleep(1);
            }
            


        }
        
    }


    public void setHeld(Held Held){
        this.Held = Held;
    }

    public Held getHeld(){
        if (this.Held == null){
            this.Held = Helden[0];
        }
        return this.Held;
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

            System.out.printf("Gib die Nummer des Helden ein, den du auswählen möchtest: ");
            String eingabe = input.nextLine().trim();

            try {
                auswahl = Integer.parseInt(eingabe);
                if (auswahl < 1 || auswahl > Helden.length) {
                    System.out.printf("\n\nUngültige Auswahl. Bitte wähle eine Zahl zwischen 1 und %d.\n", Helden.length);
                    auswahl = -1;
                    Sleep(1);
                }
            } catch (NumberFormatException e) {
                System.out.printf("\n\nUngültige Eingabe. Bitte gib eine Zahl ein!\n");
                Sleep(1);
                auswahl = -1;
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
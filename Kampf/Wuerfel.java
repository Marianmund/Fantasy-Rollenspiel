package Helden.Kampf;


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
    public int wuerfeln() {
        return (int) (Math.random() * seiten) + 1;
    }
}

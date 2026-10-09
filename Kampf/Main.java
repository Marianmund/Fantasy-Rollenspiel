package Kampf;

import Helden.Waffen.Held;

public class Main {
    public static void main(String[] args) {
        var service = new HeldenUndMonsterService();

        Held Held = service.selectHeld();


    }
}
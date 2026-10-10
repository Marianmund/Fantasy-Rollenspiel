package Helden.Waffen;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Held {
	private String name;
	private int gesundheit;
	private int schaden;
	private Waffe[] inventar = new Waffe[3];

	public Held(int gesundheit, int schaden) {
		this.gesundheit = gesundheit;
		this.schaden = schaden;
	}

	public Held(int gesundheit, int schaden, String name) {
		this.gesundheit = gesundheit;
		this.schaden = schaden;
		this.name = name;
	}

	public int getGesundheit() {
		return gesundheit;
	}

	public int getSchaden() {
		return schaden;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Waffe[] getInventar() {
		return inventar;
	}

	public void showInventar() {
		for (int i = 1; i <= this.getInventar().length; i++) {
					System.out.printf("Waffe Nr. %d: %s\n", i, this.getInventar()[i-1].getName());
				}
	}

	
	public void erleideSchaden(int schaden) {
		if (schaden < 0) {
			throw new IllegalArgumentException("Schaden darf nicht negativ sein.");
		}
		gesundheit = Math.max(0, gesundheit - schaden);
	}

	public void heile(int heilung) {
		if (heilung < 0) {
			throw new IllegalArgumentException("Heilung darf nicht negativ sein.");
		}
		gesundheit += heilung;
	}


	// Waffenmanagement
	// Waffe wird hinzugefügt, falls Inventar nicht voll
	// Wenn es voll ist: Spieler wird gefragt ob und welche er ersetzen möchte
	public void addWaffe(Waffe waffe) {
		if (this.getInventar().length < 3) {
			inventar[this.getInventar().length] = waffe;
		} else {

			// Case Inventar Voll
			System.out.println("Inventar ist voll. \n\n");
			Sleep(1);
			System.out.println("Möchtest du eine Waffe ersetzen? (y/n): ");
			Scanner input = new Scanner(System.in);

			String answer;

			do {
				answer = input.nextLine().trim().toLowerCase();
				if (!answer.equals("y") && !answer.equals("n")) {
					System.out.println("Ungültige Eingabe. Bitte gib 'y' oder 'n' ein.");
				}
			} while (!answer.equals("y") && !answer.equals("n"));
			
			Sleep(1);
			if (answer.equals("y")) {	
				
				// Inventar einsehen
				System.out.printf("Du hast folgende Waffen im Inventar:\n");
				this.showInventar();

				Sleep(1);

				int replaceIndex = -1;
				do {
					System.out.println("welche Waffe möchtest du ersetzen? (1-" + inventar.length + "): ");

					// checken welche Waffe ersetzt werden soll
					try {
						replaceIndex = input.nextInt() - 1;

						if (replaceIndex < 0 || replaceIndex >= inventar.length) {
							System.out.println("Ungültige Auswahl. Bitte wähle eine Zahl zwischen 1 und " + inventar.length + ".");
							replaceIndex = -1; // Loop restarten bei ungültiger Eingabe
						}
					} catch (Exception e) {
						System.out.println("Ungültige Eingabe. Bitte gib eine Zahl ein!");
						replaceIndex = -1; // Loop restarten bei ungültiger Eingabe
						input.nextLine(); // ungültige Eingabe verwerfen
					}
				} while (replaceIndex < 0 || replaceIndex >= inventar.length);

				// Waffe ersetzen
				inventar[replaceIndex] = waffe;
				System.out.println("Waffe ersetzt!");	

			// ansonsten wird Waffe abgelehnt ohne veränderung	
			} else {
				System.out.println("Waffe abgelehnt.");
			}
		
			input.close();
		}
		
		// Inventar wird zurückgegeben
		// Inventar wird also jedes mal aktualisiert
		System.out.printf("Das ist nun dein Inventar!:\n");
		this.showInventar();


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

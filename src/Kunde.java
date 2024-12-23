/**
*
* @author: jesko
 * @version: 0.1
 * @start-date: 23.12.2024
 *
* Die Klasse repräsentiert einen Kunden.
 * Ursprünglich geplant inkl. einer Liste seiner Konten, was den Zugriff einfacher macht.
 * Dies soll aber abgelöst werden durch eine zentrale Kontenverwaltung, da es die Bearbeitung der Konten und
 * auswertungen aller Konten gemeinsam deutlich einfach macht. Ebenfalls sollten dadurch Transaktionen zwischen Konten
 * einfacher werden.
 *
 * TODO: Konten in die Klasse Bank verschieben!
*
*
*  */

import java.util.ArrayList;
import java.util.Date;

public class Kunde extends Person{
    // Mitarbeiter und Kunden können gleiche Nummern haben, wird durch die Klasse unterschieden
    private static int idNummerCounter = 0;
    private ArrayList<Konto> kundenKonten = new ArrayList<>();
    public Kunde(String vorname, String nachname,
                  Date geburtstag, String telefonnummer){
        super(vorname, nachname, String.valueOf(idNummerCounter++), geburtstag,telefonnummer);

    }
    public void addKonto(Konto konto){
        kundenKonten.add(konto);
    }
    public int getAnzahlAnKonten(){
        return kundenKonten.size();
    }
    public Konto getKonto(int nummer){
        return kundenKonten.get(nummer);
    }
    public Konto getKonto(String kontonummer){
              return kundenKonten.stream()
                         .filter(konto -> konto.getKontoNummer(this).equals(kontonummer))
                         .findFirst()
                         .orElseThrow(() -> new IllegalArgumentException("Kein Konto mit der Nummer " + kontonummer + " vorhanden!"));
    }

}



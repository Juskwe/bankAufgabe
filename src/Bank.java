import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.nio.file.Files;
import java.util.List;


public class Bank {
    private static final Path kundencsvPath = Path.of("src/kunden.csv");
    public static void main(String[] args){

        ArrayList<Kunde> kunden = new ArrayList<>();
        ArrayList<Mitarbeiter> mitarbeiter = new ArrayList<>();
        ArrayList<Konto> konten = new ArrayList<>();

        kunden.add(new Kunde("Hans", "Meier",
                Date.valueOf("1964-05-25"),"+491847292383"));
        kunden.add(new Kunde("Jesus", "Von-Nazareth",
                Date.valueOf("0000-12-24"), "+00000-CallGod"));
        mitarbeiter.add((new Mitarbeiter("Elon", "Esel",
                Date.valueOf("1985-03-03"),"01737382",MinionLevel.IT_ADMIN)));
        mitarbeiter.add(new Mitarbeiter("gustav", "gans",
                Date.valueOf("2000-01-01"),"0129203012093",MinionLevel.SACHBEARBEITER));

        kundenEinlesen(kunden, kundencsvPath);
        for (Kunde kunde : kunden){
            System.out.println(kunde.getVorname() + " " + kunde.getNachname() + " " + kunde.getGeburtstag()
                    + " " + kunde.getTelefonnummer() + " " + kunde.getIdNummer());
        }


    }

    private static String eroeffneKonto(Kunde kunde) {
        Konto neuesKonto = new Konto(kunde.getIdNummer());
        kunde.addKonto(neuesKonto);
        kundenKonten.add(neuesKonto);
        return neuesKonto.getKontoNummer(this);
    }
    //
    private static void kundenEinlesen(ArrayList<Kunde> kunden, Path csvPath){
        List<Kunde> neueKunden;

        try {
            neueKunden = Files.lines(csvPath)
                    .skip(1)
                    .map(zeile -> zeile.split(","))
                    .filter(spalte ->spalte.length ==4)
                    .map(spalte -> new Kunde(
                            spalte[0].trim(), //vorname
                            spalte[1].trim(), //nachname
                            Date.valueOf(spalte[2].trim()), //Geburtsdatum, muss in das DATE-Format geändert werden.
                            spalte[3].trim() // telefonnummer
                    )).toList();
            kunden.addAll(neueKunden);
            System.out.println("Es wurden " + neueKunden.size() + " Kunden aus der CSV hinzugefügt.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}

import java.util.Date;

public class Mitarbeiter extends Person{
    private MinionLevel sicherheitsFreigabe;

    // Mitarbeiter und Kunden können gleiche Nummern haben, wird durch die Klasse unterschieden
    private static int idNummerCounter = 0;

    public Mitarbeiter(String vorname, String nachname,Date geburtstag,
                       String telefonnummer, MinionLevel sicherheitsFreigabe) {
        super(vorname, nachname, String.valueOf(idNummerCounter++), geburtstag, telefonnummer);
        this.sicherheitsFreigabe = sicherheitsFreigabe;
    }
    protected MinionLevel getMinionLevel(){
        return sicherheitsFreigabe;
    }
}

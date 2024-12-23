import java.util.Date;

public abstract class Person {
    private String idNummer;
    private String vorname;
    private String nachname;
    private Date geburtstag;
    private String telefonnummer;


    public Person(String vorname, String nachname, String idNummer, Date geburtstag, String telefonnummer){
        this.vorname = vorname;
        this.nachname = nachname;
        this.idNummer = idNummer;
        this.geburtstag = geburtstag;
        this.telefonnummer = telefonnummer;
    }

    public String getIdNummer() {
        return idNummer;
    }

    public void setIdNummer(String idNummer) {
        this.idNummer = idNummer;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Date getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(Date geburtstag) {
        this.geburtstag = geburtstag;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
}

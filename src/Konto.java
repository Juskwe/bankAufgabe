import java.math.BigDecimal;

public class Konto {
    private static int nextKontoNummer = 10000000;
    private final String kontoNummer;
    private BigDecimal kontoStand;
    private BigDecimal dispoKredit;
    private final String kundenIDNummer;

    public Konto(String kundenIDNummer){
        this.kundenIDNummer = kundenIDNummer;
        this.kontoStand = new BigDecimal("0.00");
        this.dispoKredit = new BigDecimal("0.00");
        this.kontoNummer = String.valueOf(nextKontoNummer++);
    }
    public Konto(String kundenIDNummer, BigDecimal dispoKredit, BigDecimal anfangsKontoStand){
        this(kundenIDNummer);
        this.dispoKredit.add(dispoKredit);
        this.kontoStand.add(anfangsKontoStand);
    }

    public BigDecimal ausZahlung(BigDecimal betrag){
        if(kontoStand.compareTo(betrag)>=0){
            kontoStand.subtract(betrag);
        }else throw new RuntimeException("Kontostand nicht ausreichend");
        return kontoStand;
    }
    public BigDecimal einZahlung(BigDecimal betrag){
        kontoStand.add(betrag);
        return kontoStand;
    }

    public String getKontoNummer(Object caller) {
        if(pruefeBerechtigung(caller)){
            return kontoNummer;
        }
        return null;

    }

    public BigDecimal getKontoStand(Object caller) {
        if(pruefeBerechtigung(caller)){
            return kontoStand;
        } return null;
    }

    public BigDecimal getDispoKredit() {
        return dispoKredit;
    }

    public String getKundenIDNummer() {
        return kundenIDNummer;
    }

    public static int getNextKontoNummer() {
        return nextKontoNummer;
    }

    public void setDispoKredit(BigDecimal dispoKredit) {
        this.dispoKredit = dispoKredit;
    }
    private boolean pruefeBerechtigung(Object caller) {
        if (caller instanceof Mitarbeiter) {
            return ((Mitarbeiter) caller).getMinionLevel().darfKontenBearbeiten();
        } else if (caller instanceof Kunde) {
            return ((Kunde) caller).getIdNummer() == kundenIDNummer;
        } else return false;
    }
}



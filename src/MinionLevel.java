public enum MinionLevel {
    PUTZKRAFT(false),
    IT_MINION(false),
    IT_ADMIN(false),
    MARKETING(false),
    SACHBEARBEITER(true),
    TEAMLEITER(true),
    FILIALLEITER(true),
    CEO(false);

    private final boolean darfKontenBearbeiten;

    MinionLevel(boolean darfKontenBearbeiten){
        this.darfKontenBearbeiten = darfKontenBearbeiten;
    }

    public boolean darfKontenBearbeiten(){
        return darfKontenBearbeiten;
    }

}

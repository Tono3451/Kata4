package software.ulpgc.kata4.model;

public enum League {
    PREMIERLEAGUE("Premier League"),
    LALIGA("La Liga"),
    LIGUE1("Ligue 1"),
    BUNDESLIGA("Bundesliga"),
    SERIAA("Serie A"),
    UNKNOWN("Unknown League");

    private final String text;

    League(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

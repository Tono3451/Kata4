package software.ulpgc.kata4.model;

public class Player {
    private final String name;
    private final String nacionality;
    private final String position;
    private final String squad;
    private final League league;

    public Player(String name, String nacionality, String position, String squad, League league) {
        this.name = name;
        this.nacionality = nacionality;
        this.position = position;
        this.squad = squad;
        this.league = league;
    }

    public String getName() {
        return name;
    }

    public String getNacionality() {
        return nacionality;
    }

    public String getPosition() {
        return position;
    }

    public String getSquad() {
        return squad;
    }

    public League getLeague() {
        return league;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", nacionality='" + nacionality + '\'' +
                ", position='" + position + '\'' +
                ", squad='" + squad + '\'' +
                ", league=" + league +
                '}';
    }
}

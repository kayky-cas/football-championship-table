package models;

public class FootballTeam {
    private String name;

    private int wins;
    private int losses;
    private int ties;

    private int goalsFor;
    private int goalsAgainst;

    public FootballTeam(String name) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
        this.goalsFor = 0;
        this.goalsAgainst = 0;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }


    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void addWin() {
        this.wins++;
        //TODO change points
    }


    private void addLoss() {
        this.losses++;
        //TODO change points
    }
}

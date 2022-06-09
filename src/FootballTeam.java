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
    }


    public void addLoss() {
        this.losses++;
    }

    public void addTie() {
        this.ties++;
    }

    public void addGoalsFor(int goals) {
        this.goalsFor += goals;
    }

    public void addGoalsAgainst(int goals) {
        this.goalsAgainst += goals;
    }

    public int getPoints() {
        return (this.wins * 3) + this.ties;
    }

    public int getGoalDifference() {
        return this.goalsFor - this.goalsAgainst;
    }

    public static String tableHeader() {
        return String.format("%-20s", "Time") +
                String.format("%-5s", "V") +
                String.format("%-5s", "D") +
                String.format("%-5s", "E") +
                String.format("%-5s", "GA") +
                String.format("%-5s", "GC") +
                String.format("%-5s", "DG") +
                String.format("%-5s", "P");
    }

    public String toString() {
        return String.format("%-20s", this.name) +
                String.format("%-5d", this.wins) +
                String.format("%-5d", this.losses) +
                String.format("%-5d", this.ties) +
                String.format("%-5d", this.goalsFor) +
                String.format("%-5d", this.goalsAgainst) +
                String.format("%-5d", this.getGoalDifference()) +
                String.format("%-5d", this.getPoints());
    }
}

public class FootballChampionship {
    private FootballTeam[] teams = new FootballTeam[0];
    private int round = 0;

    public boolean teamExists(String name) {
        for (FootballTeam team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public FootballTeam getTeam(String name) {
        for (FootballTeam team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null;
    }

    public void addTeam(String name) {
        FootballTeam[] newTeams = new FootballTeam[teams.length + 1];
        for (int i = 0; i < teams.length; i++) {
            newTeams[i] = teams[i];
        }
        newTeams[newTeams.length - 1] = new FootballTeam(name);
        teams = newTeams;

        sortTeams();
    }

    private void addProp(String name, String prop) {
        for (FootballTeam team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                if (prop.equals("win")) {
                    team.addWin();
                    return;
                }
                if (prop.equals("loss")) {
                    team.addLoss();
                    return;
                }
                if (prop.equals("tie")) {
                    team.addTie();
                    return;
                }
            }
        }
    }

    private void addProp(String name, String prop, int goals) {
        for (int i = 0; i < teams.length; i++) {
            if (teams[i].getName().equalsIgnoreCase(name)) {
                if (prop.equals("goalsFor")) {
                    teams[i].addGoalsFor(goals);
                    return;
                }
                if (prop.equals("goalsAgainst")) {
                    teams[i].addGoalsAgainst(goals);
                    return;
                }
            }
        }
    }

    private void sortTeams() {
        for (int i = 0; i < teams.length; i++) {
            for (int j = i + 1; j < teams.length; j++) {
                if (teams[i].getPoints() < teams[j].getPoints()) {
                    FootballTeam temp = teams[i];
                    teams[i] = teams[j];
                    teams[j] = temp;
                } else if (teams[i].getPoints() == teams[j].getPoints()) {
                    if (teams[i].getGoalsFor() < teams[j].getGoalsFor()) {
                        FootballTeam temp = teams[i];
                        teams[i] = teams[j];
                        teams[j] = temp;
                    } else if (teams[i].getGoalsFor() == teams[j].getGoalsFor()) {
                        if (teams[i].getGoalsAgainst() < teams[j].getGoalsAgainst()) {
                            FootballTeam temp = teams[i];
                            teams[i] = teams[j];
                            teams[j] = temp;
                        } else if (teams[i].getGoalsAgainst() == teams[j].getGoalsAgainst()) {
                            if (teams[i].getName().compareTo(teams[j].getName()) > 0) {
                                FootballTeam temp = teams[i];
                                teams[i] = teams[j];
                                teams[j] = temp;
                            }
                        }
                    }
                }

            }
        }
    }

    public void addWin(String name) {
        addProp(name, "win");
    }

    public void addLoss(String name) {
        addProp(name, "loss");
    }

    public void addTie(String name) {
        addProp(name, "tie");
    }

    public void addGoalsFor(String name, int goals) {
        addProp(name, "goalsFor", goals);
    }

    public void addGoalsAgainst(String name, int goals) {
        addProp(name, "goalsAgainst", goals);
    }

    public void addRound() {
        round++;
        sortTeams();
    }

    public int quantityOfTeams() {
        return teams.length;
    }

    public void printTable() {
        System.out.printf("========================= Rodada %d =========================\n", round);
        System.out.println(FootballTeam.tableHeader());
        for (FootballTeam team : teams) {
            System.out.println(team);
        }
        System.out.println("============================================================");
    }

}

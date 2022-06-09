import java.util.Scanner;

public class App {
    private FootballChampionship championship = new FootballChampionship();
    private Scanner scanner = new Scanner(System.in);

    private void generateTeams() {
        String[] names = {"Flamengo", "Santos", "Palmeiras", "Gremio"};

        for (String name : names) {
            championship.addTeam(name);
        }
    }

    private void menuAddTeam() {
        String name;

        do {
            System.out.println("Nome do time:");
            name = scanner.nextLine();
        } while (championship.teamExists(name));

        championship.addTeam(name);

        System.out.println("Time adicionado com sucesso!");
    }

    private String readTeam(FootballTeam[] alreadyPlayed, int teamNumber) {
        while (true) {
            System.out.printf("Time %d: ", teamNumber);
            String name = scanner.nextLine();

            if (championship.teamExists(name)) {
                boolean alreadyPlayedCondition = false;
                for (FootballTeam team : alreadyPlayed) {
                    if (team != null && team.getName().equals(name)) {
                        System.out.println("Time já jogou!");
                        alreadyPlayedCondition = true;
                        break;
                    }
                }
                if (!alreadyPlayedCondition) {
                    return name;
                }
            }
            else {
                System.out.println("Time não existe!");
            }
        }
    }

    private void menuAddRound() {

        int games = championship.quantityOfTeams() / 2;

        FootballTeam[] alreadyPlayed = new FootballTeam[games * 2];

        for (int i = 0, j = 0; i < games; i++) {
            System.out.printf("\n\n%d Jogo\n", i + 1);

            String team1 = readTeam(alreadyPlayed, 1);
            alreadyPlayed[j++] = championship.getTeam(team1);

            String team2 = readTeam(alreadyPlayed, 2);
            alreadyPlayed[j++] = championship.getTeam(team2);

            System.out.printf("%s x %s\n", team1, team2);

            System.out.printf("Gols do %s: ", team1);
            int goals1 = scanner.nextInt();
            System.out.printf("Gols do %s: ", team2);
            int goals2 = scanner.nextInt();

            if (goals1 > goals2) {
                championship.addWin(team1);
                championship.addWin(team2);
            } else if (goals1 < goals2) {
                championship.addLoss(team1);
                championship.addWin(team2);
            } else {
                championship.addLoss(team1);
                championship.addLoss(team2);
            }

            championship.addGoalsFor(team1, goals1);
            championship.addGoalsFor(team2, goals2);
            championship.addGoalsAgainst(team1, goals2);
            championship.addGoalsAgainst(team2, goals1);

            scanner.nextLine();
        }

        championship.addRound();
    }

    private void menu() {
        int option;

        while (true) {
            System.out.println("1- Adicionar time");
            System.out.println("2- Nova rodada");
            System.out.println("3- Exibir tabela");
            System.out.println("4- Exit");

            do {
                System.out.println("Escolha uma opção:");
                option = scanner.nextInt();
                scanner.nextLine();
            } while (option < 1 || option > 4);

            switch (option) {
                case 1:
                    menuAddTeam();
                    break;
                case 2:
                    menuAddRound();
                    break;
                case 3:
                    championship.printTable();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }


    public static void main(String[] args) {
        App app = new App();

        System.out.print("Adicionar os times principais? (S/n): ");
        String option = app.scanner.nextLine();

        if (!option.equals("n")) {
            app.generateTeams();
        }

        app.menu();
    }
}

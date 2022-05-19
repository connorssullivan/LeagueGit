package Legue;

public class Main {
    public static void main(String[] args) {

        FootballPlayer hall = new FootballPlayer("Diangelo Hall");
        FootballPlayer young = new FootballPlayer("Chase Young");
    Team<FootballPlayer> redskins = new Team<>("Washington Redskins");

    redskins.addPlayer(hall);
    redskins.addPlayer(young);

        System.out.println(redskins.numPlayers());

        Team<FootballPlayer> cowboys = new Team<>("Dallas Cowboys");
        FootballPlayer elliot = new FootballPlayer("Elliot");



        cowboys.addPlayer(elliot);



        League<Team<FootballPlayer>> nfl = new League<>("NFL");

        nfl.addTeam(redskins);
        nfl.addTeam(cowboys);

       Team.matchResults(redskins,7,cowboys,0);
        Team.matchResults(redskins,7,cowboys,0);

        StandingsSaver.standings(nfl);

        cowboys.printGameList();

        nfl.saveGames(redskins);
        System.out.println(nfl.getGamesString());

        StandingsSaver.saveGamesToFile(nfl);


    }
}

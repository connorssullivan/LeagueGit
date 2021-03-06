package Legue;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    private ArrayList<Game> games = new ArrayList<>();

    private ArrayList<T> members = new ArrayList<>();

    //get the list of games in a given team***
    public ArrayList<Game> getGames() {
        return games;
    }

    public Team(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Game getGame(int i) {
        return games.get(i);
    }



    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + ", is already on the team ");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + ", was added to the team");
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

        //returns the match results and saves the gane in arraylist of whoever the home team is
    public static void matchResults(Team ourTeam,int ourScore, Team opponent, int theirScore) {


        String message;

        if(ourScore > theirScore) {
            ourTeam.won++;
            opponent.lost++;
            message = " beat ";
        } else if(ourScore == theirScore) {
            ourTeam.tied++;
            opponent.tied++;
            message = " drew with ";

        } else {
            ourTeam.lost++;
            opponent.won++;
            message = " lost to ";
        }
        ourTeam.played++;



        ourTeam.games.add(new Game(ourTeam,ourScore, opponent, theirScore));
        opponent.games.add(new Game(opponent, theirScore, ourTeam, ourScore));

        //System.out.println(ourTeam.getName() + message + opponent.getName());

    }

    public void printGameList() {
        for (int i = 0; i < games.size(); i++) {
            System.out.println(games.get(i).getResults());
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }

}

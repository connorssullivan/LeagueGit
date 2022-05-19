package Legue;

import java.util.ArrayList;
import java.util.Collections;

public class League <T extends Team>{
    public String name;
    public ArrayList<T> league = new ArrayList<T>();
    private ArrayList<Game> games = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team) {
        if (league.contains(team)) {
            System.out.println(team.getName() + ", is already in the "+ name);
            return false;
        }else {
            league.add(team);
            System.out.println(team.getName() + ", was added to the " + this.name);
            return true;
        }
    }

    //Sets up a table for the legue standings
    public String leagueStandings() {
        Collections.sort(league);

        String standings ="\n\n\t\t Wins Losses Ties\n";
        for (int i = 0; i < this.league.size(); i++) {
            standings+=(this.league.get(i).getName() + ": " +
                    this.league.get(i).won + "\t" + this.league.get(i).lost +
                    "\t" + this.league.get(i).tied + "\n");
        }
        return standings;

    }

    //save the games to the legue of a given team
    public void saveGames(Team team) {
        for (int i = 0; i< team.getGames().size();i++) {
            this.games.add(team.getGame(i));
        }
    }

    //returns the games in string form
    public String getGamesString() {
        String initialized = "";
        for (int i = 0; i<this.games.size();i++) {
            initialized+= this.games.get(i).getResults() + "\n";
        }
        return initialized;
    }
}

package cs301.Soccer;

import android.util.Log;
import cs301.Soccer.soccerPlayer.SoccerPlayer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 *
 * @author *** Jack Volonte ***
 * @version *** put date of completion here ***
 *
 */
public class SoccerDatabase implements SoccerDB {

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    public Hashtable<String, SoccerPlayer> players = new Hashtable<String, SoccerPlayer>();

    @Override
    public boolean addPlayer(String firstName, String lastName,
                             int uniformNumber, String teamName) {
        String key = (firstName + "##" + lastName);
        if ( !this.players.containsKey(key) ) {
            SoccerPlayer a = new SoccerPlayer(firstName, lastName, uniformNumber, teamName);
            this.players.put(key, a);
            return true;
        }
        return false;
    }

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName) {
        if ( this.players.containsKey(firstName+"##"+lastName)) {
            this.players.remove(firstName+"##"+lastName);
            return true;
        }
        return false;
    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
    public SoccerPlayer getPlayer(String firstName, String lastName) {
        String key = (firstName + "##" + lastName);
        if ( this.players.containsKey(key)) {
            SoccerPlayer a = this.players.get(key);
            return a;
        }

        return null;
    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName) {
        String key = (firstName + "##" + lastName);
        if ( this.players.contains(key) ) {
            SoccerPlayer a = this.players.get(key);
            a.bumpGoals();
            return true;
        }
        return false;
    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @Override
    public boolean bumpAssists(String firstName, String lastName) {
        String key = (firstName + "##" + lastName);
        if ( this.players.contains(key) ) {
            SoccerPlayer a = this.players.get(key);
            a.bumpAssists();
            return true;
        }
        return false;
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName) {
        String key = (firstName + "##" + lastName);
        if ( this.players.contains(key) ) {
            SoccerPlayer a = this.players.get(key);
            a.bumpShots();
            return true;
        }
        return false;
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName) {
        String key = (firstName + "##" + lastName);
        if ( this.players.contains(key) ) {
            SoccerPlayer a = this.players.get(key);
            a.bumpSaves();
            return true;
        }
        return false;
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName) {
        String key = (firstName + "##" + lastName);
        if ( this.players.contains(key) ) {
            SoccerPlayer a = this.players.get(key);
            a.bumpFouls();
            return true;
        }
        return false;
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {
        String key = (firstName + "##" + lastName);
        if ( this.players.contains(key) ) {
            SoccerPlayer a = this.players.get(key);
            a.bumpYellowCards();
            return true;
        }
        return false;
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName) {
        String key = (firstName + "##" + lastName);
        if ( this.players.contains(key) ) {
            SoccerPlayer a = this.players.get(key);
            a.bumpRedCards();
            return true;
        }
        return false;
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
    public int numPlayers(String teamName) {
        int count = 0;
        if ( teamName == null) {
            return this.players.size();
        } else {
            count = 0;
            Set<String> keySet = this.players.keySet();
            for ( String key : keySet ) {
                SoccerPlayer a = this.players.get(key);
                if ( a.getTeamName() == teamName ) {
                    count++;
                }
            }
            return count;
        }


    }

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
    // get the nTH player
    @Override
    public SoccerPlayer playerNum(int idx, String teamName) {
        if ( idx > this.players.size() ) {
            return null;
        } else {
            int count = 0;
            Set<String> keySet = this.players.keySet();
            for ( String key : keySet) {
                SoccerPlayer a = this.players.get(key);
                if ( a.getTeamName() == teamName ) {

                    if ( count == idx ) {
                        return a;
                    }
                    count++;
                }
            }

        }
        return null;
    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
    // read data from file
    @Override
    public boolean readData(File file) {
        return file.exists();
    }

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
    // write data to file
    @Override
    public boolean writeData(File file) {
        return false;
    }

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see cs301.Soccer.SoccerDB#getTeams()
     */
    // return list of teams
    @Override
    public HashSet<String> getTeams() {
        return new HashSet<String>();
    }

}

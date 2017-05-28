package a420.blaze.it.final_frontier;
//Tutorial guidance for database construction inserting and reading followed by YouTube Android Studio Tutorial - 32,33, 34 with adjustments according to purpose
//Created by Chris
public class DataProviderChris {
    private String PlayerName;
    private String Score;

    public String getPlayerName() {
        return PlayerName;
    }

    public String getScore() {
        return Score;
    }

    public void setPlayerName() {
        this.PlayerName = PlayerName;
    }

    public void setScore() {
        this.Score = Score;
    }

    public DataProviderChris(String PlayerName, String Score) {
        this.PlayerName = PlayerName;
        this.Score = Score;
    }
}

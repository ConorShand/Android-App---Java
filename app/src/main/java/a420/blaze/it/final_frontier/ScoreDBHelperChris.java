package a420.blaze.it.final_frontier;
//Tutorial guidance for database construction inserting and reading followed by YouTube Android Studio Tutorial - 32,33, 34 with adjustments according to purpose
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//Created by Chris

public class ScoreDBHelperChris extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Scoreboard.DB";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_QUERY =
            "CREATE TABLE " + ScoreDBChris.NewScore.TABLE_NAME + "(" + ScoreDBChris.NewScore.PlayerName + " TEXT," + ScoreDBChris.NewScore.HIGHSCORE + " INT);";

    public ScoreDBHelperChris(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.e("Scoreboard logs", "Displaying Scoreboard...");
    }

    @Override
    public void onCreate(SQLiteDatabase db)/* if the database is created for the first time the system call the onCreate method*/ {
        db.execSQL(CREATE_QUERY);
        Log.e("Scoreboard logs", "Loading Scoreboard...");
    }

    public void addInformation(String name, String Score, SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ScoreDBChris.NewScore.PlayerName, name);
        contentValues.put(ScoreDBChris.NewScore.HIGHSCORE, Score);
        db.insert(ScoreDBChris.NewScore.TABLE_NAME, null, contentValues);
        Log.e("Scoreboard logs", "Updating Scoreboard...");
    }

    public Cursor getInformation(SQLiteDatabase db) {
        Cursor cursor;
        String[] projections = {ScoreDBChris.NewScore.PlayerName, ScoreDBChris.NewScore.HIGHSCORE};
        cursor = db.query(ScoreDBChris.NewScore.TABLE_NAME, projections, null, null, null, null, ScoreDBChris.NewScore.HIGHSCORE + " ASC");
        return cursor;
        /*TABLE_NAME,projections,selection,selection arguments (Where),Group by,filter by row groups, sort order ASCEND/DESCEND*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

package a420.blaze.it.final_frontier;
//Tutorial guidance for database construction inserting and reading followed by YouTube Android Studio Tutorial - 32,33, 34 with adjustments according to purpose
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

//Created by Chris
public class DataScoreboardChris extends AppCompatActivity {
    ListView listview;
    SQLiteDatabase sqLiteDatabase;
    ScoreDBHelperChris scoredbhelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.scoreboard_layout_Chris);
       // listview = (ListView) findViewById(R.id.list_view);
       // listDataAdapter = new ListDataAdapter(getApplicationContext(), R.layout.scoreboard_layout_Chris);
        listview.setAdapter(listDataAdapter);
        scoredbhelper = new ScoreDBHelperChris(getApplicationContext());
        sqLiteDatabase = scoredbhelper.getReadableDatabase();
        cursor = scoredbhelper.getInformation(sqLiteDatabase);
        if (cursor.moveToFirst()) {
            do {
                String Playername, Score;
                Playername = cursor.getString(0);
                Score = cursor.getString(1);
                DataProviderChris dataProvider = new DataProviderChris(Playername, Score);
                listDataAdapter.add(dataProvider);

            } while (cursor.moveToNext());
        }
    }
    public void viewScoreboard(View view) {
        Intent intent = new Intent(this, DataScoreboardChris.class);
        startActivity(intent);
    }
}


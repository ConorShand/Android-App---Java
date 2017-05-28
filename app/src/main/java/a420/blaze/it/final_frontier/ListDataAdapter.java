package a420.blaze.it.final_frontier;
//Tutorial guidance for database construction inserting and reading followed by YouTube Android Studio Tutorial - 32,33, 34 with adjustments according to purpose
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//Created by Chris

public class ListDataAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler {
        TextView PlayerName, Score;
    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutHandler layouthandler;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //row = layoutInflater.inflate(R.layout.scoreboard_layout_Chris, parent, false);
            layouthandler = new LayoutHandler();
           // layouthandler.PlayerName = (TextView) row.findViewById(R.id.text_Player_Name);
           // layouthandler.Score = (TextView) row.findViewById(R.id.text_Score);
            row.setTag(layouthandler);
        } else {
            layouthandler = (LayoutHandler) row.getTag();
        }
        DataProviderChris dataProvider = (DataProviderChris) this.getItem(position);
        layouthandler.PlayerName.setText(dataProvider.getPlayerName());
        layouthandler.Score.setText(dataProvider.getScore());

        return row;
    }

}

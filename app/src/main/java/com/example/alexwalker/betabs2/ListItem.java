package com.example.alexwalker.betabs2;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by AlexWalker on 22.11.2016.
 */

public class ListItem implements Item {
    private final String str1;
    private final String str2;

    public ListItem(String text1, String text2) {
        this.str1 = text1;
        this.str2 = text2;
    }

    @Override
    public int getViewType() {
        return LessonsListAdapter.RowType.LIST_ITEM.ordinal();
    }

    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.custom_adapter, null);
            // Do some initialization
        } else {
            view = convertView;
        }

        TextView text1 = (TextView) view.findViewById(R.id.lessonName);
        TextView text2 = (TextView) view.findViewById(R.id.lessonAddress);
        text1.setText(str1);
        text2.setText(str2);

        return view;
    }

}
package com.example.alexwalker.betabs2;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


public class ListItem implements Item {
    private final String name;
    private final String address;
    private final String number;

    public ListItem(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    @Override
    public int getViewType() {
        return LessonsListAdapter.RowType.LIST_ITEM.ordinal();
    }

    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.custom_adapter, null);

        } else {
            view = convertView;
        }

        TextView lessonName = (TextView) view.findViewById(R.id.lessonName);
        TextView lessonAddress = (TextView) view.findViewById(R.id.lessonAddress);
        TextView lessonNumber = (TextView)view.findViewById(R.id.lessonNumber);
        lessonName.setText(name);
        lessonAddress.setText(address);
        lessonNumber.setText(number);

        return view;
    }

}
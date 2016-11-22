package com.example.alexwalker.betabs2;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class Header implements Item {
    private final String name;

    public Header(String name) {
        this.name = name;
    }

    @Override
    public int getViewType() {
        return LessonsListAdapter.RowType.HEADER_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        View view;
        if (convertView == null) {
            view = (View) inflater.inflate(R.layout.custom_adapter_header, null);

        } else {
            view = convertView;
        }

        TextView text = (TextView) view.findViewById(R.id.textSeparator);
        text.setText(name);

        return view;
    }

}
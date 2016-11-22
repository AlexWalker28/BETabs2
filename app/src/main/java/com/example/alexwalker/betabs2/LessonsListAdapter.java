package com.example.alexwalker.betabs2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LessonsListAdapter extends ArrayAdapter<Item> {
    private LayoutInflater mInflater;

    public enum RowType {
        LIST_ITEM, HEADER_ITEM
    }

    public LessonsListAdapter(Context context, List<Item> items) {
        super(context, 0, items);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getViewTypeCount() {
        return RowType.values().length;

    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getViewType();
    }

    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItem(position).getView(mInflater, convertView);
    }*/

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int rowType = getItemViewType(position);
        View View;
        if (convertView == null) {
            holder = new ViewHolder();
            switch (rowType) {
                case TYPE_ITEM:
                    convertView = mInflater.inflate(R.layout.custom_adapter, null);
                    holder.View = getItem(position).getView(mInflater, convertView);
                    break;
                case TYPE_SEPARATOR:
                    convertView = mInflater.inflate(R.layout.custom_adapter_header, null);
                    holder.View = getItem(position).getView(mInflater, convertView);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    public static class ViewHolder {
        public View View;
    }
}
package com.example.alexwalker.betabs2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class LessonListAdapter extends BaseAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    private ArrayList<String> mData = new ArrayList<String>();
    private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();

    private LayoutInflater mInflater;

    public LessonListAdapter(Context context) {
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(final String item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void addSectionHeaderItem(final String item) {
        mData.add(item);
        sectionHeader.add(mData.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int rowType = getItemViewType(position);
        if (convertView == null) {
            holder = new ViewHolder();
            switch (rowType) {
                case TYPE_ITEM:
                    convertView = mInflater.inflate(R.layout.custom_adapter, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.lessonName);
                    break;
                case TYPE_SEPARATOR:
                    convertView = mInflater.inflate(R.layout.custom_adapter_header, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.textSeparator);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(mData.get(position));

        return convertView;
    }

    public static class ViewHolder {
        public TextView textView;
    }

}
/*
public class LessonsListAdapter extends BaseAdapter {
    private List<Lesson> lessonList;
    private LayoutInflater layoutInflater;
    Converter converter;

    public LessonsListAdapter(Context context, List<Lesson> lessonList) {
        this.lessonList = lessonList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lessonList.size();
    }

    @Override
    public Object getItem(int position) {
        return lessonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.custom_adapter, null);
            holder = new ViewHolder();
            holder.lessonNumber = (TextView) convertView.findViewById(R.id.lessonNumber);
            holder.lessonName = (TextView) convertView.findViewById(R.id.lessonName);


            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.lessonNumber.setText(converter.convertLessonNumber(lessonList.get(position).getLessonNumber().getNumber()));
        holder.lessonName.setText(lessonList.get(position).getLessonName().getFullName());
        */
/*holder.lessonOrder.setText(lessonList.get(position).getLessonOrder());*//*

        holder.dayOfTheWeek.setText(converter.convertDay(lessonList.get(position).getWeek().getDayOfTheWeek()));
       // if (!(position == 0 || lessonList.get(position).getWeek().getDayOfTheWeek() != lessonList.get(position - 1).getWeek().getDayOfTheWeek()))
        //holder.dayOfTheWeek.setVisibility(View.GONE);
        return convertView;
    }

    static class ViewHolder {
        TextView lessonNumber;
        TextView lessonName;

        //TextView dayOfTheWeek;
    }


}*/

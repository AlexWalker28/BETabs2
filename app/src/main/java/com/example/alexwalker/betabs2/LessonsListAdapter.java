package com.example.alexwalker.betabs2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

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
            holder.lessonOrder = (TextView) convertView.findViewById(R.id.lessonOrder);
            holder.dayOfTheWeek = (TextView) convertView.findViewById(R.id.dayTextView);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        holder.lessonNumber.setText(converter.convertLessonNumber(lessonList.get(position).getLessonNumber().getNumber()));
        holder.lessonName.setText(lessonList.get(position).getLessonName().getFullName());
        /*holder.lessonOrder.setText(lessonList.get(position).getLessonOrder());*/
        holder.dayOfTheWeek.setText(converter.convertDay(lessonList.get(position).getWeek().getDayOfTheWeek()));
       // if (!(position == 0 || lessonList.get(position).getWeek().getDayOfTheWeek() != lessonList.get(position - 1).getWeek().getDayOfTheWeek()))
        //holder.dayOfTheWeek.setVisibility(View.GONE);

        return convertView;
    }

    static class ViewHolder {
        TextView lessonNumber;
        TextView lessonName;
        TextView lessonOrder;
        TextView dayOfTheWeek;
    }


}
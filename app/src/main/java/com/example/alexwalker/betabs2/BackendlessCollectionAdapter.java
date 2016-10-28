package com.example.alexwalker.betabs2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.backendless.BackendlessCollection;

public class BackendlessCollectionAdapter extends BaseAdapter {
    private BackendlessCollection <Group> backendlessCollection;
    private LayoutInflater layoutInflater;

    public BackendlessCollectionAdapter(Context context, BackendlessCollection <Group> backendlessCollection){
        this.backendlessCollection = backendlessCollection ;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return backendlessCollection.getData().size();
    }
    @Override
    public Object getItem(int position){
        return backendlessCollection.getData().get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.custom_adapter,null);
            holder = new ViewHolder();
            holder.groupNumber = (TextView)convertView.findViewById(R.id.textView2);
            holder.isLecture = (TextView)convertView.findViewById(R.id.textView3);
            holder.lessonName = (TextView)convertView.findViewById(R.id.textView4);
            holder.lessonNumber = (TextView)convertView.findViewById(R.id.textView5);
            holder.week = (TextView)convertView.findViewById(R.id.textView6);
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder)convertView.getTag();
        }


        holder.groupNumber.setText("Группа: " + backendlessCollection.getData().get(position).getGroupNumber().toString());
        holder.isLecture.setText("Лекция: " + backendlessCollection.getData().get(position).getGroupFaculty());
        holder.lessonName.setText("Предмет: " + backendlessCollection.getData().get(position).getGroupLesson());
        /*holder.lessonNumber.setText("Номер пары: " + backendlessCollection.getData().get(position).getLessonNumber());
        holder.week.setText("День недели: " + backendlessCollection.getData().get(position).getWeek());*/
        return convertView;
    }

    static class ViewHolder{
        TextView groupNumber;
        TextView isLecture;
        TextView lessonName;
        TextView lessonNumber;
        TextView week;
    }



}
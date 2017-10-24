package com.duong.appailatrieuphu;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Duong on 11/09/2016.
 */
public class AdapterHighScore extends BaseAdapter {
    private List<ItemHighScore> itemHighScores;

    public AdapterHighScore(){
        init();
    }

    private void init(){
       itemHighScores = new ArrayList<>();
        itemHighScores.add(new ItemHighScore("Vo danh","100000"));
    }

    @Override
    public int getCount() {
        return itemHighScores.size();
    }

    @Override
    public ItemHighScore getItem(int i) {
        return itemHighScores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup viewGroup) {
        ViewHolder holder;
        if(contentView == null){
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            contentView = inflater.inflate(R.layout.item_high_score, viewGroup, false);

            holder = new ViewHolder();
            holder.tvName = (TextView)contentView.findViewById(R.id.tvName);
            holder.tvScore = (TextView)contentView.findViewById(R.id.tvScore);
            contentView.setTag(holder);
        }else {
            holder = (ViewHolder)contentView.getTag();
        }

        ItemHighScore itemHighScore = itemHighScores.get(position);
        holder.tvName.setText(itemHighScore.getName());
        holder.tvScore.setText(itemHighScore.getScore());

        return contentView;
    }

    private class ViewHolder{
        private TextView tvName;
        private TextView tvScore;
    }
}

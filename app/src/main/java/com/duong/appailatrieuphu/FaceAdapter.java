package com.duong.appailatrieuphu;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Duong on 30/08/2016.
 */
public class FaceAdapter extends BaseAdapter {
    private int currentPosition = -1;
    private List<Item> items;

    public FaceAdapter() {
        init();
    }

    private void init(){
        items = new ArrayList<>();

        items.add(new Item(R.drawable.messi, "Messi"));
        items.add(new Item(R.drawable.congvinh, "C.Vinh"));
        items.add(new Item(R.drawable.bill, "Bill"));
        items.add(new Item(R.drawable.suarez, "Suarez"));
        items.add(new Item(R.drawable.ronaldo, "C.Ronaldo"));
        items.add(new Item(R.drawable.bigronaldo, "Ronaldo"));
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int i) {
        return items.get(i);
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
            contentView = inflater.inflate(R.layout.icon_gird, viewGroup, false);

            holder = new ViewHolder();
            holder.ivImage = (ImageView)contentView.findViewById(R.id.item_grid);
            holder.tvContent = (TextView)contentView.findViewById(R.id.tv_grid);

            contentView.setTag(holder);
        }
        holder = (ViewHolder)contentView.getTag();

        Item item = items.get(position);
        holder.ivImage.setImageResource(item.getIdImage());
        holder.tvContent.setText(item.getTvContent());
        if(currentPosition == position){
            contentView.setBackgroundColor(Color.BLUE);
        }else {
            contentView.setBackgroundColor(Color.WHITE);
        }
        return contentView;
    }

    private class ViewHolder{
        private ImageView ivImage;
        private TextView tvContent;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}

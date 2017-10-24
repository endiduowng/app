package com.duong.appailatrieuphu;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Nguyen Duong on 27/08/2016.
 */
public class FirstFragment extends Fragment implements View.OnClickListener{
    private TextView tvTiepTuc;
    private TextView tv5, tv10, tv15;
    private Animation animation;
    private Handler handler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.first_layout, container, false);
        tvTiepTuc = (TextView)v.findViewById(R.id.tv_tiep_tuc);
        tvTiepTuc.setOnClickListener(this);
        tv5 = (TextView)v.findViewById(R.id.tv5);
        tv10 = (TextView)v.findViewById(R.id.tv10);
        tv15 = (TextView)v.findViewById(R.id.tv15);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv5.setBackgroundColor(Color.BLACK);
            }
        },1000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv5.setBackgroundResource(R.color.colorPrimaryDark);
                tv10.setBackgroundColor(Color.BLACK);
            }
        },2500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv10.setBackgroundResource(R.color.colorPrimaryDark);
                tv15.setBackgroundColor(Color.BLACK);
            }
        },4000);

        return v;
    }


    @Override
    public void onClick(final View view) {
        TiepTucDialog dialog = new TiepTucDialog(getContext());
        dialog.show();
    }
}

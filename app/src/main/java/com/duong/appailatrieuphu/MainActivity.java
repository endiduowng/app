package com.duong.appailatrieuphu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvNowPlay, tvHighScore;
    private FirstFragment firstFragment;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        tvHighScore = (TextView) findViewById(R.id.tv_high_score);
        tvNowPlay = (TextView) findViewById(R.id.tv_now_play);
        tvHighScore.setOnClickListener(this);
        tvNowPlay.setOnClickListener(this);
        handler = new Handler();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_now_play:
                tvNowPlay.setBackgroundResource(R.drawable.bg_now_play);
                AnimationDrawable drawable = (AnimationDrawable)tvNowPlay.getBackground();
                drawable.start();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        firstFragment = new FirstFragment();
                        Fragment fragment = getSupportFragmentManager().findFragmentByTag(FirstFragment.class.getName());
                        if(fragment != null && !fragment.isVisible()){
                            return;
                        }
                        showFirstFragmentForAdd();
                    }
                },2000);
                break;
            case R.id.tv_high_score:
                tvHighScore.setBackgroundResource(R.drawable.bg_high_score);
                drawable = (AnimationDrawable)tvHighScore.getBackground();
                drawable.start();
                final HighScoreDialog dialog = new HighScoreDialog(this);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.show();
                    }
                }, 2000);
                break;
        }
    }

    private void showFirstFragmentForAdd(){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.open_enter, R.anim.open_exit, R.anim.close_enter, R.anim.close_exit)
                .replace(R.id.content, firstFragment, FirstFragment.class.getName())
                .addToBackStack("first")
                .commit();
    }


}

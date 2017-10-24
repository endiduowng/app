package com.duong.appailatrieuphu;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nguyen Duong on 28/08/2016.
 */
public class SecondActivity extends AppCompatActivity {
    private ThirdFragment thirdFragment;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        thirdFragment = new ThirdFragment();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Fragment fragment = getSupportFragmentManager().findFragmentByTag(ThirdFragment.class.getName());
                if(fragment != null && fragment.isVisible()){
                    return;
                }
                showThirdFragment();
            }
        },5000);
    }

    private void showThirdFragment(){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.open_enter, R.anim.open_exit, R.anim.close_enter, R.anim.open_exit)
                .replace(R.id.fr_content, thirdFragment, ThirdFragment.class.getName())
                .addToBackStack("third")
                .commit();
    }

}

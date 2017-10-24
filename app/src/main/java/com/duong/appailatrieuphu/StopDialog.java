package com.duong.appailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Duong on 30/08/2016.
 */
public class StopDialog extends Dialog implements View.OnClickListener {
//    private List<ItemHighScore> itemHighScores;
    private TextView tvLuuDiem, tvHuy, tvScore;
    private EditText edtPlayer;

    public StopDialog(Context context) {
        super(context);
        init();
    }

    private void init(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.stop_dialog);
        tvHuy = (TextView)findViewById(R.id.tv_huy);
        tvLuuDiem = (TextView)findViewById(R.id.tv_luu_diem);
        tvScore = (TextView)findViewById(R.id.tv_score);
        edtPlayer = (EditText)findViewById(R.id.edt_player);
        tvLuuDiem.setOnClickListener(this);
        tvHuy.setOnClickListener(this);
//        itemHighScores = new ArrayList<>();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_huy:
//                itemHighScores.add(new ItemHighScore("Vo danh", tvScore.getText().toString()));
                Intent intent = new Intent();
                intent.setClass(getContext(), MainActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.tv_luu_diem:
//                itemHighScores.add(new ItemHighScore(edtPlayer.getText().toString(), tvScore.getText().toString()));
                intent = new Intent();
                intent.setClass(getContext(), MainActivity.class);
                getContext().startActivity(intent);
                break;
        }
    }

//    public List<ItemHighScore> getItemHighScores() {
//        return itemHighScores;
//    }
}

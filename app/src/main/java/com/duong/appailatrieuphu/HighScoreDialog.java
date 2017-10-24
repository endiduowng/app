package com.duong.appailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Nguyen Duong on 27/08/2016.
 */
public class HighScoreDialog extends Dialog implements View.OnClickListener {
    private TextView tvOk;
    private AdapterHighScore adapterHighScore;
    private ListView listView;

    public HighScoreDialog(Context context) {
        super(context);
        init();
    }

    private void init() {
//        listView = (ListView)findViewById(R.id.listViewHighScore);
//        adapterHighScore = new AdapterHighScore();
//        listView.setAdapter(adapterHighScore);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.high_score_dialog);
        tvOk = (TextView) findViewById(R.id.tv_ok);
        tvOk.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(getContext(), MainActivity.class);
        getContext().startActivity(intent);
    }
}

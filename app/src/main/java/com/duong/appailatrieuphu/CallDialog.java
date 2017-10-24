package com.duong.appailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by Nguyen Duong on 30/08/2016.
 */
public class CallDialog extends Dialog implements AdapterView.OnItemClickListener, View.OnClickListener {
    private FaceAdapter adapter;
    private GridView gridView;
    private TextView tvOk, tvAnswer;

    public CallDialog(Context context) {
        super(context);
        init();
    }

    private void init(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.call_dialog);
        adapter = new FaceAdapter();
        gridView = (GridView)findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
        tvOk = (TextView)findViewById(R.id.tv_ok);
        tvOk.setOnClickListener(this);
        tvAnswer = (TextView)findViewById(R.id.tv_answer);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        adapter.setCurrentPosition(position);
        adapter.notifyDataSetChanged();
        tvAnswer.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {
        this.dismiss();
    }
}

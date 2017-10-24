package com.duong.appailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.Window;

/**
 * Created by Nguyen Duong on 28/08/2016.
 */
public class TiepTucDialog extends Dialog implements View.OnClickListener {

    public TiepTucDialog(Context context) {
        super(context);
        init();
    }

    private void init(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.tiep_tuc_dialog);
        findViewById(R.id.btn_san_sang).setOnClickListener(this);
        findViewById(R.id.btn_huy_bo).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_san_sang:
                findViewById(R.id.btn_san_sang).setBackgroundColor(Color.BLUE);
                Intent intent = new Intent();
                intent.setClass(getContext(), SecondActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.btn_huy_bo:
                findViewById(R.id.btn_huy_bo).setBackgroundColor(Color.RED);
                intent = new Intent();
                intent.setClass(getContext(), MainActivity.class);
                getContext().startActivity(intent);
                break;
        }
    }
}

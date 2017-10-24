package com.duong.appailatrieuphu;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Nguyen Duong on 28/08/2016.
 */
public class FourActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int UPDATE_TIME = 0;
    private RelativeLayout rlHelp;
    private LinearLayout lnAnswer;
    private Handler handler;
    private TextView tvTime;
    private ImageView ivPercent50, ivCall, ivHelp, ivRestart, ivHand;
    private TextView tvQuestion, tvScore, tvQuestionNumber;
    private TextView tvCaseA, tvCaseB, tvCaseC, tvCaseD;
    private ManagerQuestion managerQuestion;
    private boolean isChoose = false;
    private int i = 0;
    private int j = 30;
    private Thread thread;
    private boolean isRunning = true;
    private ThirdFragment thirdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_layout);
        init();
        initQuestion();
    }

    private void initQuestion(){
        managerQuestion = new ManagerQuestion(this);
        managerQuestion.openDatabase();

        tvQuestion.setText(managerQuestion.getQuestions().get(i).getQuestion());
        tvCaseA.setText(managerQuestion.getQuestions().get(i).getCaseA());
        tvCaseB.setText(managerQuestion.getQuestions().get(i).getCaseB());
        tvCaseC.setText(managerQuestion.getQuestions().get(i).getCaseC());
        tvCaseD.setText(managerQuestion.getQuestions().get(i).getCaseD());

        while(isRunning){
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while(j>=0){
                        SystemClock.sleep(1000);
                        Message message = new Message();
                        message.what = UPDATE_TIME;
                        message.obj = new  String("Time: " + j);
                        message.setTarget(handler);
                        message.sendToTarget();
                        j--;
                    }

                }
            });
            thread.start();
            isRunning = false;
        }
    }

    private void init(){
        lnAnswer = (LinearLayout)findViewById(R.id.ln_answer);
        rlHelp = (RelativeLayout)findViewById(R.id.rl_play);
        tvTime = (TextView)findViewById(R.id.tv_time);
        tvCaseA = (TextView)findViewById(R.id.tv_case_a);
        tvCaseB = (TextView)findViewById(R.id.tv_case_b);
        tvCaseC = (TextView)findViewById(R.id.tv_case_c);
        tvCaseD = (TextView)findViewById(R.id.tv_case_d);
        ivCall = (ImageView)findViewById(R.id.iv_call);
        tvQuestion = (TextView)findViewById(R.id.tv_question);
        tvScore = (TextView)findViewById(R.id.tv_score);
        ivPercent50 = (ImageView)findViewById(R.id.iv_percent50);
        ivHelp = (ImageView)findViewById(R.id.iv_help);
        ivHand = (ImageView)findViewById(R.id.iv_hand);
        ivRestart = (ImageView)findViewById(R.id.iv_restart);

        rlHelp.setOnClickListener(this);
        lnAnswer.setOnClickListener(this);
        tvCaseA.setOnClickListener(this);
        tvCaseB.setOnClickListener(this);
        tvCaseC.setOnClickListener(this);
        tvCaseD.setOnClickListener(this);
        ivHelp.setOnClickListener(this);
        ivPercent50.setOnClickListener(this);
        ivHand.setOnClickListener(this);
        ivCall.setOnClickListener(this);
        ivRestart.setOnClickListener(this);

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case UPDATE_TIME:
                        tvTime.setText((String)msg.obj);
                        break;
                }
            }
        };

//        Thread thread = new Thread(this);
//        thread.start();
    }

//    @Override
//    public void run() {
//        for(;j >= 0; j--){
//            SystemClock.sleep(1000);
//            Message message = new Message();
//            message.what = UPDATE_TIME;
//            message.obj = new  String("Time: " + j);
//            message.setTarget(handler);
//            message.sendToTarget();
//        }
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_case_a:
                if(!isChoose){
                    isRunning = true;
                    isChoose = true;
                    tvCaseA.setBackgroundResource(R.drawable.icon_choose);
                    AnimationDrawable drawable = (AnimationDrawable)tvCaseA.getBackground();
                    drawable.start();
                    rlHelp.setClickable(false);
                    lnAnswer.setClickable(false);
                    int trueCase = managerQuestion.getQuestions().get(i).getTrueCase();
                    if(tvCaseA.getText().equals(managerQuestion.getQuestions().get(i).getCases().get(trueCase - 1))){
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tvCaseA.setBackgroundResource(R.drawable.icon_true);
                                AnimationDrawable drawable1 = (AnimationDrawable)tvCaseA.getBackground();
                                drawable1.start();
                            }
                        },5000);
                        thirdFragment = new ThirdFragment();
                        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ThirdFragment.class.getName());
                        showThirdFragment();

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                i++;
                                init();
                                initQuestion();
                                j = 30;
                            }
                        },5000);
                    }else {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tvCaseA.setBackgroundResource(R.drawable.icon_false);
                                AnimationDrawable drawable2 = (AnimationDrawable)tvCaseA.getBackground();
                                drawable2.start();
                            }
                        },5000);
                    }
                }
                break;
            case R.id.tv_case_b:
                if(!isChoose){
                    isRunning = true;
                    isChoose = true;
                    tvCaseB.setBackgroundResource(R.drawable.icon_choose);
                    AnimationDrawable drawable = (AnimationDrawable)tvCaseB.getBackground();
                    drawable.start();
                    rlHelp.setClickable(false);
                    lnAnswer.setClickable(false);
                    int trueCase = managerQuestion.getQuestions().get(i).getTrueCase();
                    if(tvCaseB.getText().equals(managerQuestion.getQuestions().get(i).getCases().get(trueCase - 1))){
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tvCaseB.setBackgroundResource(R.drawable.icon_true);
                                AnimationDrawable drawable1 = (AnimationDrawable)tvCaseB.getBackground();
                                drawable1.start();
                            }
                        },5000);
                        thirdFragment = new ThirdFragment();
                        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ThirdFragment.class.getName());
                        showThirdFragment();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                i++;
                                init();
                                initQuestion();
                                j = 30;
                            }
                        },5000);
                    }else {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tvCaseB.setBackgroundResource(R.drawable.icon_false);
                                AnimationDrawable drawable2 = (AnimationDrawable)tvCaseB.getBackground();
                                drawable2.start();
                            }
                        },5000);
                    }
                }
                break;
            case R.id.tv_case_c:
                if(!isChoose){
                    isRunning = true;
                    isChoose = true;
                    tvCaseC.setBackgroundResource(R.drawable.icon_choose);
                    AnimationDrawable drawable = (AnimationDrawable)tvCaseC.getBackground();
                    drawable.start();
                    rlHelp.setClickable(false);
                    lnAnswer.setClickable(false);
                    int trueCase = managerQuestion.getQuestions().get(i).getTrueCase();
                    if(tvCaseC.getText().equals(managerQuestion.getQuestions().get(i).getCases().get(trueCase - 1))){
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tvCaseC.setBackgroundResource(R.drawable.icon_true);
                                AnimationDrawable drawable1 = (AnimationDrawable)tvCaseC.getBackground();
                                drawable1.start();
                            }
                        },5000);
                        thirdFragment = new ThirdFragment();
                        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ThirdFragment.class.getName());
                        showThirdFragment();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                i++;
                                init();
                                initQuestion();
                                j = 30;
                            }
                        },5000);
                    }else {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tvCaseC.setBackgroundResource(R.drawable.icon_false);
                                AnimationDrawable drawable2 = (AnimationDrawable)tvCaseC.getBackground();
                                drawable2.start();
                            }
                        },5000);
                    }
                }
                break;
            case R.id.tv_case_d:
                if(!isChoose){
                    isRunning = true;
                    isChoose = true;
                    tvCaseD.setBackgroundResource(R.drawable.icon_choose);
                    AnimationDrawable drawable = (AnimationDrawable)tvCaseD.getBackground();
                    drawable.start();
                    rlHelp.setClickable(false);
                    lnAnswer.setClickable(false);
                    int trueCase = managerQuestion.getQuestions().get(i).getTrueCase();
                    if(tvCaseD.getText().equals(managerQuestion.getQuestions().get(i).getCases().get(trueCase - 1))){
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tvCaseD.setBackgroundResource(R.drawable.icon_true);
                                AnimationDrawable drawable1 = (AnimationDrawable)tvCaseD.getBackground();
                                drawable1.start();
                            }
                        },5000);
                        thirdFragment = new ThirdFragment();
                        Fragment fragment = getSupportFragmentManager().findFragmentByTag(ThirdFragment.class.getName());
                        showThirdFragment();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                i++;
                                init();
                                initQuestion();
                                j = 30;
                            }
                        },5000);
                    }else {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tvCaseD.setBackgroundResource(R.drawable.icon_false);
                                AnimationDrawable drawable2 = (AnimationDrawable)tvCaseD.getBackground();
                                drawable2.start();
                            }
                        },5000);
                    }
                }
                break;
            case R.id.iv_call:
                if(!isChoose) {
                    CallDialog callDialog = new CallDialog(this);
                    callDialog.show();
                    ivCall.setBackgroundResource(R.drawable.x);
                    ivCall.setClickable(false);
                }
                break;
            case R.id.iv_hand:
               if(!isChoose){
                   StopDialog stopDialog = new StopDialog(this);
                   stopDialog.show();
               }
                break;
            case R.id.iv_help:
                if(!isChoose){
                    ivHelp.setBackgroundResource(R.drawable.x);
                    break;
                }
            case R.id.iv_percent50:
                if(!isChoose){

                    ivPercent50.setBackgroundResource(R.drawable.x);
                    break;
                }
            case R.id.iv_restart:
                if(!isChoose) {
                    ivRestart.setBackgroundResource(R.drawable.x);
                    break;
                }
        }
    }

    @Override
    protected void onDestroy() {
        managerQuestion.closeDatabase();
        super.onDestroy();
    }

    private void showThirdFragment(){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.open_enter, R.anim.open_exit, R.anim.close_enter, R.anim.open_exit)
                .replace(R.id.fr_content, thirdFragment, ThirdFragment.class.getName())
                .addToBackStack("third")
                .commit();
    }
}

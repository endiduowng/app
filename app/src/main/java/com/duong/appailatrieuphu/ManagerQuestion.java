package com.duong.appailatrieuphu;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nguyen Duong on 29/08/2016.
 */
public class ManagerQuestion {
    private static final String TAG = ManagerQuestion.class.getSimpleName();
    private static final String PATH_ALTP =
            Environment.getDataDirectory() +
                    File.separator + "data" + File.separator +
                    "com.duong.appailatrieuphu" + File.separator + "appailatrieuphu";
    private Context mContext;
    private static final String NAME_DATA = "Question";
    private List<Question> questions;
    private SQLiteDatabase mSqlite;

    public ManagerQuestion(Context context) {
        this.mContext = context;
        copyDatabase();
    }

    private void copyDatabase(){
        try{
            new File(PATH_ALTP).mkdir();
            File fileName = new File(PATH_ALTP + File.separator + NAME_DATA);
            if (fileName.exists()){
                return;
            }
            fileName.createNewFile();
            AssetManager manager = mContext.getAssets();
            InputStream in = manager.open("Question");
            OutputStream out = new FileOutputStream(fileName);
            byte b[] = new byte[1024];
            int lenght = in.read(b);
            while (lenght > 0){
                out.write(b, 0, lenght);
                lenght = in.read(b);
            }
            in.close();
            out.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void openDatabase(){
        if(mSqlite == null || mSqlite.isOpen() == false){
            mSqlite = SQLiteDatabase.openDatabase(PATH_ALTP + File.separator + NAME_DATA, null, SQLiteDatabase.OPEN_READWRITE);
            get15Questions();
        }
    }

    public void closeDatabase(){
        if (mSqlite != null){
            mSqlite.close();
            mSqlite = null;
        }
    }

    private List<Question> get15Questions(){
        questions = new ArrayList<>();
        openDatabase();
        String sqlQuerry15Question = "SELECT * FROM(SELECT * FROM Question ORDER BY random()) GROUP BY level ORDER BY level ASC limit 15";
        Cursor c = mSqlite.rawQuery(sqlQuerry15Question, null);
        if(c == null){
            return null;
        }
        c.moveToFirst();
        int indexCaseA = c.getColumnIndex("casea");
        int indexCaseB = c.getColumnIndex("caseb");
        int indexCaseC = c.getColumnIndex("casec");
        int indexCaseD = c.getColumnIndex("cased");
        int indexTrueCase = c.getColumnIndex("truecase");
        int indexQuestion = c.getColumnIndex("question");
        int indexLevel = c.getColumnIndex("level");
        while (!c.isLast()){
            String questionStr = c.getString(indexQuestion);
            String caseA = c.getString(indexCaseA);
            String caseB = c.getString(indexCaseB);
            String caseC = c.getString(indexCaseC);
            String caseD = c.getString(indexCaseD);
            int trueCase = c.getInt(indexTrueCase);
            int level = c.getInt(indexLevel);
            Question question = new Question(trueCase, level, caseA, caseB, caseC, caseD, questionStr );
            questions.add(question);
            c.moveToNext();
        }
        return questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}

package com.duong.appailatrieuphu;

/**
 * Created by Nguyen Duong on 11/09/2016.
 */
public class ItemHighScore {
    private String name;
    private String score;

    public ItemHighScore(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }
}

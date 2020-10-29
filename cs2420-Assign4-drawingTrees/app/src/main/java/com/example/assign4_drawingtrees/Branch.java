package com.example.assign4_drawingtrees;

import android.graphics.Color;

import java.util.HashMap;
import java.util.Random;

public class Branch {
    enum BranchType{
        TRUNK,
        STEM,
        BRANCH
    }
    public float      startX;
    public float      startY;
    public float      endX;
    public float      endY;
    public int        lineWidth;
    public int        color = Color.GREEN;
    public BranchType type;
    public Branch(float startX, float startY, float endX, float endY, HashMap<String, Integer> drawParams, BranchType type){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.type = type;
        setLineWidth(type, drawParams);
    }

    private void setLineWidth(BranchType type, HashMap<String, Integer> drawParams){
        if (type.equals(BranchType.BRANCH)){
            this.lineWidth = 30;
            this.color = Color.rgb(0,0,255);
            return;
        }
        if (type.equals(BranchType.STEM)){
            this.lineWidth = 50;
            this.color = Color.rgb(253,254,2);
            return;
        }
        if (type.equals(BranchType.TRUNK)){
            this.lineWidth = GenerateRandomNumber(drawParams.get("Min Trunk Width(50-1000)"), drawParams.get("Max Trunk Width(50-1000)"));
            this.color = Color.RED;
        }
    }

    private int GenerateRandomNumber(int low, int high){
        if (low == high){
            return low;
        }
        return new Random().nextInt(high - low) + low;
    }
}

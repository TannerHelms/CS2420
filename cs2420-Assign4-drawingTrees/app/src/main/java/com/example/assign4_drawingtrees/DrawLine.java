package com.example.assign4_drawingtrees;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class DrawLine extends Canvas {
    private Paint paint = new Paint();
    private Canvas canvas;
    int alterStem = 0;
    public void canvas(Canvas canvas){
        this.canvas = canvas;
    }

    public void Line(Branch branch){
        if (branch.type.compareTo(Branch.BranchType.STEM) == 0){
            if (alterStem == 0){
                color(Color.CYAN);
                alterStem = 1;
            } else {
                color(Color.RED);
                alterStem = 0;
            }

        }
        if (branch.type.compareTo(Branch.BranchType.BRANCH) == 0) {
            if (GenerateRandomNumber(0,2) == 0) {
                color(Color.BLUE);
            } else {
                color(Color.GREEN);
            }
        }
        if (branch.type.compareTo(Branch.BranchType.TRUNK) == 0){
            color(branch.color);
        }
        strokeWidth(branch.lineWidth);
        //color(branch.color);
        canvas.drawLine(branch.startX, branch.startY, branch.endX, branch.endY, paint);
    }

    private void strokeWidth(float width) {
        paint.setStrokeWidth(width);
    }

    private void color(int color){
        paint.setColor(color);
    }

    private int GenerateRandomNumber(int low, int high){
        if (low == high){
            return low;
        }
        return new Random().nextInt(high - low) + low;
    }
}

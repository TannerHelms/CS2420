package com.example.assign4_drawingtrees;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;

import androidx.annotation.RequiresApi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DrawingView extends View {
    HashMap<String, Integer> drawParams;
    DrawLine drawLine = new DrawLine();
    BinaryTree<Integer> binarySearchTree = new BinaryTree<>();
    int stemLength = 200;
    int branchLength = 200;
    int branchAngle = 89;
    int stemHeight;
    public String[] SectionHeaders = {"Min Tree Height(1-8)", "Max Tree Height(1-8)", "Min Trunk Width(50-1000)", "Max Trunk Width(50-1000)", "Min Number Of Branches(1-50)", "Max Number Of Branches(1-50)"};
    ArrayList<Integer> treeValues = new ArrayList<>();
    public DrawingView(Context context, HashMap<String, Integer> drawParams) {
        super(context);
        this.drawParams = drawParams;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.rgb(100,13,32));
        canvas.drawCircle(500,500,1500, paint);
        drawLine.canvas(canvas);
        buildTree();
        treeValues.forEach((node) -> {
            drawLine.Line(binarySearchTree.search(node));
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void buildTree(){
        treeValues.add(1);
        binarySearchTree.insert(1, new Branch((float)getWidth()/2, (float)getHeight(), (float)getWidth()/2, getHeight() - 200,
                drawParams, Branch.BranchType.TRUNK));
        buildStem();
        buildBranches();
    }
    private void buildStem(){
        int stemLength = GenerateRandomNumber(drawParams.get(SectionHeaders[0]), drawParams.get(SectionHeaders[1]));
        stemHeight = stemLength;
        for (int i = 1; i < stemLength + 1; i++) {
            Stem(binarySearchTree.search(i), i+1);
        }
    }
    private void buildBranches(){
        for (int i = 0; i < GenerateRandomNumber(drawParams.get(SectionHeaders[4]), drawParams.get(SectionHeaders[5])); i++) {
            int stem = GenerateRandomNumber(2, stemHeight + 1);
            int branchNumber = GenerateRandomNumber(0,2);
            if (branchNumber == 0) {
                branchNumber = GenerateRandomNumber(10, 100) * -1;
            } else {
                branchNumber = GenerateRandomNumber(10,100);
            }
            treeValues.add(branchNumber);
            binarySearchTree.insertOnStem(stem, branchNumber, branchLength, branchAngle, drawParams);
        }
    }
    private void Stem(Branch previous, int index){
        Branch tmpBranch = new Branch(previous.endX, previous.endY, previous.endX, previous.endY - stemLength, drawParams, Branch.BranchType.STEM);
        binarySearchTree.insertMiddle(index, tmpBranch);
        treeValues.add(index);
    }

    private int GenerateRandomNumber(int low, int high){
        if (low == high){
            return low;
        }
        return new Random().nextInt(high - low) + low;
    }
}

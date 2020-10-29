package com.example.assign4_drawingtrees;

import android.content.Context;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class GenerateUserSection extends LinearLayout{
    private HashMap<String,EditText> SectionContainer = new HashMap<>();
    private Button activityButton;
    public String[] SectionHeaders = {"Min Tree Height(1-8)", "Max Tree Height(1-8)", "Min Trunk Width(50-1000)", "Max Trunk Width(50-1000)", "Min Number Of Branches(1-50)", "Max Number Of Branches(1-50)"};
    public GenerateUserSection(Context context) {
        super(context);
        setOrientation(VERTICAL);
        for (String header: SectionHeaders){
            addView(new TextView(this.getContext(), header + ":"));
            EditText tmpEditText = new EditText(this.getContext());
            addView(tmpEditText);
            SectionContainer.put(header, tmpEditText);
        }
        Button autoButton = new Button(this.getContext(), "Auto Generate Values");
        addView(autoButton);
        autoButton.setOnClickListener(view -> {
           String ran = String.valueOf(GenerateRandomNumber(1, 9));
           Objects.requireNonNull(SectionContainer.get(SectionHeaders[0])).setText(ran);
           ran = String.valueOf(GenerateRandomNumber(Integer.parseInt(ran), 9));
           SectionContainer.get(SectionHeaders[1]).setText(ran);
           ran = String.valueOf(GenerateRandomNumber(50, 1000));
           SectionContainer.get(SectionHeaders[2]).setText(ran);
           ran = String.valueOf(GenerateRandomNumber(Integer.parseInt(ran), 1000));
           SectionContainer.get(SectionHeaders[3]).setText(ran);
           ran = String.valueOf(GenerateRandomNumber(1, 50));
           SectionContainer.get(SectionHeaders[4]).setText(ran);
           ran = String.valueOf(GenerateRandomNumber(Integer.parseInt(ran), 50));
           SectionContainer.get(SectionHeaders[5]).setText(ran);
        });
        Button tmpButton = new Button(this.getContext(), "Generate Tree");
        addView(tmpButton);
        activityButton = tmpButton;
    }

    public Integer GetEditText(String name){
        try {
            String tmpValue = SectionContainer.get(name).getText().toString();
            return Integer.parseInt(tmpValue);
        } catch (Exception e){
            System.out.println("error getting EditText from GenerateUserSection");
            System.out.println(e);
        }
        return 0;
    }

    public Button getButton(){
        return activityButton;
    }
    private int GenerateRandomNumber(int low, int high){
        if (low == high){
            return low;
        }
        return new Random().nextInt(high - low) + low;
    }
}

class TextView extends AppCompatTextView {
    public TextView(Context context, String text) {
        super(context);
        setTextSize(25);
        setText(text);
    }
}

class EditText extends AppCompatEditText {
    // Create layout params for editText
    final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
    );
    public EditText(Context context) {
        super(context);
        setLayoutParams(params);
    }
}

class Button extends AppCompatButton{
    public Button(Context context, String text) {
        super(context);
        setText(text);
    }

}

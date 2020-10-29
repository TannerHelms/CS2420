package com.example.assign3_calculator;

public class ButtonData {

    public enum buttonType {
        BUTTON,
        TEXTVIEW,
    }
    private String buttonText;
    private int column;
    private int row;
    private int size;
    private int color;
    private buttonType type;
    public ButtonData(String text, int column, int row, int size, int color) {
        this.buttonText = text;
        this.column = column;
        this.row = row;
        this.size = size;
        this.color = color;
        this.type = buttonType.BUTTON;
    }
    public ButtonData(String text, int column, int row, int size, int color, buttonType val){
        this.buttonText = text;
        this.column = column;
        this.row = row;
        this.size = size;
        this.type = val;
        this.color = color;
    }

    public String getButtonText() {
        return buttonText;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getSize() {
        return size;
    }

    public buttonType getType() {
        return type;
    }

    public int getColor() {
        return color;
    }

}

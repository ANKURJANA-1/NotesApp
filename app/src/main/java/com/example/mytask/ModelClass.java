package com.example.mytask;

public class ModelClass {

    private String tile;
    private String text;

    public ModelClass(String tile, String text) {
        this.tile = tile;
        this.text = text;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

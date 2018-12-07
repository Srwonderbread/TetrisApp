package com.tetris.git.tetrisapp;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {

    private List<ImageView> blocks;

    public Shape() {
    }

    public Shape(ImageView block){
        blocks = new ArrayList<>();
        blocks.add(block);
    }

    public Shape(List<ImageView> blocks) {
        this.blocks = blocks;
    }

    public List<ImageView> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<ImageView> blocks) {
        this.blocks = blocks;
    }
}

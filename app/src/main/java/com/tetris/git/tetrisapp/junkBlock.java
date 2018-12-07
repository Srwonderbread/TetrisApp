package com.tetris.git.tetrisapp;

import android.widget.ImageView;

import java.util.List;

public class junkBlock extends Shape {

    public junkBlock(ImageView block){
        super (block);
    }

    public junkBlock(List<ImageView> blocks){
        super (blocks);
    }
}

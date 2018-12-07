package com.tetris.git.tetrisapp;

import android.widget.ImageView;

import java.util.List;

public class lineBlock extends Shape {

    public lineBlock(ImageView block){
        super (block);
    }

    public lineBlock(List<ImageView> blocks){
        super (blocks);
    }

}

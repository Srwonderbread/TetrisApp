package com.tetris.git.tetrisapp;

import android.widget.ImageView;

import java.util.List;

public class squareBlock extends Shape {

    public squareBlock() {
        super();
    }

    public squareBlock(ImageView block) {
        super(block);
    }

    public squareBlock(List<ImageView> blocks) {
        super(blocks);
    }


}

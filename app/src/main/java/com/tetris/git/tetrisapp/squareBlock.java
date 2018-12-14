package com.tetris.git.tetrisapp;

import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

class squareBlock extends Shape {

    private FragmentActivity fragment;
    private FrameLayout frameLayout;
    private int blockColor;

    squareBlock(FrameLayout frameLayout, FragmentActivity fragment, int blockColor){
        this.fragment = fragment;
        this.frameLayout = frameLayout;
        this.blockColor = blockColor;
        createSquare();
    }

    private void createSquare() {
        for (int i = 0; i < 4; i++){
            Block block;
            switch (i) {
                case 0:
                    block = new Block(fragment, frameLayout);

                    block.image.setBackgroundResource(blockColor);
                    block.image.setX(275f);
                    block.image.setY(25f);
                    block.image.setMaxHeight(25);
                    block.image.setMaxWidth(25);
                    block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                    block.frameLayout.addView(block.image);
                    blocks.add(block.image);

                case 1:
                    block = new Block(fragment, frameLayout);

                    block.image.setBackgroundResource(blockColor);
                    block.image.setX(300f);
                    block.image.setY(25f);
                    block.image.setMaxHeight(25);
                    block.image.setMaxWidth(25);
                    block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                    block.frameLayout.addView(block.image);
                    blocks.add(block.image);

                case 2:
                    block = new Block(fragment, frameLayout);

                    block.image.setBackgroundResource(blockColor);
                    block.image.setX(300f);
                    block.image.setY(50f);
                    block.image.setMaxHeight(25);
                    block.image.setMaxWidth(25);
                    block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                    block.frameLayout.addView(block.image);
                    blocks.add(block.image);

                case 3:
                    block = new Block(fragment, frameLayout);

                    block.image.setBackgroundResource(blockColor);
                    block.image.setX(275f);
                    block.image.setY(50f);
                    block.image.setMaxHeight(25);
                    block.image.setMaxWidth(25);
                    block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                    block.frameLayout.addView(block.image);
                    blocks.add(block.image);
            }
        }
    }
}


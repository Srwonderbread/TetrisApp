package com.tetris.git.tetrisapp;

import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.FrameLayout;

class L extends Shape {

    private FragmentActivity fragment;
    private FrameLayout frameLayout;
    private ViewManager viewManager;
    private int blockColor;

    L(FrameLayout frameLayout, FragmentActivity fragment, int blockColor, ViewManager viewManager){

        this.fragment = fragment;
        this.frameLayout = frameLayout;
        this.blockColor = blockColor;
        this.viewManager = viewManager;
        createL();
    }

    private void createL(){
        for (int i =0; i < 4; i++){
            switch (i){
                case 0:
                    Block block = new Block(fragment, frameLayout);

                    block.image.setBackgroundResource(blockColor);
                    block.image.setX(275f);
                    block.image.setY(25f);
                    block.image.setMaxHeight(25);
                    block.image.setMaxWidth(25);
                    viewManager.addView(block.image, new ViewGroup.LayoutParams(25, 25));
                    blocks.add(block.image);
                    break;
                case 1:
                    block = new Block(fragment, frameLayout);

                    block.image.setBackgroundResource(blockColor);
                    block.image.setX(275f);
                    block.image.setY(50f);
                    block.image.setMaxHeight(25);
                    block.image.setMaxWidth(25);
                    viewManager.addView(block.image, new ViewGroup.LayoutParams(25, 25));
                    blocks.add(block.image);
                    break;
                case 2:
                    block = new Block(fragment, frameLayout);

                    block.image.setBackgroundResource(blockColor);
                    block.image.setX(300f);
                    block.image.setY(25f);
                    block.image.setMaxHeight(25);
                    block.image.setMaxWidth(25);
                    viewManager.addView(block.image, new ViewGroup.LayoutParams(25, 25));
                    blocks.add(block.image);
                    break;
                case 3:
                    block = new Block(fragment, frameLayout);

                    block.image.setBackgroundResource(blockColor);
                    block.image.setX(325f);
                    block.image.setY(25f);
                    block.image.setMaxHeight(25);
                    block.image.setMaxWidth(25);
                    viewManager.addView(block.image, new ViewGroup.LayoutParams(25, 25));
                    blocks.add(block.image);
                    break;
            }
        }
    }
}

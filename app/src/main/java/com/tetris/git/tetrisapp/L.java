package com.tetris.git.tetrisapp;

import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.List;

public class L extends Shape {

    private FragmentActivity fragment;
    private FrameLayout frameLayout;
    private Block block;
    private int blockColor;

    public L() {
        super();
    }

    public L(ImageView block){
        super (block);
    }

    public L(FrameLayout frameLayout, FragmentActivity fragment, int blockColor){
        this.fragment = fragment;
        this.frameLayout = frameLayout;
        this.blockColor = blockColor;
        createL();
    }

    public L(List<ImageView> blocks){
        super (blocks);
    }

    public void createL(){
        for (int i =0; i < 4; i++){
            switch (i){
                case 0:
                    block = new Block(fragment, frameLayout);

                    block.image.setBackgroundResource(blockColor);
                    block.image.setX(288.5f);
                    block.image.setY(10f);
                    block.image.setMaxHeight(25);
                    block.image.setMaxWidth(25);
                    block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                    block.frameLayout.addView(block.image);
                    blocks.add(block.image);
                    break;
                case 1:
                    block = new Block(fragment, frameLayout);

                    block.image.setBackgroundResource(blockColor);
                    block.image.setX(288.5f);
                    block.image.setY(35f);
                    block.image.setMaxHeight(25);
                    block.image.setMaxWidth(25);
                    block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                    block.frameLayout.addView(block.image);
                    blocks.add(block.image);
                    break;
                case 2:
                    block = new Block(fragment, frameLayout);

                    block.image.setBackgroundResource(blockColor);
                    block.image.setX(313.5f);
                    block.image.setY(10f);
                    block.image.setMaxHeight(25);
                    block.image.setMaxWidth(25);
                    block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                    block.frameLayout.addView(block.image);
                    blocks.add(block.image);
                    break;
                case 3:
                    block = new Block(fragment, frameLayout);

                    block.image.setBackgroundResource(blockColor);
                    block.image.setX(338.5f);
                    block.image.setY(10f);
                    block.image.setMaxHeight(25);
                    block.image.setMaxWidth(25);
                    block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                    block.frameLayout.addView(block.image);
                    blocks.add(block.image);
                    break;
            }
        }
    }
}

package com.tetris.git.tetrisapp;

import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.List;

public class squareBlock extends Shape {

    private FragmentActivity fragment;
    private FrameLayout frameLayout;
    private Block block;
    private int blockColor;

    public squareBlock() {
        super();
    }

    public squareBlock(ImageView block) {
        super(block);
    }

    public squareBlock(FrameLayout frameLayout, FragmentActivity fragment, int blockColor){
        this.fragment = fragment;
        this.frameLayout = frameLayout;
        this.blockColor = blockColor;
        createSquare();
    }

    public squareBlock(List<ImageView> blocks) {
        super(blocks);
    }

    public void createSquare() {
        for (int i = 0; i < 4; i++){
            if (i == 0){
                block = new Block(fragment, frameLayout);

                block.image.setBackgroundResource(blockColor);
                block.image.setX(288.5f);
                block.image.setY(10f);
                block.image.setMaxHeight(25);
                block.image.setMaxWidth(25);
                block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                block.frameLayout.addView(block.image);
                blocks.add(block.image);
            }
            else if (i == 1){
                block = new Block(fragment, frameLayout);

                block.image.setBackgroundResource(blockColor);
                block.image.setX(313.5f);
                block.image.setY(10f);
                block.image.setMaxHeight(25);
                block.image.setMaxWidth(25);
                block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                block.frameLayout.addView(block.image);
                blocks.add(block.image);
            }
            else if (i == 2){
                block = new Block(fragment, frameLayout);

                block.image.setBackgroundResource(blockColor);
                block.image.setX(313.5f);
                block.image.setY(35f);
                block.image.setMaxHeight(25);
                block.image.setMaxWidth(25);
                block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                block.frameLayout.addView(block.image);
                blocks.add(block.image);
            }
            else if (i == 3){
                block = new Block(fragment, frameLayout);

                block.image.setBackgroundResource(blockColor);
                block.image.setX(288.5f);
                block.image.setY(35f);
                block.image.setMaxHeight(25);
                block.image.setMaxWidth(25);
                block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                block.frameLayout.addView(block.image);
                blocks.add(block.image);
            }
        }

    }
}


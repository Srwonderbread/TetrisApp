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
        List<ImageView> list = createSquare();


    }


    public squareBlock(List<ImageView> blocks) {
        super(blocks);
    }

    public List<ImageView> createSquare() {
        for (int i = 0; i < 4; i++){
            if (i == 0){
                block = new Block(fragment, frameLayout, Shapes.square);

                block.image.setBackgroundResource(blockColor);
                block.image.setX(275f);
                block.image.setY(25f);
                block.image.setMaxHeight(25);
                block.image.setMaxWidth(25);
                block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                block.frameLayout.addView(block.image);
                blocks.add(block.image);
            }
            else if (i == 1){
                block = new Block(fragment, frameLayout, Shapes.square);

                block.image.setBackgroundResource(blockColor);
                block.image.setX(300f);
                block.image.setY(25f);
                block.image.setMaxHeight(25);
                block.image.setMaxWidth(25);
                block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                block.frameLayout.addView(block.image);
                blocks.add(block.image);
            }
            else if (i == 2){
                block = new Block(fragment, frameLayout, Shapes.square);

                block.image.setBackgroundResource(blockColor);
                block.image.setX(300f);
                block.image.setY(50f);
                block.image.setMaxHeight(25);
                block.image.setMaxWidth(25);
                block.image.setLayoutParams(new ViewGroup.LayoutParams(25, 25));
                block.frameLayout.addView(block.image);
                blocks.add(block.image);
            }
            else if (i == 3){
                block = new Block(fragment, frameLayout, Shapes.square);

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
        return blocks;
    }
}


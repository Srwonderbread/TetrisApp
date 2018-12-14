package com.tetris.git.tetrisapp;

import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Shape {

    //TODO: Make color a specific data piece of Shape.
    private Color color;
    protected Shapes shape;
    protected float centerX;
    protected float centerY;

    private int blockColor;

    private FragmentActivity fragment;
    private FrameLayout frameLayout;

    List<ImageView> blocks;

    Shape() {
        blocks = new ArrayList<>();
    }

    public Shape(FragmentActivity fragment, FrameLayout frameLayout, Shapes shape, Color color) {
        this.fragment = fragment;
        this.frameLayout = frameLayout;
        this.shape = shape;
        this.color = color;

        blocks = new ArrayList<>();
        setUpColor();
        createBlockShape();
    }

    public List<ImageView> getBlocks() {
        return blocks;
    }

    private void setBlocks(List<ImageView> blocks) {
        this.blocks = blocks;
    }

    private void createBlockShape(){
        switch(shape){
            case square:
                squareBlock squareBlock = new squareBlock(frameLayout, fragment, blockColor);
                setBlocks(squareBlock.blocks);
                centerX = 287.5f;
                centerY = 37.5f;
                break;
            case L:
                L LBlock = new L(frameLayout, fragment, blockColor);
                setBlocks(LBlock.blocks);
                centerX = 275f;
                centerY = 25f;

                //centerX = 287.5f;
                //centerY = 37.5f;
                break;
            case junk:
                junkBlock junkBlock = new junkBlock(frameLayout, fragment, blockColor);
                setBlocks(junkBlock.blocks);
                centerX = 275f;
                centerY = 50f;

                //centerX = 287.5f;
                //centerY = 50f;
                break;
            case line:
                lineBlock lineBlock = new lineBlock(frameLayout, fragment, blockColor);
                setBlocks(lineBlock.blocks);
                centerX = 275f;
                centerY = 50f;
                //centerX = 275f;
                //centerY = 62.5f;
                break;
        }
    }

    private void setUpColor(){
            switch(color){
                case blue:
                    blockColor = R.drawable.block_blue;
                    break;
                case lightBlue:
                    blockColor = R.drawable.block_light_blue;
                    break;
                case green:
                    blockColor = R.drawable.block_green;
                    break;
                case grey:
                    blockColor = R.drawable.block_grey;
                    break;
                case pink:
                    blockColor = R.drawable.block_pink;
                    break;
                case orange:
                    blockColor = R.drawable.block_orange;
                    break;
                case red:
                    blockColor = R.drawable.block_red;
                    break;
                case yellow:
                    blockColor = R.drawable.block_yellow;
                    break;
            }
    }
}

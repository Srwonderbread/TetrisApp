package com.tetris.git.tetrisapp;

import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {

    //TODO: Make color a specific data piece of Shape.
    private Color color;
    private Shapes shape;

    private int blockColor;

    private FragmentActivity fragment;
    private FrameLayout frameLayout;

    protected List<ImageView> blocks;

    public Shape() {
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

    public Shape(FragmentActivity fragment, FrameLayout frameLayout, List<ImageView> blocks) {
        this.fragment = fragment;
        this.frameLayout = frameLayout;
        this.blocks = blocks;
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

    private void createBlockShape(){
        switch(shape){
            case square:
                squareBlock squareBlock = new squareBlock(frameLayout, fragment, blockColor);
                break;
            case L:
                L LBlock = new L(frameLayout, fragment, blockColor);
                break;
            case junk:
                junkBlock junkBlock = new junkBlock(frameLayout, fragment, blockColor);
                break;
            case line:
                lineBlock lineBlock = new lineBlock(frameLayout, fragment, blockColor);
                break;
        }
    }

    public void setUpColor(){
            switch(color){
                case blue:
                    blockColor = R.drawable.block_blue;
                    break;
                case lightBlue:
                    blockColor = R.drawable.block_lightblue;
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
                    blockColor = R.drawable.block_yelow;
                    break;
            }
    }
}

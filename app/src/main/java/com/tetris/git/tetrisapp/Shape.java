package com.tetris.git.tetrisapp;

import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public abstract class Shape {

    //TODO: Make color a specific data piece of Shape.
    private Color color;
    protected Shapes shape;
    protected float centerX;
    protected float centerY;

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
                setBlocks(squareBlock.blocks);
                centerX = 287.5f;
                centerY = 37.5f;
                break;
            case L:
                L LBlock = new L(frameLayout, fragment, blockColor);
                setBlocks(LBlock.blocks);
                centerX = 287.5f;
                centerY = 37.5f;
                break;
            case junk:
                junkBlock junkBlock = new junkBlock(frameLayout, fragment, blockColor);
                setBlocks(junkBlock.blocks);
                centerX = 287.5f;
                centerY = 50f;
                break;
            case line:
                lineBlock lineBlock = new lineBlock(frameLayout, fragment, blockColor);
                setBlocks(lineBlock.blocks);
                centerX = 275f;
                centerY = 62.5f;
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

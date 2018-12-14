package com.tetris.git.tetrisapp;

import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Block {
    protected FrameLayout frameLayout;

    protected ImageView image;

    Block(FragmentActivity fragment, FrameLayout frameLayout) {
        this.frameLayout = frameLayout;
        image = new ImageView(fragment);
    }

    public ImageView getImage() {
        return image;
    }
}


package com.tetris.git.tetrisapp;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Block {
    private FragmentActivity fragment;
    protected FrameLayout frameLayout;

    protected Shapes whatShape;

    protected ImageView image;

    public Block(FragmentActivity fragment, FrameLayout frameLayout, Shapes shape) {
            this.fragment = fragment;
            this.frameLayout = frameLayout;
            this.whatShape = shape;
            image = new ImageView(fragment);
    }

    public ImageView getImage() {
        return image;
    }
}


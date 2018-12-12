package com.tetris.git.tetrisapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class gameInstance extends Fragment {

    //List
    private Shape activeBlocks;
    private List<Shape> inactiveBlocks;

    //Shape Creation
    private ImageView blueBlock;
    private ImageView lightBlueBlock;
    private ImageView greenBlock;
    private ImageView pinkBlock;
    private ImageView orangeBlock;
    private ImageView redBlock;
    private ImageView yellowBlock;
    private ImageView greyBlock;

    //Button Controls
    private ImageButton left;
    private ImageButton right;
    private ImageButton down;
    private ImageButton rotate;

    //Game Running
    private boolean active;

    //Layout
    private FrameLayout frameLayout;

    //Dynamic Color
    private Color color;

    //Dynamic Shape
    private Shapes shape;

    //Test
    private Block block;
    private Block block1;

    private FragmentActivity fragmentActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        color = makeBlockColor();
        shape = makeShape();
        active = true;
        fragmentActivity = getActivity();

        inactiveBlocks = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View gameInstance = inflater.inflate(R.layout.fragment_game_instance, container, false);


        blueBlock = gameInstance.findViewById(R.id.blueBlock);
        lightBlueBlock = gameInstance.findViewById(R.id.lightBlue);
        greenBlock = gameInstance.findViewById(R.id.greenBlock);
        greyBlock = gameInstance.findViewById(R.id.greyBlock);
        pinkBlock = gameInstance.findViewById(R.id.pinkBlock);
        orangeBlock = gameInstance.findViewById(R.id.orangeBlock);
        redBlock = gameInstance.findViewById(R.id.redBlock);
        yellowBlock = gameInstance.findViewById(R.id.yellowBlock);


        left = gameInstance.findViewById(R.id.leftButton);
        right = gameInstance.findViewById(R.id.rightButton);
        down = gameInstance.findViewById(R.id.downButton);
        rotate = gameInstance.findViewById(R.id.rotateButton);

        startBlock(blueBlock);
        startBlock(lightBlueBlock);
        startBlock(greenBlock);
        startBlock(greyBlock);
        startBlock(pinkBlock);
        startBlock(orangeBlock);
        startBlock(redBlock);
        startBlock(yellowBlock);


        frameLayout = gameInstance.findViewById(R.id.frameLayout);


        activeBlocks = new Shape(fragmentActivity, frameLayout, makeShape(), makeBlockColor()) {
            @Override
            public List<ImageView> getBlocks() {
                return super.getBlocks();
            }
        };

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 4; i++) {
                    activeBlocks.getBlocks().get(i).setX(activeBlocks.getBlocks().get(i).getX() - 25f);
                }
                activeBlocks.centerX = activeBlocks.centerX - 25f;
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 4; i++) {
                    activeBlocks.getBlocks().get(i).setX(activeBlocks.getBlocks().get(i).getX() + 25f);
                }
                activeBlocks.centerX = activeBlocks.centerX + 25f;
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 4; i++) {
                    activeBlocks.getBlocks().get(i).setY(activeBlocks.getBlocks().get(i).getY() + 15f);
                }
                activeBlocks.centerY = activeBlocks.centerY + 15f;
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotate();
            }
        });

        return gameInstance;
    }

    private void startBlock(ImageView view){
        view.setX(-80);
        view.setY(-80);
        view.setVisibility(View.INVISIBLE);
    }

    private Shapes makeShape(){
        int random = Math.abs(new Random().nextInt());
        int colorIndex = random%4;

        switch(colorIndex){
            case 0:
                return Shapes.square;
            case 1:
                return Shapes.L;
            case 2:
                return Shapes.junk;
            case 3:
                return Shapes.line;
        }
        return null;
    }

    private Color makeBlockColor(){
        int random = Math.abs(new Random().nextInt());
        int colorIndex = random%8;

        switch(colorIndex){
            case 0:
                return Color.blue;
            case 1:
                return Color.green;
            case 2:
                return Color.grey;
            case 3:
                return Color.lightBlue;
            case 4:
                return Color.orange;
            case 5:
                return Color.pink;
            case 6:
                return Color.red;
            case 7:
                return Color.yellow;
        }
        return Color.blue;
    }

    public void rotate(){
        float newX;
        float newY;
        float originX = activeBlocks.centerX;
        float originY = activeBlocks.centerY;
        float x;
        float y;
        float relativeX;
        float relativeY;
        for (int i = 0; i < 4; i++) {
            x = activeBlocks.getBlocks().get(i).getX();
            y = activeBlocks.getBlocks().get(i).getY();

            relativeX = x - originX;
            relativeY = y - originY;

            relativeY *= -1;

            newX = relativeX * (float) cos(PI/2) - relativeY * (float) sin(PI/2);
            newY = relativeX * (float) sin(PI/2) + relativeY * (float) cos(PI/2);

            newY *= -1;

            newX += originX;
            newY += originY;

            activeBlocks.getBlocks().get(i).setX(newX);
            activeBlocks.getBlocks().get(i).setY(newY);

        }
    }

    private void advance(){
        while(active){
            if(activeBlocks == null){
                activeBlocks = new Shape(getActivity(), frameLayout, makeShape(), makeBlockColor()) {
                    @Override
                    public List<ImageView> getBlocks() {
                        return super.getBlocks();
                    }
                };
            }
        }
    }


}

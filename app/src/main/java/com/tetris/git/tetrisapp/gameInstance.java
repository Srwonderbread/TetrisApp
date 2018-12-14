package com.tetris.git.tetrisapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class gameInstance extends Fragment {

    //List
    private Shape activeBlocks;

    private FrameLayout frameLayout;

    //Use when starting to make gravity
    protected List<ImageView> inactiveBlocks;

    //Passed to the Block class so that it knows where to create the individual blocks.
    private FragmentActivity fragmentActivity;

    private ImageView left;
    private ImageView right;
    private ImageView down;
    private ImageView rotate;

    private View gameInstance;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragmentActivity = getActivity();

        inactiveBlocks = new ArrayList<>();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        gameInstance = inflater.inflate(R.layout.fragment_game_instance, container, false);


        ImageView blueBlock = gameInstance.findViewById(R.id.blueBlock);
        ImageView lightBlueBlock = gameInstance.findViewById(R.id.lightBlue);
        ImageView greenBlock = gameInstance.findViewById(R.id.greenBlock);
        ImageView greyBlock = gameInstance.findViewById(R.id.greyBlock);
        ImageView pinkBlock = gameInstance.findViewById(R.id.pinkBlock);
        ImageView orangeBlock = gameInstance.findViewById(R.id.orangeBlock);
        ImageView redBlock = gameInstance.findViewById(R.id.redBlock);
        ImageView yellowBlock = gameInstance.findViewById(R.id.yellowBlock);


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

        return gameInstance;
    }

    private void makeActiveBlocks(){
        frameLayout = gameInstance.findViewById(R.id.blockLayout);
        activeBlocks = new Shape(fragmentActivity, frameLayout, makeShape(), makeBlockColor());
        timer = new Timer();
        timer.schedule(new Gravity(), 5000, 1000);
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
        List<Float> rotationXSafety = new ArrayList<>();
        List<Float> rotationYSafety = new ArrayList<>();
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

            rotationXSafety.add(newX);
            rotationYSafety.add(newY);

        }
        boolean isInBoundsX = true;
        boolean isInBoundsY = true;
        for (int i = 0; i < 4; i++){
            if (rotationXSafety.get(i) < 100 || rotationXSafety.get(i) >= 500){
                isInBoundsX = false;
            }
        }
        for (int i = 0; i < 4; i++){
            if (rotationYSafety.get(i) < 0 || rotationYSafety.get(i) >= 835){
                isInBoundsY = false;
            }
        }
        if (isInBoundsX && isInBoundsY){
            for (int i = 0; i < 4; i++){
                activeBlocks.getBlocks().get(i).setX(rotationXSafety.get(i));
                activeBlocks.getBlocks().get(i).setY(rotationYSafety.get(i));
            }
        }

    }

    public boolean checkLeft(){
        //float check = 0;
        for (int i = 0; i < 4; i++) {
            //check = activeBlocks.getBlocks().get(i).getX();
            if (activeBlocks.getBlocks().get(i).getX() <= 100){
                return false;
            }
        }
        return true;
    }

    public boolean checkRight(){
        //float check;
        for (int i = 0; i < 4; i++) {
            //check = activeBlocks.getBlocks().get(i).getX();
            if (activeBlocks.getBlocks().get(i).getX() >= 475){
                return false;
            }
        }
        return true;
    }
    public boolean checkBottom(){
        for (int i = 0; i < 4; i++){
            if (activeBlocks.getBlocks().get(i).getY() >= 850){
                return false;
            }
        }
        return true;
    }

    public boolean checkLOrLine(){
        boolean blockCheck;
        List<Shapes> blockCheckList = new ArrayList<>();
        //float check;
        if (activeBlocks.shape == Shapes.line || activeBlocks.shape == Shapes.L) {
            for (int i = 0; i < 4; i++) {
                //check = activeBlocks.getBlocks().get(i).getX();
                if (activeBlocks.getBlocks().get(i).getX() >= 475) {
                    blockCheckList.add(Shapes.line);
                }
                else if (activeBlocks.getBlocks().get(i).getX() <= 100) {
                    blockCheckList.add(Shapes.L);
                }
            }
            blockCheck = blockCheckList.size() >= 3;
            return blockCheck;
        }
        return true;
    }

    private boolean run = true;
    private Timer timer;

    private void createView(){
        fragmentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                makeActiveBlocks();

                left.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (checkLeft()) {
                            for (int i = 0; i < 4; i++) {
                                activeBlocks.getBlocks().get(i).setX(activeBlocks.getBlocks().get(i).getX() - 25f);
                            }
                            activeBlocks.centerX = activeBlocks.centerX - 25f;
                        }
                    }
                });

                right.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (checkRight()) {
                            for (int i = 0; i < 4; i++) {
                                activeBlocks.getBlocks().get(i).setX(activeBlocks.getBlocks().get(i).getX() + 25f);
                            }
                            activeBlocks.centerX = activeBlocks.centerX + 25f;
                        }
                    }
                });



                down.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (checkBottom()) {
                            for (int i = 0; i < 4; i++) {
                                activeBlocks.getBlocks().get(i).setY(activeBlocks.getBlocks().get(i).getY() + 15f);
                            }
                            activeBlocks.centerY = activeBlocks.centerY + 15f;
                        }
                    }
                });

                rotate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!checkLOrLine()) {
                            rotate();
                        } else if (checkLeft() && checkRight()) {
                            rotate();
                        }
                    }
                });
            }
        });
    }

    private class Gravity extends TimerTask {
        @Override
        public void run() {
            if (!checkBottom()) {
                inactiveBlocks.addAll(activeBlocks.blocks);
                makeActiveBlocks();
                run = false;
            }
            if (run) {
                for (ImageView view : activeBlocks.getBlocks()) {
                    view.setY(view.getY() + 15f);
                }
                activeBlocks.centerY = activeBlocks.centerY + 15f;
            }
            else{
                timer.cancel();
                timer.purge();
                run = true;
            }
        }
    }
}

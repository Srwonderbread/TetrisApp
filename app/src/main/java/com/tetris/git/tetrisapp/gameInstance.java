package com.tetris.git.tetrisapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class gameInstance extends Fragment {

    //List
    private List<Shape> activeBlocks;
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
    private Button left;
    private Button right;
    private Button down;
    private Button rotate;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activeBlocks = new ArrayList<>();
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

        Color color = makeBlockColor();

        switch(color){
            case blue:
                makeBlockShape(blueBlock);
                break;
            case lightBlue:
                makeBlockShape(lightBlueBlock);
                break;
            case green:
                makeBlockShape(greenBlock);
                break;
            case grey:
                makeBlockShape(greyBlock);
                break;
            case pink:
                makeBlockShape(pinkBlock);
                break;
            case orange:
                makeBlockShape(orangeBlock);
                break;
            case red:
                makeBlockShape(redBlock);
                break;
            case yellow:
                makeBlockShape(yellowBlock);
                break;
        }

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

    private void makeBlockShape(ImageView view) {
        Shapes shapes = makeShape();
        switch(shapes){
            case square:
                makeActiveBlockSquare(view);
                break;
            case L:
                makeActiveBlockL(view);
                break;
            case junk:
                makeActiveBlockJunk(view);
                break;
            case line:
                makeActiveBlockLine(view);
                break;
        }
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

    private void makeActiveBlockSquare(ImageView view){
        view.setX(288.5f);
        view.setY(10f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.add(new squareBlock(view));
    }

    private void makeActiveBlockL(ImageView view){
        view.setX(288.6f);
        view.setY(10f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.add(new L(view));
    }

    private void makeActiveBlockLine(ImageView view){
        view.setX(288.6f);
        view.setY(10f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.add(new lineBlock(view));
    }

    private void makeActiveBlockJunk(ImageView view){
        view.setX(288.6f);
        view.setY(10f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.add(new junkBlock(view));
    }


}

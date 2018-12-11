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
    private Shape shapeClass;
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

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 4; i++) {
                    shapeClass.blocks.get(i).setX(shapeClass.blocks.get(i).getX() - 20f);
                }
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 4; i++) {
                    shapeClass.blocks.get(i).setX(shapeClass.blocks.get(i).getX() + 20f);
                }
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 4; i++) {
                    shapeClass.blocks.get(i).setY(shapeClass.blocks.get(i).getY() + 20f);
                }
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 4; i++) {
                    //shapeClass.blocks.get(i).setX(shapeClass.blocks.get(i).getX() - 20f);
                }
            }
        });


        startBlock(blueBlock);
        startBlock(lightBlueBlock);
        startBlock(greenBlock);
        startBlock(greyBlock);
        startBlock(pinkBlock);
        startBlock(orangeBlock);
        startBlock(redBlock);
        startBlock(yellowBlock);


        frameLayout = gameInstance.findViewById(R.id.frameLayout);


        shapeClass = new Shape(fragmentActivity, frameLayout, makeShape(), makeBlockColor()) {
            @Override
            public List<ImageView> getBlocks() {
                return super.getBlocks();
            }
        };

        /*
        if(activeBlocks.blocks == null){
            shapeClass = new Shape(fragmentActivity, frameLayout, makeShape(), makeBlockColor()) {
                @Override
                public List<ImageView> getBlocks() {
                    return super.getBlocks();
                }
            };
        }
        */

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

    private void makeBlockShape() {
        Shapes shapes = makeShape();
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
        activeBlocks = new squareBlock();

        /*
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
        */

        view.setX(288.5f);
        view.setY(10f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);
    }

    private void makeActiveBlockL(ImageView view){
        activeBlocks = new L();

        view.setX(288.5f);
        view.setY(10f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);

        view.setX(288.5f);
        view.setY(35f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);

        view.setX(313.5f);
        view.setY(35f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);

        view.setX(388.5f);
        view.setY(10f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);

    }

    private void makeActiveBlockLine(ImageView view){
        activeBlocks = new lineBlock();

        view.setX(288.5f);
        view.setY(10f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);

        view.setX(288.5f);
        view.setY(35f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);

        view.setX(288.5f);
        view.setY(60f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);

        view.setX(288.5f);
        view.setY(85f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);
    }

    private void makeActiveBlockJunk(ImageView view){
        activeBlocks = new junkBlock();

        view.setX(288.5f);
        view.setY(10f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);

        view.setX(288.5f);
        view.setY(35f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);

        view.setX(313.5f);
        view.setY(35f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);

        view.setX(313.5f);
        view.setY(60f);
        view.setVisibility(View.VISIBLE);

        activeBlocks.getBlocks().add(view);
    }

    private void moveButtons(){


        for (ImageView view:activeBlocks.getBlocks()){
            view.setX(view.getX());
        }
    }

    private void advance(){
        while(active){
            if(activeBlocks == null){
                shapeClass = new Shape(getActivity(), frameLayout, makeShape(), makeBlockColor()) {
                    @Override
                    public List<ImageView> getBlocks() {
                        return super.getBlocks();
                    }
                };
            }
        }
    }


}

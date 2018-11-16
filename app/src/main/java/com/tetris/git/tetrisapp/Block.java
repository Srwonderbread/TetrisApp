package com.tetris.git.tetrisapp;

public class Block {

    float x;
    float y;
    Game game;
    Block block;

    public Block() {
    }

    public Game drawBlock()
    {
        return game;
    }

    public Boolean isNearOtherBlocks()
    {
        return false;
    }

    public Block connectBlocks()
    {
        return block;
    }

    public Boolean isMoving()
    {
        return false;
    }


}

package com.company;

import java.util.ArrayList;

public class BlockChain {

    private ArrayList<Block> blockchain;

    public BlockChain(){
        this.blockchain = new ArrayList<Block>();
    }

    public void addBlock (Block block){
        this.blockchain.add(block);
    }

    public ArrayList<Block> getBlockChain(){
        return this.blockchain;
    }

    public int size(){
        return this.blockchain.size();
    }

    public String toString(){
        String bk = "";

        for (Block block : this.blockchain){
            bk += block.toString() + "\n";
        }
        return bk;
    }
}
package com.company;

public class Miner {

    private double reward;
    private int difficulty;

    public Miner(){
        this.reward = Constants.REWARD;
        this.difficulty = Constants.DIFFICULTY;
    }

    public void mine(Block block, BlockChain bk){

        while (!getGoldenHash(block, bk)){
            // our Mined block will have the same timestamp as the first generated hash
            block.generateHash();
            block.incrementNonce();
        }

        System.out.println("Mined Hash is: " + block.getHash());

        bk.addBlock(block);

        reward += this.reward;

    }

    public boolean getGoldenHash(Block block, BlockChain bk){
        String leadingZeros =new String(new char[this.difficulty]).replace('\0', '0');
        return block.getHash().substring(0, difficulty).equals(leadingZeros);
    }


}
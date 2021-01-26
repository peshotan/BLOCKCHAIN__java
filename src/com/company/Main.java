package com.company;


import java.util.List;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        // System.out.println("The generate hash for the string is " + SHA256Helper.generateHash("asdfasdf"));

        // Block genesisBlock = new Block(2323423, "sample transactions", "00000000000000");
        // System.out.println(genesisBlock.toString());

        BlockChain bk = new BlockChain();
        Miner miner = new Miner();

        Block block = new Block(1, "transaction1", "0000000");
        miner.mine(block, bk);

        List<String> transactions = new ArrayList<>();
        transactions.add("aa");
        transactions.add("bb");
        transactions.add("dd");
        transactions.add("ee");
        transactions.add("11");
        transactions.add("22");
        transactions.add("33");
        transactions.add("44");
        transactions.add("55");

        MerkleTree mt = new MerkleTree(transactions);
        List<String> merkleRoot = mt.getMerkleRoot();
        System.out.println("The hash for merkle tree is: " + merkleRoot.get(0));
    }
}
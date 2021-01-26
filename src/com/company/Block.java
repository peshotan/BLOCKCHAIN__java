package com.company;

import java.util.Date;

public class Block {

    private int id;
    private int nonce;
    private long timeStamp;
    private String hash;
    private String previousHash;
    private String transactions;


    public Block (int id, String transactions, String previousHash) {
        this.id = id;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        generateHash();
    }

    public void generateHash(){
        String dataToString = Integer.toString(id) +
                Integer.toString(nonce) +
                Long.toString(timeStamp) +
                previousHash +
                transactions;

        String hashVal = SHA256Helper.generateHash(dataToString);
        this.hash = hashVal;
    }

    public void incrementNonce(){
        ++this.nonce;
    }

    public String getHash(){
        return this.hash;
    }

    public String getPreviousHash(){
        return this.previousHash;
    }

    public String toString(){
        return "***\n" + "Block Id: " + + this.id + "\n" + "Transactions: " + this.transactions + "\n" + "hash: " +  this.hash + "\n" + "previousHash: " + previousHash + "\n***\n";
    }


}

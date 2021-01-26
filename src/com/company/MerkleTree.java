package com.company;

import java.util.ArrayList;
import java.util.List;

class MerkleTree {

    private List<String> transactions;

    public MerkleTree(List<String> transactions) {
        this.transactions = transactions;
    }

    public List<String> constructMerkle (List<String> transactions) {
        // recursive function to construct merkle tree. First input is all the leaf nodes (real transactions)
        // each recursive call shortens the array and a parent is constructed from conmbining children

        // base case when only one transaction is left;
        if (transactions.size() == 1) return transactions;

        List<String> updatedList = new ArrayList<>();

        for (int i = 0;  i < transactions.size() - 1; i += 2) {
            updatedList.add(SHA256Helper.mergeHash(transactions.get(i), transactions.get(i+1)));
        }

        if (transactions.size() % 2 == 1){
            updatedList.add(SHA256Helper.mergeHash(transactions.get(transactions.size()-1), transactions.get(transactions.size()-1)));
        }

        return constructMerkle(updatedList);
    }

    public List<String> getMerkleRoot(){
        return this.constructMerkle(this.transactions);
    }

}
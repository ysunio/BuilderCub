package com.buildercub.scenarios;

import java.util.ArrayList;
import java.util.List;

public class BoardAutoComplete {


    public static void main(String[] args) {
        AutoComplete autoComplete = new AutoComplete();
        autoComplete.addBoard("Sunil", 99);
        autoComplete.addBoard("Alice", 34);
        autoComplete.addBoard("Bob", 66);
        autoComplete.addBoard("Sun", 101);
        autoComplete.addBoard("Aliceeeey", 88);
        autoComplete.addBoard("Babua", 120);
        System.out.println(autoComplete.searchWordsByPrefix("b", 5));
    }

    static class Node{
        boolean isWord;
        String boardName;
        int popularityScore;
        Node[] children = new Node[26];

        @Override
        public String toString(){
            return boardName;
        }
    }

    static class AutoComplete{

        Node root;
        AutoComplete(){
            this.root = new Node();
        }

        public void addBoard(String boardName, int popularityScore){
            boardName = boardName.toLowerCase();
            Node cNode = root;
            for(char ch : boardName.toCharArray()){
                if(cNode.children[ch - 'a'] == null) cNode.children[ch - 'a'] = new Node();
                cNode = cNode.children[ch - 'a'];
            }
            cNode.isWord = true;
            cNode.boardName = boardName;
            cNode.popularityScore = popularityScore;
        }

        public List<Node> searchWordsByPrefix(String wordPrefix, int topK){
            wordPrefix = wordPrefix.toLowerCase();

            Node cNode = root;
            for(char ch : wordPrefix.toCharArray()){
                if(cNode.children[ch - 'a'] == null) return new ArrayList<>();
                cNode = cNode.children[ch - 'a'];
            }

            List<Node> groupedNode = new ArrayList<>();
            getAllWords(cNode, groupedNode);
            groupedNode.sort((a, b) -> b.popularityScore - a.popularityScore);
            return groupedNode.subList(0, Math.min(groupedNode.size(), topK));
        }

        private void getAllWords(Node cNode, List<Node> groupedNode){
            if(cNode.isWord){
                groupedNode.add(cNode);
            }

            for(Node childNode : cNode.children){
                if(childNode == null) continue;
                getAllWords(childNode, groupedNode);
            }

        }

    }
}

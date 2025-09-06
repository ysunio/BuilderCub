package com.buildercub.scenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CardHeight {

    static class Card{
        int id;
        int height;

        public Card(int id, int height) {
            this.id = id;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "id=" + id +
                    ", height=" + height +
                    '}';
        }
    }

    static class Column{
        int totalHeight;
        List<Card> cards = new ArrayList<>();

        void addCard(Card card){
            cards.add(card);
            totalHeight += card.height;
        }

        @Override
        public String toString() {
            return "Column{" +
                    "totalHeight=" + totalHeight +
                    ", cards=" + cards +
                    '}';
        }
    }

    public static void main(String[] args) {
        ArrangeInSortedColumns arrangeInSortedColumns = new ArrangeInSortedColumns();
        List<Card> list = List.of(new Card(1, 2), new Card(2, 4), new Card(3, 1), new Card(4, 3), new Card(5, 3) , new Card(6, 3));
        System.out.println(arrangeInSortedColumns.arrangeCards(list, 2));
    }

    static class ArrangeInSortedColumns{

        List<Column> arrangeCards(List<Card> cards, int numOfColumns){
            if(numOfColumns == 0) return new ArrayList<>();

            // Descending Get Element with Lowest Height First
            PriorityQueue<Column> priorityQueue = new PriorityQueue<>((a, b) -> a.totalHeight - b.totalHeight);
            for(int idx = 0; idx < numOfColumns; idx++) priorityQueue.add(new Column());

            for(Card card : cards){
                Column lHeightColumn = priorityQueue.poll();
                lHeightColumn.addCard(card);
                priorityQueue.add(lHeightColumn);
            }

            return new ArrayList<>(priorityQueue);
        }


    }

}

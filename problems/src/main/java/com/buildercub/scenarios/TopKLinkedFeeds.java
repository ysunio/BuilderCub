package com.buildercub.scenarios;

import java.util.*;

public class TopKLinkedFeeds {

    static class FeedItem {
        int id;
        int likedCounter = 0;
        FeedItem(int id, int likedCounter){ this.id = id; this.likedCounter = likedCounter; }

        @Override
        public String toString() {
            return "Feed{" +
                    "id=" + id +
                    ", likedCounter=" + likedCounter +
                    '}';
        }
    }

    public static void main(String[] args) {
        final List<FeedItem> listOfFeedItems = new ArrayList<>();
        for(int idx = 0; idx < 25; idx++){
            listOfFeedItems.add(new FeedItem(idx, (int) (Math.random() * 100)));
        }

        System.out.println("TOP K LIST");
        List<FeedItem> topKFeedItems = getTopKFeeds(listOfFeedItems, 5);
        for(FeedItem feedItem : topKFeedItems){
            System.out.println(feedItem);
        }

        // Compare with Sort
        listOfFeedItems.sort((a, b) -> b.likedCounter - a.likedCounter);
        System.out.println("ALL SORTED LIST");
        for(FeedItem feedItem : listOfFeedItems){
            System.out.println(feedItem);
        }
    }

    private static List<FeedItem> getTopKFeeds(List<FeedItem> listOfAllFeedItems, int K){
        // MIN HEAP
        final PriorityQueue<FeedItem> priorityQueue = new PriorityQueue<>(K, (a, b) -> a.likedCounter - b.likedCounter);

        // O(N)
        for(FeedItem feedItem : listOfAllFeedItems){

            // O(Lg(K))
            priorityQueue.offer(feedItem);
            if(priorityQueue.size() >= K) priorityQueue.poll();
        }

        final List<FeedItem> es = new ArrayList<>();
        while(!priorityQueue.isEmpty()) es.add(priorityQueue.poll());
        return es.reversed();
    }

}

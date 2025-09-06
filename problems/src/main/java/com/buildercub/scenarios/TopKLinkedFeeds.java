package com.buildercub.scenarios;

import java.util.*;

// Batch Processing
public class TopKLinkedFeeds {

    static class FeedItem {
        int id;
        int likedCounter = 0;

        FeedItem(int id, int likedCounter) {
            this.id = id;
            this.likedCounter = likedCounter;
        }

        public void incLikedCounter() {
            this.likedCounter++;
        }

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
        for (int idx = 0; idx < 25; idx++) {
            listOfFeedItems.add(new FeedItem(idx, (int) (Math.random() * 100)));
        }

        System.out.println("TOP K LIST");
        List<FeedItem> topKFeedItems = getTopKFeeds(listOfFeedItems, 5);
        for (FeedItem feedItem : topKFeedItems) {
            System.out.println(feedItem);
        }

        // Compare with Sort
        listOfFeedItems.sort((a, b) -> b.likedCounter - a.likedCounter);
        System.out.println("ALL SORTED LIST");
        for (FeedItem feedItem : listOfFeedItems) {
            System.out.println(feedItem);
        }

        System.out.println("------------- Real Tracker ---------------");
        RealTracker realTracker = new RealTracker(2);
        System.out.println("Initial K Feeds");
        for (FeedItem feedItem : realTracker.getTopKFeeds()) {
            System.out.println(feedItem);
        }
        System.out.println("Initial END");
        System.out.println("Feed 3 Likes to 12");

        // 3 Likes to
        realTracker.likeItem(12);
        realTracker.likeItem(12);
        realTracker.likeItem(12);

        System.out.println("K Feeds");
        for (FeedItem feedItem : realTracker.getTopKFeeds()) {
            System.out.println(feedItem);
        }
        System.out.println("K Feed END");
        System.out.println("Feed 1 Likes to 13, 14, 15 each");

        realTracker.likeItem(13);
        realTracker.likeItem(14);
        realTracker.likeItem(15);

        System.out.println("K Feeds");
        for (FeedItem feedItem : realTracker.getTopKFeeds()) {
            System.out.println(feedItem);
        }
        System.out.println("K Feed END");
        System.out.println("Feed 5 Likes to 14, and 2 Likes to 15");
        realTracker.likeItem(14);
        realTracker.likeItem(14);
        realTracker.likeItem(14);
        realTracker.likeItem(14);
        realTracker.likeItem(14);
        realTracker.likeItem(15);
        realTracker.likeItem(15);

        System.out.println("K Feeds");
        for (FeedItem feedItem : realTracker.getTopKFeeds()) {
            System.out.println(feedItem);
        }
        System.out.println("K Feed END");
    }

    private static List<FeedItem> getTopKFeeds(List<FeedItem> listOfAllFeedItems, int K) {
        // MIN HEAP
        final PriorityQueue<FeedItem> priorityQueue = new PriorityQueue<>(K, (a, b) -> a.likedCounter - b.likedCounter);

        // O(N)
        for (FeedItem feedItem : listOfAllFeedItems) {

            // O(Lg(K))
            priorityQueue.offer(feedItem);
            if (priorityQueue.size() >= K) priorityQueue.poll();
        }

        final List<FeedItem> es = new ArrayList<>();
        while (!priorityQueue.isEmpty()) es.add(priorityQueue.poll());
        return es.reversed();
    }

    static class RealTracker {

        private Integer TOP_K = 5;
        private final Map<Integer, FeedItem> itemStore = new HashMap<>();
        private final PriorityQueue<FeedItem> priorityQueue = new PriorityQueue<>(TOP_K, (a, b) -> a.likedCounter - b.likedCounter);

        RealTracker(int TOP_K){
            this.TOP_K = TOP_K;
        }

        public void likeItem(int itemId) {
            if(itemStore.containsKey(itemId)){
                itemStore.get(itemId).incLikedCounter();
                rebuildHeap();
            }else{
                FeedItem feedItem = new FeedItem(itemId, 1);
                priorityQueue.add(feedItem);
                itemStore.put(itemId, feedItem);
            }

            if(priorityQueue.size() > TOP_K) priorityQueue.poll();
        }

        private void rebuildHeap(){
            priorityQueue.clear();

            for(Map.Entry<Integer, FeedItem> entry : itemStore.entrySet()){
                priorityQueue.add(new FeedItem(entry.getKey(), entry.getValue().likedCounter));
                if(priorityQueue.size() > TOP_K) priorityQueue.poll();
            }
        }

        List<FeedItem> getTopKFeeds() {
            return new ArrayList<>(priorityQueue).reversed();
        }

    }

}

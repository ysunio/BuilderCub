package com.buildercub.scenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchQuerySuggestion {

    static class QueryNode{
        String query;
        boolean isEnd;
        int frequency;
        QueryNode[] childrens = new QueryNode[26];

        public QueryNode(){}

        public QueryNode(String query) {
            this.query = query;
        }

        public void setAsEnd() {
            this.isEnd = true;
        }

        public void incFrequency(int frequency) {
            this.frequency += frequency;
        }
    }

    public static void main(String[] args) {
        SearchSuggestion searchSuggestion = new SearchSuggestion();
        searchSuggestion.addQuery("Sunil", 3);
        searchSuggestion.addQuery("Sunshine", 12);
        searchSuggestion.addQuery("Samsung", 6);
        searchSuggestion.addQuery("Sunday", 9);
        searchSuggestion.addQuery("Monday", 9);
        searchSuggestion.addQuery("Month", 12);

        System.out.println(searchSuggestion.getSuggestions("Su", 5));
    }

    static class SearchSuggestion{

        private final QueryNode trieRoot = new QueryNode("*");

        public void addQuery(String query, int freq){
            query = query.toLowerCase();

            QueryNode node = trieRoot;
            for(char ch: query.toCharArray()){
                if(node.childrens[ch - 'a'] == null) node.childrens[ch - 'a'] = new QueryNode();
                node = node.childrens[ch - 'a'];
            }

            node.query = query;
            node.incFrequency(freq);
            node.isEnd = true;
        }

        public List<String> getSuggestions(String prefix, int topK){
            prefix = prefix.toLowerCase();

            QueryNode node = trieRoot;
            for(char ch: prefix.toCharArray()){
                if(node.childrens[ch - 'a'] == null) node.childrens[ch - 'a'] = new QueryNode();
                node = node.childrens[ch - 'a'];
            }

            // Prefix Node -> Node
            List<QueryNode> endWords = new ArrayList<>();
            getAllWordsWithFrequency(node, endWords);

            endWords.sort((a, b) -> b.frequency - a.frequency);
            return endWords.subList(0, Math.min(endWords.size(), topK)).stream().map(it -> it.query).collect(Collectors.toList());
        }

        private void getAllWordsWithFrequency(QueryNode queryNode, List<QueryNode> words){
            if(queryNode.isEnd){
                words.add(queryNode);
            }

            for(QueryNode x : queryNode.childrens){
                if(x == null) continue;
                getAllWordsWithFrequency(x, words);
            }
        }

    }

}

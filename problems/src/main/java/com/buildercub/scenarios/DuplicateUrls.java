package com.buildercub.scenarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateUrls {

    public static void main(String[] args) {
        System.out.println(groupDuplicates(List.of(
                "https://www.amazon.com/store/", "http://www.amazon.com/store",
                "https://www.amazon.com/kindle/", "http://www.amazon.com/alexa",
                "http://amazon.com/store", "http://amazon.com/aws"
        )));
    }

    private static List<List<String>> groupDuplicates(List<String> urls){
        Map<String, List<String>> groupedUrl = new HashMap<>();

        for(String url : urls){
            groupedUrl.computeIfAbsent(getNormalizeUrl(url), K -> new ArrayList<>()).add(url);
        }

        return new ArrayList<>(groupedUrl.values());
    }

    private static String getNormalizeUrl(String url){
        url = url.trim();

       if(url.startsWith("https://")){
           url = url.substring(8);
       }else if(url.startsWith("http://")){
           url = url.substring(7);
       }

       if(url.startsWith("www.")){
           url = url.substring(4);
       }

        if(url.endsWith("/")){
            url = url.substring(0, url.length() - 1);
        }

       return url;
    }
}

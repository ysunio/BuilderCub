package Archieve.Leetcode;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mP = new HashMap<>();

        for(String str : strs){
            char[] rChar = str.toCharArray();
            Arrays.sort(rChar);
            String key = String.valueOf(rChar);

            if(!mP.containsKey(key)) mP.put(key, new ArrayList<>());
            mP.get(key).add(str);
        }

        return new ArrayList<>(mP.values());
    }
}

package Problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();

        for (String str : strs) {
            String sorted = getStr(str);
            if (hash.containsKey(sorted)) {
                hash.get(sorted).add(str);
            } else {
                hash.put(sorted, new ArrayList<>() {{
                    add(str);
                }});
            }
        }

        List<List<String>> r = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : hash.entrySet())
            r.add(entry.getValue());
        return r;
    }

    private static String getStr(String str) {
        int[] s = new int[26];
        for (char c : str.toCharArray()) s[c - 'a']++;
        StringBuilder strBuilder = new StringBuilder();
        for (int idx = 0; idx < 26; idx++) {
            int count = s[idx];
            for (int i = 0; i < count; i++) strBuilder.append((char) ('a' + idx));
        }
        return new String(strBuilder);
    }
}

package Archieve._75.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueOccurrence {
    public boolean uniqueOccurrences(int[] arr) {
        int[] occurrence = new int[(1001 * 2)];
        Set<Integer> uniqueOccurrence = new HashSet<>();
        for(int el : arr) if(el > 0) occurrence[el]++; else occurrence[1001 + el]++;
        for(int el : occurrence) if(el != 0){ if(uniqueOccurrence.contains(el)) return false; else uniqueOccurrence.add(el); }
        return true;
    }
}

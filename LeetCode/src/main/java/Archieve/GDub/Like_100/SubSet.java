package Archieve.GDub.Like_100;

import java.util.ArrayList;
import java.util.List;

// ["1", "2", "3"]

public class SubSet {

    List<List<Integer>> subSet(List<Integer> list){
        List<List<Integer>> rArray = new ArrayList<>();
        for(int idx = 0; idx < list.size(); idx++){
            solve(list, rArray, idx);
        }
        return rArray;
    }

    private void solve(List<Integer> list, List<List<Integer>> rArray, int idx){
        int currentElement = list.get(idx);
        System.out.println(currentElement);

        List<List<Integer>> lR = new ArrayList<>();
        for (List<Integer> integers : rArray) {
            List<Integer> tA = new ArrayList<>(integers);
            tA.add(currentElement);
            lR.add(tA);
        }

        rArray.addAll(lR);
    }

}

package _75.easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreaterCandies {

    public Boolean[] kidsWithCandies(int[] candies, int extraCandies) {

        int kidWithMaxCandies = -1;
        for(int candy: candies) kidWithMaxCandies = Math.max(kidWithMaxCandies, candy);

        Boolean[] candyStat = new Boolean[candies.length];
        for(int idx = 0; idx < candies.length; idx++){
            int maxKidCandy = candies[idx] + extraCandies;
            candyStat[idx] = maxKidCandy >= kidWithMaxCandies;
        }

        return candyStat;
    }

}

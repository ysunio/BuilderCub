package _75.medium;

import java.util.*;

public class PlayerWithZeroOneLoss {

    static class Result {
        int lostMatches;
        int winMatches;

        public Result(int lM, int wM) {
            this.lostMatches = lM;
            this.winMatches = wM;
        }

        public void addLost() {
            this.lostMatches++;
        }

        public void addWin() {
            this.winMatches++;
        }
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        int numberOfMatches = matches.length;

        HashMap<Integer, Result> playerResultMap = new HashMap<>();

        for (int[] match : matches) {
            int playerWon = match[0];
            int playerLost = match[1];

            if (!playerResultMap.containsKey(playerWon)) playerResultMap.put(playerWon, new Result(0, 0));
            if (!playerResultMap.containsKey(playerLost)) playerResultMap.put(playerLost, new Result(0, 0));

            playerResultMap.get(playerWon).addWin();
            playerResultMap.get(playerLost).addLost();
        }

        List<Integer> zeroLostPlayers = new ArrayList<>();
        List<Integer> oneLostPlayers = new ArrayList<>();

        for (Map.Entry<Integer, Result> playerMap : playerResultMap.entrySet()) {
            int playerId = playerMap.getKey();
            Result playerResult = playerMap.getValue();

            if (playerResult.lostMatches == 0) zeroLostPlayers.add(playerId);
            if (playerResult.lostMatches == 1) oneLostPlayers.add(playerId);
        }

        Collections.sort(zeroLostPlayers);
        Collections.sort(oneLostPlayers);

        return List.of(zeroLostPlayers, oneLostPlayers);
    }
}

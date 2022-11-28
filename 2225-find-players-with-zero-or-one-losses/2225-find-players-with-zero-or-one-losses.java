class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> noLoss = new ArrayList<>(), oneLoss = new ArrayList<>();
        Map<Integer, Integer> playerLosses = new TreeMap<>();
        for(int match[] : matches)
        {
            int winner = match[0], loser = match[1];
            playerLosses.put(loser, playerLosses.getOrDefault(loser, 0) + 1);
            playerLosses.put(winner, playerLosses.getOrDefault(winner, 0));
        }
        
        for(int player : playerLosses.keySet())
        {
            int losses = playerLosses.get(player);
            if(losses == 1) oneLoss.add(player);
            else if(losses == 0) noLoss.add(player);
        }
        
        return Arrays.asList(noLoss, oneLoss);
        
    }
}
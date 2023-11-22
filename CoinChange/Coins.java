class Coins {
    public static int coinChange(int[] coins, int amount) {
        //Amount + 1 to store from 0 to Amount
        int[] minCoins = new int[amount + 1];

        //Initialise Array so that Math.Min will work
        for (int i = 1; i <= amount; i++) {
            minCoins[i] = amount + 1; 
        }

        //Loop through each value up to Amount
        for (int i = 1; i <= amount; i++) {
            //Loop through each coin value
            for (int coin : coins) {
                //Check if using coin is possible
                if (i - coin >= 0) {
                    //Check current coin total in it keeping minimum value
                    minCoins[i] = Math.min(minCoins[i], minCoins[i - coin] + 1);
                }
            }
        }

        //If remainder is present not possible so -1 else return result
        return minCoins[amount] > amount ? -1 : minCoins[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = coinChange(coins, amount);

        System.out.println(result);
    }
}
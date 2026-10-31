public class Problem6_BestSingleTradeProfit {
    static int maxProfit(int[] prices) {
        int minimumPrice = Integer.MAX_VALUE;
        int bestProfit = 0;

        for (int price : prices) {
            if (price < minimumPrice) {
                minimumPrice = price;
            } else {
                bestProfit = Math.max(bestProfit, price - minimumPrice);
            }
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
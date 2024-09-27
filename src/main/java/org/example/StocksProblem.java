package org.example;

public class StocksProblem {
    /**
     * The cost of stock on each day is given in an array A[] of size N. Find all the
     * days on which you buy and sell the stock so that in between those days your profit is maximum.
     * Input: A[] = {100, 180, 260, 310, 40 ,535, 695}
     * Output: 865
     * Explanation: We can buy stock on day 0, and sell it on
     *              day 3 and again buying on day 4 and sell it
     *              on day 6, which will give us maximum profit.
     */
    public static int findMaxProfit(int[] stockPrice){
        if(stockPrice.length == 0)
            return 0;
        int bp = 0, sp = 0, profit = 0;
        for(int i=0; i<stockPrice.length; i++){
            if(bp==0){
                bp = stockPrice[i];
            }else if(stockPrice[i] <= bp){
                if(sp>0)
                    profit+=sp-bp;
                bp=stockPrice[i];
            } else if(stockPrice[i] > bp && stockPrice[i] > sp) {
                sp = stockPrice[i];
            }

        }
        profit+=sp-bp;
        return profit;
    }

    public static void main(String[] args) {
        int profit = findMaxProfit(new int[]{100, 180, 260, 310, 40 ,535, 695});
        System.out.println(profit);
        profit = findMaxProfit(new int[]{100, 80, 260, 310, 40 ,35, 695});
        System.out.println(profit);
    }
}

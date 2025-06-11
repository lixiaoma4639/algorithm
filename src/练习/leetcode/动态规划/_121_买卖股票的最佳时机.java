package 练习.leetcode.动态规划;

/**
 * 日期 : 2022/1/31.
 * 创建 : xin.li
 * 描述 : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class _121_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxPrice = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice){
                minPrice = prices[i];
            } else {
                maxPrice = Math.max(maxPrice, prices[i] - minPrice);
            }
        }
        return maxPrice;
    }




}










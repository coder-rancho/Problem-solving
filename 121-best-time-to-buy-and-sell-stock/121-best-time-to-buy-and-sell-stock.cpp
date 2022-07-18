class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buyi = 0;
        int selli = 0;
        int maxProfit = 0;
        
        for (int i = 0; i < prices.size(); i++) {
            int price = prices[i];
            
            if (price > prices[selli]) {
                selli = i;
                int profit = prices[selli] - prices[buyi];
                
                if (profit > maxProfit) maxProfit = profit;
            }
            else if (price < prices[buyi]) {
                buyi = selli = i;
            }
        }
        
        return maxProfit;
    }
};
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buy = prices[0];
        int sell = prices[0];
        // int len = prices.size();
        int maxProfit = 0;
        
        for (auto i : prices) {
            
            if (i < buy) {
                buy = i;
                sell = i;
            }
            else if (i > sell) {
                sell = i;
                maxProfit = (sell - buy) > maxProfit ? sell - buy: maxProfit;
            }
            // cout << " i:" << i << " buy:" << buy << " sell:" << sell << " prof:" << maxProfit << endl;
        }
        return maxProfit;        
    }
};
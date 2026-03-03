class Solution {
public:
    char findKthBit(int n, int k) {
        
        // Recursive helper to get kth bit in Sn
        function<int(int, int)> dfs = [&](int n, int k) {
            
            if (k == 1) return 0;  // First bit is always 0
            
            if ((k & (k - 1)) == 0) return 1;  // Middle position
            
            int totalLength = 1 << n;  // 2^n
            
            if (k * 2 < totalLength - 1)
                return dfs(n - 1, k);  // First half
            
            return dfs(n - 1, totalLength - k) ^ 1;  // Second half (reverse + invert)
        };
        
        return '0' + dfs(n, k);
    }
};
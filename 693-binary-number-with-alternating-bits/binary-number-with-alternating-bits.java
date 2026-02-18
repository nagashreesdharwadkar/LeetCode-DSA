class Solution {
    public boolean hasAlternatingBits(int n) {
        
        int prev = n & 1;   // Get last bit
        
        n = n >> 1;         // Shift right
        
        while(n > 0) {
            int current = n & 1;  // Get current last bit
            
            if(current == prev)   // If two adjacent bits are same
                return false;
            
            prev = current;       // Update previous bit
            n = n >> 1;           // Shift again
        }
        
        return true;
    }
}

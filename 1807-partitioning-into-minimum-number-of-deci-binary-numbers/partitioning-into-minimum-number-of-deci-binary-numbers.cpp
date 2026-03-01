class Solution {
public:
    int minPartitions(string n) {
        int maxDigit = 0;  // stores largest digit
        
        for (char& digit : n) {
            maxDigit = max(maxDigit, digit - '0');  // update max digit
        }
        
        return maxDigit;  // answer = largest digit
    }
};
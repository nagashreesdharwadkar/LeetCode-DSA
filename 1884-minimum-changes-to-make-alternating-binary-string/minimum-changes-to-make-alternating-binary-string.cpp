class Solution {
public:
    int minOperations(string s) {
        // Count changes needed for pattern "010101..."
        int operationsForPattern1 = 0;
        int n = s.size();

        // Check characters with expected pattern
        for (int i = 0; i < n; ++i) {
            // "01"[i & 1] gives expected char at index i
            if (s[i] != "01"[i & 1]) {
                operationsForPattern1++;
            }
        }

        // Compare with pattern "101010..."
        return min(operationsForPattern1, n - operationsForPattern1);
    }
};
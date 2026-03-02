class Solution {
public:
    int minSwaps(vector<vector<int>>& grid) {
        int n = grid.size();
      
        // Rightmost 1 index in each row (-1 if none)
        vector<int> rightmostOnePosition(n, -1);
      
        // Compute rightmost 1 for every row
        for (int row = 0; row < n; ++row) {
            for (int col = n - 1; col >= 0; --col) {
                if (grid[row][col] == 1) {
                    rightmostOnePosition[row] = col;
                    break;
                }
            }
        }
      
        int totalSwaps = 0;
      
        // Place a valid row at each position
        for (int targetRow = 0; targetRow < n; ++targetRow) {
            int foundRow = -1;
          
            // Find first row with rightmost 1 <= targetRow
            for (int candidateRow = targetRow; candidateRow < n; ++candidateRow) {
                if (rightmostOnePosition[candidateRow] <= targetRow) {
                    totalSwaps += candidateRow - targetRow;
                    foundRow = candidateRow;
                    break;
                }
            }
          
            // Impossible if none found
            if (foundRow == -1) {
                return -1;
            }
          
            // Bubble row up to target position
            for (int currentPos = foundRow; currentPos > targetRow; --currentPos) {
                swap(rightmostOnePosition[currentPos], rightmostOnePosition[currentPos - 1]);
            }
        }
      
        return totalSwaps;
    }
};
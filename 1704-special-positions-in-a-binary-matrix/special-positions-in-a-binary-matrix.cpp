class Solution {
public:
    int numSpecial(vector<vector<int>>& mat) {
        int r = mat.size(), c = mat[0].size(), ans = 0;
        vector<int> rs(r), cs(c);

        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                rs[i] += mat[i][j], cs[j] += mat[i][j];

        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                if(mat[i][j] && rs[i] == 1 && cs[j] == 1)
                    ans++;

        return ans;
    }
};
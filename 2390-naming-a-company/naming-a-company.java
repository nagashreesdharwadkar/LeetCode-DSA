class Solution {
    public long distinctNames(String[] ideas) {

        Set<String> set = new HashSet<>();
        for (String idea : ideas)
            set.add(idea);  // Store original ideas

        int[][] valid = new int[26][26];  // Valid swaps count

        // Count valid swaps for each idea
        for (String idea : ideas) {
            char[] arr = idea.toCharArray();
            int from = arr[0] - 'a';

            for (int to = 0; to < 26; to++) {
                arr[0] = (char) (to + 'a');
                if (!set.contains(String.valueOf(arr)))
                    valid[from][to]++;
            }
        }

        long total = 0;

        // Count valid distinct name pairs
        for (String idea : ideas) {
            char[] arr = idea.toCharArray();
            int from = arr[0] - 'a';

            for (int to = 0; to < 26; to++) {
                arr[0] = (char) (to + 'a');
                if (!set.contains(String.valueOf(arr)))
                    total += valid[to][from];
            }
        }

        return total;
    }
}
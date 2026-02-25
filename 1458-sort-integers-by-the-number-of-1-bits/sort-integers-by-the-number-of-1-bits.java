class Solution {
    public int[] sortByBits(int[] arr) {

        int n = arr.length;

        // Encode: value + (bitCount * 100000)
        for (int i = 0; i < n; i++) {
            int bits = Integer.bitCount(arr[i]);
            arr[i] += bits * 100000;
        }

        Arrays.sort(arr);  // Sort by bit count, then value

        // Decode original values
        for (int i = 0; i < n; i++) {
            arr[i] %= 100000;
        }

        return arr;
    }
}
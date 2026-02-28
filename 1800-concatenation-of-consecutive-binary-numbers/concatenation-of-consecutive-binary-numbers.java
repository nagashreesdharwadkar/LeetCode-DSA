class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1000000007; // Mod value
        long result = 0; // Final answer

        for (int currentNumber = 1; currentNumber <= n; currentNumber++) {
            int bitsRequired = 32 - Integer.numberOfLeadingZeros(currentNumber); // Bit length
            result = ((result << bitsRequired) | currentNumber) % MOD; // Append binary
        }

        return (int) result; // Return result
    }
}
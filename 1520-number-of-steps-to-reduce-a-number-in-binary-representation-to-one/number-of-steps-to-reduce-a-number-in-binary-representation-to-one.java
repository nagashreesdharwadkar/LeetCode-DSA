class Solution {

    // Count steps to reduce binary string to "1"
    public int numSteps(String s) {

        boolean carry = false;  // Track carry from +1
        int steps = 0;

        // Process from LSB to MSB (ignore first bit)
        for (int i = s.length() - 1; i > 0; i--) {

            char bit = s.charAt(i);

            // Apply previous carry
            if (carry) {
                if (bit == '0') {
                    bit = '1';
                    carry = false;
                } else {
                    bit = '0';
                }
            }

            if (bit == '1') {  // Odd → add 1
                steps++;
                carry = true;
            }

            steps++;  // Divide by 2
        }

        if (carry)  // Final carry case
            steps++;

        return steps;
    }
}
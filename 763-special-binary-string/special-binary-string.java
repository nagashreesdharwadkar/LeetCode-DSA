class Solution {

    // Returns lexicographically largest special binary string
    public String makeLargestSpecial(String s) {

        // If string is empty, return empty
        if (s.isEmpty()) {
            return "";
        }

        // Store special substrings
        List<String> list = new ArrayList<>();

        int balance = 0;      // Count of 1s - 0s
        int start = 0;        // Start index of substring

        // Traverse string
        for (int i = 0; i < s.length(); i++) {

            // Increase for '1', decrease for '0'
            if (s.charAt(i) == '1') {
                balance++;
            } else {
                balance--;
            }

            // If balanced, we found one special substring
            if (balance == 0) {

                // Recursively process inner part
                String inner = makeLargestSpecial(
                        s.substring(start + 1, i)
                );

                // Add processed substring
                list.add("1" + inner + "0");

                // Move start to next position
                start = i + 1;
            }
        }

        // Sort in descending order
        list.sort(Comparator.reverseOrder());

        // Join all parts
        return String.join("", list);
    }
}
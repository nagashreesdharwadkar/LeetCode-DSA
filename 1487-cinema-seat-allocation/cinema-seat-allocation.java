class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> rowReservations = new HashMap<>();

        // Build bitmask for reserved seats per row
        for (int[] r : reservedSeats) {
            int row = r[0];
            int seat = r[1];
            rowReservations.merge(row, 
                    1 << (10 - seat), 
                    (a, b) -> a | b);
        }

        // Masks for possible 4-seat groups
        int leftMask = 0b0111100000;    // Seats 2-5
        int rightMask = 0b0000011110;   // Seats 6-9
        int middleMask = 0b0001111000;  // Seats 4-7

        int total = (n - rowReservations.size()) * 2; // Rows without reservations

        // Check rows with reservations
        for (int reserved : rowReservations.values()) {
            if ((reserved & leftMask) == 0) {
                total++;
                reserved |= leftMask;
            }
            if ((reserved & rightMask) == 0) {
                total++;
            } else if ((reserved & middleMask) == 0) {
                total++;
            }
        }

        return total;
    }
}
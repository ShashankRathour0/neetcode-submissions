class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
          int x = target[0], y = target[1], z = target[2];
        boolean coverX = false, coverY = false, coverZ = false;

        for (int[] triplet : triplets) {
            int a = triplet[0], b = triplet[1], c = triplet[2];

            // Check if the triplet is relevant
            if (a <= x && b <= y && c <= z) {
                if (a == x) coverX = true;
                if (b == y) coverY = true;
                if (c == z) coverZ = true;
            }
        }

        // Return true if all parts of the target are covered
        return coverX && coverY && coverZ;
    }
}

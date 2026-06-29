class CountSquares {
 private Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        points.putIfAbsent(x, new HashMap<>());
        points.get(x).put(y, points.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int qx = point[0], qy = point[1];
        int count = 0;

        if (!points.containsKey(qx)) {
            return 0; // No points with the same x-coordinate
        }

        // Iterate over all points with the same x-coordinate
        Map<Integer, Integer> yMap = points.get(qx);
        for (Map.Entry<Integer, Integer> entry : yMap.entrySet()) {
            int py = entry.getKey();
            int freq = entry.getValue();

            if (py == qy) continue; // Skip the query point itself

            int side = Math.abs(py - qy);

            // Check right square
            count += freq * 
                     points.getOrDefault(qx + side, Collections.emptyMap()).getOrDefault(qy, 0) *
                     points.getOrDefault(qx + side, Collections.emptyMap()).getOrDefault(py, 0);

            // Check left square
            count += freq * 
                     points.getOrDefault(qx - side, Collections.emptyMap()).getOrDefault(qy, 0) *
                     points.getOrDefault(qx - side, Collections.emptyMap()).getOrDefault(py, 0);
        }

        return count;
    }
}

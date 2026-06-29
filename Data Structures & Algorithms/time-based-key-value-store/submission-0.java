class TimeMap {
  private Map<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
         map.putIfAbsent(key, new ArrayList<>());
        
        // Add the (timestamp, value) pair to the list
        map.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
         if (!map.containsKey(key)) {
            return "";
        }

        List<Pair<Integer, String>> list = map.get(key);
        
        // Perform binary search to find the closest timestamp <= given timestamp
        int left = 0, right = list.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).getKey() == timestamp) {
                return list.get(mid).getValue();  // Exact match found
            } else if (list.get(mid).getKey() < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // If no exact match, return the most recent value with timestamp <= given timestamp
        return right >= 0 ? list.get(right).getValue() : "";
    }
}
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
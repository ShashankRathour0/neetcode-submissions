class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();

    }

    public List<String> decode(String str) {
  List<String> decodedStrings = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // 1. Get the length of the next string (read up to the #)
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            
            // 2. Extract the string of the given length
            String abc = str.substring(j + 1, j + 1 + length);
            
            // 3. Add to result and update the pointer i
            decodedStrings.add(abc);
            i = j + 1 + length;
        }
        return decodedStrings;
    }
}

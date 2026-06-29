class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
   Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // Step 2: Initialize BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int transformations = 1; // Starting with the beginWord

        // Step 3: BFS Traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // Try all possible transformations
                char[] wordChars = currentWord.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String newWord = new String(wordChars);

                        // Check if the transformation is valid
                        if (newWord.equals(endWord)) {
                            return transformations + 1;
                        }
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // Avoid revisiting
                        }
                    }
                    wordChars[j] = originalChar; // Restore original character
                }
            }
            transformations++;
        }

        // If BFS completes without finding the endWord
        return 0;
    }
}

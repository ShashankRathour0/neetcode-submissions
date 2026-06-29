class Solution {
   
     static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // 26 for 'a' to 'z'
        String word = null; // If the node is the end of a word, store it here
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Step 1: Build the Trie
        TrieNode root = buildTrie(words);

        // Step 2: Initialize result list and start DFS from each cell
        List<String> result = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word; // Mark the end of the word
        }
        return root;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        char ch = board[r][c];

        // Check for boundaries, visited cells, and invalid paths
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a']; // Move to the next TrieNode
        if (node.word != null) { // Found a word
            result.add(node.word);
            node.word = null; // Avoid duplicates
        }

        // Mark the cell as visited
        board[r][c] = '#';

        // Explore all four directions
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                dfs(board, newRow, newCol, node, result);
            }
        }

        // Restore the cell for other paths
        board[r][c] = ch;
    }
}

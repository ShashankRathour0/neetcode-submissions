class Solution {
    public boolean exist(char[][] board, String word) {
           int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Start a backtracking search from each cell
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        // If all characters in the word are found, return true
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and character match
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark the current cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all four possible directions
        boolean found = backtrack(board, word, row + 1, col, index + 1) || // Down
                        backtrack(board, word, row - 1, col, index + 1) || // Up
                        backtrack(board, word, row, col + 1, index + 1) || // Right
                        backtrack(board, word, row, col - 1, index + 1);   // Left

        // Restore the cell's original state (backtracking)
        board[row][col] = temp;

        return found;
    }
}

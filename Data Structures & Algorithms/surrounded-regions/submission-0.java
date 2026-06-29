class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Perform DFS from all boundary cells containing 'O'
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') dfs(board, r, 0);        // Left boundary
            if (board[r][cols - 1] == 'O') dfs(board, r, cols - 1); // Right boundary
        }
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') dfs(board, 0, c);        // Top boundary
            if (board[rows - 1][c] == 'O') dfs(board, rows - 1, c); // Bottom boundary
        }

        // Post-process the board:
        // - Convert 'T' (temporarily marked) back to 'O'.
        // - Convert remaining 'O' to 'X'.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;

        // Base case: Out of bounds or already visited cell
        if (r < 0 || r >= rows || c < 0 || c >= cols || board[r][c] != 'O') {
            return;
        }

        // Mark the cell as visited (temporarily with 'T')
        board[r][c] = 'T';

        // Explore all 4 directions
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}

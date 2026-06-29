class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                
                // Skip empty cells
                if (current == '.') continue;
                
                // Create unique keys for rows, columns, and boxes
                String rowKey = "row " + i + " has " + current;
                String colKey = "col " + j + " has " + current;
                String boxKey = "box " + (i / 3) + "-" + (j / 3) + " has " + current;
                
                // If any key already exists, the Sudoku is invalid
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

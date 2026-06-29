class Solution {
    public List<List<String>> solveNQueens(int n) {
     List<List<String>> result = new ArrayList<>();
        
        // A list to store the positions of the queens
        // The index of the list is the row, and the value is the column where the queen is placed
        int[] positions = new int[n];
        
        // We use sets to track columns and diagonals that are under attack
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        
        // Backtracking function to find all solutions
        backtrack(0, n, columns, diag1, diag2, positions, result);
        
        return result;
    }
    
    private void backtrack(int row, int n, Set<Integer> columns, Set<Integer> diag1, Set<Integer> diag2, int[] positions, List<List<String>> result) {
        // If we have placed queens in all rows, we found a solution
        if (row == n) {
            result.add(generateBoard(positions, n));
            return;
        }
        
        // Try placing a queen in every column of the current row
        for (int col = 0; col < n; col++) {
            // Check if the column or diagonals are under attack
            if (columns.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }
            
            // Place the queen at (row, col)
            columns.add(col);
            diag1.add(row - col);
            diag2.add(row + col);
            positions[row] = col;  // Save the column position for the current row
            
            // Recurse to place queens in the next row
            backtrack(row + 1, n, columns, diag1, diag2, positions, result);
            
            // Backtrack by removing the queen and undoing the choices
            columns.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
            positions[row] = -1;  // Reset the position for the current row
        }
    }
    
    // Convert the solution to a board representation
    private List<String> generateBoard(int[] positions, int n) {
        List<String> board = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');  // Fill the row with empty spaces
            row[positions[i]] = 'Q';  // Place the queen at the column
            board.add(new String(row));
        }
        
        return board;
    }
}

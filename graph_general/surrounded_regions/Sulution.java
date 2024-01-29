class Solution {
  public void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    boolean[][] marked = new boolean[m][n];

    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (r == 0 || r == m - 1 || c == 0 || c == n - 1) {
          explore(r, c, marked, board, m, n);
        }
      }
    }

    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (!marked[r][c]) {
          board[r][c] = 'X';
        }
      }
    }
  }

  private void explore(int r, int c, boolean[][] marked, char[][] board, int m, int n) {
    if (r < 0 || r >= m || c < 0 || c >= n) {
      return;
    }

    if (marked[r][c] || board[r][c] == 'X') {
      return;
    }

    marked[r][c] = true;
    explore(r + 1, c, marked, board, m, n);
    explore(r, c + 1, marked, board, m, n);
    explore(r - 1, c, marked, board, m, n);
    explore(r, c - 1, marked, board, m, n);
  }
}

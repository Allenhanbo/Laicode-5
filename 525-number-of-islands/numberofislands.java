public class Solution {
  public int numIslands(char[][] grid) {
    // T: O(n * m) S: O(1)
    int count =0;
    if(grid == null || grid.length == 0 || grid[0].length == 0) {
      return count;
    }
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[0].length;j++) {
        if(grid[i][j] == '1') {
          //find a new island
          count++;
          dfs(grid, i, j);
        }
      }
    }
    return count;
  }
  private void dfs(char[][] grid, int i, int j) {
    if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
    || grid[i][j] == '0') {
      return;
    }
    //the same function as visited
    // turn the 1 into 0
    grid[i][j] = '0';
    //traversal 4 direction
    dfs(grid, i-1, j);
    dfs(grid, i+1,j);
    dfs(grid, i, j+1);
    dfs(grid, i, j-1);
  }
}

class Solution {
    public int shortestDistance(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        Set<Integer>[][] visited = new HashSet[grid.length][grid[0].length];
        Queue<int[]> que = new LinkedList<>();
        int cnt = 0;
        int maxcnt = 0;
        for(int i =0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    que.add(new int[]{i,j,0,cnt++});
                    maxcnt+=1;
                }
                visited[i][j] = new HashSet<>();
            }
        }
        int min = Integer.MAX_VALUE;
​
        while(!que.isEmpty()){
            int[] p = que.poll();
            int x = p[0];
            int y = p[1];
            int l = p[2];
            int id = p[3];
            if(visited[x][y].size() == maxcnt){
                min = Math.min(min, dp[x][y]);
            }
​
            for(int[] dir : dirs){
                int x1 = x + dir[0];
                int y1 = y + dir[1];
                if(!isNotValid(grid, x1, y1) && !visited[x1][y1].contains(id)){
                    visited[x1][y1].add(id);
                    dp[x1][y1] += l+1;
                    que.add(new int[]{x1,y1,l+1,id});
                }
            }
        }
​
        return min == Integer.MAX_VALUE? -1:min;
    }
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    boolean isNotValid(int[][] grid, int i, int j){
        return i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 1 || grid[i][j] == 2;
    }
}
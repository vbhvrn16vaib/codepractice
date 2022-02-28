class Solution {
    public int shortestDistance(int[][] grid) {
        int[][] fdp = new int[grid.length][grid[0].length];
        Queue<int[]> que = new LinkedList<>();
        for(int i =0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    Integer[][] dp = new Integer[grid.length][grid[0].length];
                    dfs(grid, i, j, dp);
                    // for(int k = 0; k < dp.length; k++) System.out.println(Arrays.toString(dp[k]));
                    sum(dp, fdp);
                }
            }
        }
        // for(int k = 0; k < fdp.length; k++) System.out.println(Arrays.toString(fdp[k]));
        int min  = Integer.MAX_VALUE;
        for(int k = 0; k < fdp.length; k++){
            for(int f = 0; f < fdp[0].length; f++){
                min = Math.min(min, fdp[k][f]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    void dfs(int[][] grid, int i , int j,Integer[][] dp){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{i,j,0});
        grid[i][j] = 0;
        boolean[][] visited = new boolean[dp.length][dp[0].length];
        while(!que.isEmpty()){
            int[] v = que.poll();
            int x = v[0];
            int y = v[1];
            int sf = v[2];
            visited[x][y] = true;
            for(int[] dir : dirs){
                int x1 = x + dir[0];
                int x2 = y + dir[1];
                if(isNotValid(grid, x1, x2, visited)){
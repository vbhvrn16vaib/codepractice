class Solution {
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    // [2,2,2],
    // [0,2,2],
    // [1,0,2]
    public int orangesRotting(int[][] grid) {
        //{x,y,0}
        Queue<int[]> rotten = new LinkedList<>();
        int good = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) rotten.add(new int[]{i,j,0});
                if(grid[i][j] == 1) good+=1;
            }
        }
        // System.out.println(good);
        //[[2,2],[1,1],[0,0],[2,0]]
        int max = 0;
        while(!rotten.isEmpty()){
            int[] ro = rotten.poll();
            // System.out.println(Arrays.toString(ro));
            int x = ro[0];
            int y = ro[1];
            for(int[] d : dirs){
                int cx = d[0]+x;
                int cy = d[1]+y;
                // System.out.println(cx +"-" + cy);        
                if(!isNotValid(grid, cx,cy)){
                    grid[cx][cy]= 2;
                    rotten.add(new int[]{cx, cy, ro[2]+1});
                    max = Math.max(max, ro[2]+1);
                }
            }
        }
        // for(int[] i : grid) System.out.println(Arrays.toString(i));
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) if(grid[i][j] == 1) return -1;
        }
            return max;
    }
        boolean isNotValid(int[][] grid, int x, int y){
            return x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 2 || grid[x][y] == 0;
        }
}
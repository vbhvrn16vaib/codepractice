                }
                visited[i][j] = new HashSet<>();
            }
        }
        while(!que.isEmpty()){
            int[] p = que.poll();
            int x = p[0];
            int y = p[1];
            int l = p[2];
            int id = p[3];
            if(visited[x][y].contains(id))continue;
            visited[x][y].add(id);
            if(visited[x][y].size() == maxcnt){
//                 for(int i = 0 ; i < dp.length; i++){
//                     for(int j = 0; j < dp[0].length; j++){
//                         System.out.print(visited[i][j]);
//                     }
//                     System.out.println("--");
//                 }
                for(int i = 0; i < dp.length; i++) System.out.println(Arrays.toString(dp[i]));
                return dp[x][y];
            }
            for(int[] dir : dirs){
                int x1 = x + dir[0];
                int y1 = y + dir[1];
                if(!isNotValid(grid, x1, y1) && !visited[x1][y1].contains(id)){
                    dp[x1][y1] += l+1;
                    que.add(new int[]{x1,y1,l+1,id});
                }
            }
        }
        // for(int i = 0; i < dp.length; i++) System.out.println(Arrays.toString(dp[i]));
        return -1;
    }
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    boolean isNotValid(int[][] grid, int i, int j){
        return i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 1 || grid[i][j] == 2;
    }
}
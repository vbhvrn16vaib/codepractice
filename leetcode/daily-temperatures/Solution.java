class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2) -> o1[0]-o2[0]);
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            if(que.isEmpty()){
                que.add(new int[]{temperatures[i],i});
                continue;
            }
            int temp = temperatures[i];
            while(!que.isEmpty() && que.peek()[0] < temp){
                int[] ar = que.poll();
                result[ar[1]] = i-ar[1];
            }
            que.add(new int[]{temperatures[i],i});
        }
        while(!que.isEmpty()){
            int[] ar = que.poll();
            result[ar[1]] = 0;
        }
        return result;
    }
}
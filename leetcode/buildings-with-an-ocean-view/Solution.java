class Solution {
    public int[] findBuildings(int[] heights) {
        int max = -1;
        List<Integer> result = new ArrayList<>(); 
        for(int i = heights.length-1; i >= 0; i--){
            if(max < heights[i]){
                max = heights[i];
                result.add(i);
            }
        }
        int[] rr = new int[result.size()];
        for(int i = result.size()-1; i>= 0; i--){
            rr[rr.length-i-1] = result.get(i);
        }
        return rr;
    }
}
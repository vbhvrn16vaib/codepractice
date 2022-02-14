class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        for(int i = 0 ; i < nums2.length; i++){
            posMap.putIfAbsent(nums2[i], new ArrayList<>());
            posMap.get(nums2[i]).add(i);
        }
        int max = 0;
        for(int i = 0; i < nums1.length; i++){
            List<Integer> pos2 = posMap.getOrDefault(nums1[i], new ArrayList<>());
            for(int p : pos2){
                int j = i;
                int k = p;
                int cnt = 0;
                while( j < nums1.length && k < nums2.length && nums1[j] == nums2[k]){
                    j+=1;
                    k+=1;
                    cnt+=1;
                }
                max = Math.max(cnt, max);
            }
        }
        return max;
    }
}
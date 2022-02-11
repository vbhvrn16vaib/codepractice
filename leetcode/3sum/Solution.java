class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            map.putIfAbsent(nums[i],new HashSet<>());
            map.get(nums[i]).add(i);
        }
        Set<List<Integer>> ps = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                System.out.println(map);
                if(map.containsKey(0-sum) && !map.get(0-sum).contains(i) && !map.get(0-sum).contains(j)){
                    List<Integer> d = Arrays.asList(nums[i],nums[j],0-sum);
                    Collections.sort(d);
                    ps.add(d);
                }
            }
        }
        return new ArrayList<>(ps);
    }
}
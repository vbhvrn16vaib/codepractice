class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int s = nums.length-1;
        while(l < r){
            int mid = (l+r)/2;
            if(nums[mid] >= nums[s]){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return nums[r];
    }
}
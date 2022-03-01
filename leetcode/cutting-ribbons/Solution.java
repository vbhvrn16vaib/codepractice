class Solution {
    public int maxLength(int[] ribbons, int k) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < ribbons.length; i++){
            min = Math.min(ribbons[i], min);
        }
        int l = 1;
        int r = 1000000;
        while(l <= r){
            int mid  = (l + r)/2;
            int cnt = getCut(mid, ribbons);
            if(cnt < k){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l-1;
    }
    public int getCut(int m, int[] rib){
        int k = 0;
        for(int i : rib){
            k+=i/m;
        }
        return k;
    }
}
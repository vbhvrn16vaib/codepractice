class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int mlen = 0;
       for(int i = 0; i < nums1.length; i++){
           int k = i;
           int tlen = 0;
           for(int j = 0; j < nums2.length; j++){
               if(k == nums1.length || nums2[j] != nums1[k]){
                   k = i;
                   tlen = 0;
                   continue;
               }
               k+=1;
               tlen+=1;
               mlen = Math.max(tlen, mlen); 
           }
       }
        return mlen;
    }
    public void print(String d){
        System.out.println(d);
    }
}
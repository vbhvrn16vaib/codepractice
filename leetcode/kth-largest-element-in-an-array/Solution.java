class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        k = k-1;
        int r = nums.length-1;
        while(l < r){
            int piv = partition(nums, l, r);
            if(piv == k) return nums[piv];
            if(piv < k){
                l = piv+1;
            }else{
                r = piv-1;
            }
        }
        return -1;
    }
    public int partition ( int A[],int start ,int end) {
    int i = start + 1;
    int piv = A[start] ;            //make the first element as pivot element.
    for(int j =start + 1; j <= end ; j++ )  {
    /*rearrange the array by putting elements which are less than pivot
       on one side and which are greater that on other. */
​
          if ( A[ j ] < piv) {
                 swap (A, A[ i ],A [ j ]);
            i += 1;
        }
   }
       swap ( A, A[ start ] ,A[ i-1 ] ) ;  //put the pivot element in its proper place.
       return i-1;                      //return the position of the pivot
    }
    public void swap(int[] num , int i , int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i < j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }
        if(i >= j) return true;
        int l=i+1;
        while(l < j && s.charAt(l)==s.charAt(j) ){
            l+=1;
            j-=1;
        }
        if(l >= j) return true;
        l = j-1;
        while(l < j && s.charAt(l) == s.charAt(j)){
            l+=1;
            j-=1;
        }
        if(l >= j) return true;
        return false;
    }
}
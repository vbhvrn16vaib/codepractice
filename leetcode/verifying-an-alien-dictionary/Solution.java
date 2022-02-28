class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> po = new HashMap<>();
        for(int i =0; i < order.length(); i++){
            po.put(order.charAt(i), i);
        }
        for(int i = 1 ; i < words.length; i++){
            String a = words[i-1];
            String b = words[i];
            if(!check(a,b,po)) return false;
        }
        return true;
    }
    boolean check(String a, String b, Map<Character, Integer> map){
        int min = Math.min(a.length(), b.length());
        for(int i = 0; i < min; i++){
            if(map.get(a.charAt(i)) != map.get(b.charAt(i))){
                return map.get(a.charAt(i)) < map.get(b.charAt(i));
            }
        }
        return a.substring(0,min).equals(b.substring(0,min)) ? a.length() <= b.length() : false;
    }
}
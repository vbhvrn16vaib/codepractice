class Solution {
    public int longestPalindrome(String[] words) {
        //lc -> cl
        //cc cc -> 2
        //ll cc ll -> llccll
        //ini
        Map<String, Integer> map = new HashMap<>();
        List<String> pali= new ArrayList<>();
        //figuring the counts
        for(String word : words){
            if(word.charAt(0) == word.charAt(1)) pali.add(word);
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        //selecting the palindrom with count 1
//         int result = 0;
//         for(String d: pali){
//             if(map.get(d) == 1){
//                 result+=2;
//                 map.remove(d);
//                 break;
//             }
//         }
        System.out.println(map);
        //creating the palindrom
        int result = 0;
        boolean isOne = false;
        for(String word : words){
            if(!map.containsKey(word)) continue;
​
            char d1 = word.charAt(0);
            char d2 = word.charAt(1);
            String sm = d2+""+d1;
            if(d1 == d2 && map.get(word) == 1 && !isOne){
                result+=2;
                map.remove(word);
                isOne = true;
                continue;
            }
                if(map.get(word) > 1){
                    map.put(word, map.get(word)-1);
                }else{
                    map.remove(word);
                }
            if(map.containsKey(sm)){
                if(map.get(sm) > 1){
                    map.put(sm, map.get(sm)-1);
                }else{
                    map.remove(sm);
                }
                result+=4;
            }
        }
        //returning the result
        return result;
    }
}
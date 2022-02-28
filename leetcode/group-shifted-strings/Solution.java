class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strings){
            String key = hash(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        // System.out.println(map);
        return new ArrayList<>(map.values());
    }
    String hash(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++){
            int key = s.charAt(i)-s.charAt(i-1);
            if(s.charAt(i) < s.charAt(i-1)){
                key+=26;
            }
            sb.append(key).append("_");
        }
        return sb.toString();
    }
}
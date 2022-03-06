class Solution {
    int k;
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        k = n;
        dfs(2*n,0,result, new StringBuilder());
        return result;
    }
    public void dfs(int n, int open, List<String> result, StringBuilder sb){
        if(n <= 0){
            if(open == 0){
                result.add(sb.toString());
            }
            return;
        }
        if(open <= k){
            sb.append('(');
            dfs(n-1, open+1,result, sb);    
            sb.deleteCharAt(sb.length()-1);
        }
        if(open > 0){
            sb.append(')');
            dfs(n-1, open-1, result,sb);
            sb.deleteCharAt(sb.length()-1);
        }
​
    }
}
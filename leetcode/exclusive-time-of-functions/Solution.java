class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Log> stack = new Stack<>();
                
        for(int i = 0; i < logs.size(); i++){
            String d = logs.get(i);
            Log x = new Log(d.split(":"));
            System.out.println(stack);
            if(x.isEnd()){
                Log nx = stack.pop();
                result[nx.id] += nx.lastEnd == null ? x.pos - nx.pos +1 : x.pos - nx.lastEnd;
                if(!stack.isEmpty()){
                    stack.peek().lastEnd = x.pos;
                }
            }else{
                if(!stack.isEmpty()){
                    Log l = stack.peek();   
                    result[l.id] = x.pos - l.pos;
                }
                stack.push(x);
            }
        }
        
        return result;
        
    }
    

    class Log{
        int id;
        int pos;
        String status;
        int elaps;
        Integer lastEnd;
        
        public Log(String[] x){
            this.id = Integer.parseInt(x[0]);
            this.pos = Integer.parseInt(x[2]);
            this.status = x[1];
        }
        
        public boolean isEnd(){
            return status.equals("end");
        }
        
        public String toString(){
            return id + "-" + status + "-" + pos + "-" + elaps + "-" + lastEnd;
        }
    }
}

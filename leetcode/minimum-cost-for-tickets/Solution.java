class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length-1;
        int[] day = new int[days[n]+1];
        Set<Integer> set = new HashSet<>();
        for(int d : days){
            set.add(d);
        }
        for(int i = days[0]; i <= days[n]; i++){
            if(!set.contains(i)){
                day[i] = day[i-1];
                continue;
            }
            int k = day[i-1]+costs[0];
            int week = i < 7 ? costs[1] : day[i-7] + costs[1];
            int month = i < 30? costs[2] : day[i-30] + costs[2];
            day[i] = min(k,week,month);
        }
        return day[days[n]];
    }
    public int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }
}
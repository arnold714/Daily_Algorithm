class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        long time_cur;
        int s = 1;
        int e = 100000;
        int mid = 0;
        while(s <= e){
            mid = (s+e) / 2;
            time_cur = 0;
            for(int i = 0 ; i < diffs.length ; i++){
                if(i==0){
                    time_cur += calculate(diffs[i], times[i], 0, mid);
                }else{
                    time_cur += calculate(diffs[i], times[i], times[i-1], mid);
                }
            }
            if(time_cur > limit){
                s = mid + 1;
            }else{
                e = mid - 1;
                answer = mid;
            }
            System.out.println(answer);
        }
        return answer;
    }
    
    public long calculate(int diff, int time_cur, int time_prev, long level){
        long wrong_cnt = diff - level;
        long time_all = 0;
        if(wrong_cnt > 0){
            time_all =  (time_cur+time_prev) * wrong_cnt + time_cur;
            return time_all;
        }else{
            return time_cur;
        }
    }
}
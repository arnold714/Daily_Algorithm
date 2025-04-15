class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int startsec = h1 * 60 * 60 + m1 * 60 + s1;
        int finsec = h2 * 60 * 60 + m2 * 60 + s2;
        
        int dist = 43200;
        int vsec = 720;
        int vmin = 12;
        int vhour = 1;
        
        int h = (h1 * 3600 + m1 * 60 + s1) % 43200;
        int m = (m1 * 60 + s1) * 12;
        int s = s1 * vsec;
        
        if(h == s || m == s){
            answer++;
        }
        System.out.println(h + ":" + m + ":" + s);
        for(int sec = 1 ; sec <= finsec - startsec ; sec++){
            if(h > s && h + vhour <= s + vsec 
               && m > s && m + vmin <= s + vsec 
               && h + vhour == m + vmin){
                answer++;
            }else{
                if( h > s && h + vhour <= s + vsec){
                    answer++;
                }
                if(m > s && m + vmin <= s + vsec){
                    answer++;
                }
            }
            h = (h + vhour) % 43200;
            m = (m + vmin) % 43200;
            s = (s + vsec) % 43200;
            
        }
        System.out.println(h + ":" + m + ":" + s);
        return answer;
    }
}
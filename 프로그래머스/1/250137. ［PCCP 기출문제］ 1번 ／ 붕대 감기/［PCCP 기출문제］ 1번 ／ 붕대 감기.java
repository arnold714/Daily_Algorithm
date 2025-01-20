import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int now_time = 0;
        int now_attack = 0;
        int combo = 0;
        int max_health = health;
        int max_time = attacks[attacks.length-1][0];
        while(now_time <= max_time){
            if(attacks[now_attack][0] == now_time){
                combo = 0;
                health -= attacks[now_attack][1];
                now_attack++;
            }else{
                combo++;
                health += bandage[1];
                if(combo>=bandage[0]){
                   	health += bandage[2];
                	combo = 0;
                }
                if(health>max_health){
                    health = max_health;
                }
            }
            now_time++;
            if(health<=0){
                return -1;
            }
            System.out.println(health);
        }
        return health;
    }
}
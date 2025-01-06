import java.util.*;
import java.io.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        String[] video_len_split = video_len.split(":");
        int video_len_min = Integer.parseInt(video_len_split[0]);
        int video_len_sec = Integer.parseInt(video_len_split[1]);
        int video_len_time = video_len_min * 60 + video_len_sec;
        
        String[] pos_split = pos.split(":");
        int pos_min = Integer.parseInt(pos_split[0]);
        int pos_sec = Integer.parseInt(pos_split[1]);
        int pos_time = pos_min * 60 + pos_sec;

        
        String[] op_start_split = op_start.split(":");
        int op_start_min = Integer.parseInt(op_start_split[0]);
        int op_start_sec = Integer.parseInt(op_start_split[1]);
        int op_start_time = op_start_min * 60 + op_start_sec;
        
        String[] op_end_split = op_end.split(":");
        int op_end_min = Integer.parseInt(op_end_split[0]);
        int op_end_sec = Integer.parseInt(op_end_split[1]);
        int op_end_time = op_end_min * 60 + op_end_sec;
        for(String command : commands){
            if((pos_time >= op_start_time && pos_time < op_end_time)
                  ){
                    pos_time = op_end_time;
                }
            if(command.equals("prev")){
                if(pos_time<10){
                    pos_time = 0;
                }else{
                    pos_time -= 10;
                }
            }else if(command.equals("next")){
                pos_time += 10;
                if(pos_time > video_len_time){
                    pos_time = video_len_time;
                }
            }
            
            System.out.println((int)pos_time / 60+":"+pos_time % 60);
        }
        if((pos_time >= op_start_time && pos_time < op_end_time)
                  ){
                    pos_time = op_end_time;
                }
        String min_ans, sec_ans;
        pos_min = (int)(pos_time / 60);
        pos_sec = pos_time % 60;
        if(pos_min < 10){
            min_ans = "0"+pos_min;
        }else{
            min_ans = pos_min+"";
        }
        if(pos_sec < 10){
            sec_ans = "0"+pos_sec;
        }else{
            sec_ans = pos_sec+"";
        }
        answer = min_ans+":"+sec_ans;
        return answer;
    }
}


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // M: 가로, N: 세로, H: 높이
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int[][][] box = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0, 1, 0, -1, 0, 0};
        int[] dy = {1, 0, -1, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};
        
        int total = 0; // 익지 않은 토마토의 개수
        int answer = 0; // 최종 시간
        
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        q.add(new int[]{h, n, m, 0}); // 시작 위치 큐에 추가
                    } else if (box[h][n][m] == 0) {
                        total++; // 익지 않은 토마토 개수 증가
                    }
                }
            }
        }
        
        if (total == 0) {
            System.out.println(0);
            return;
        }
        
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int h = node[0];
            int n = node[1];
            int m = node[2];
            int time = node[3];
            
            // 토마토 익히기
            answer = time;
            for (int i = 0; i < 6; i++) {
                int nh = h + dz[i];
                int nn = n + dy[i];
                int nm = m + dx[i];
                
                if (nh >= 0 && nh < H && nn >= 0 && nn < N && nm >= 0 && nm < M && box[nh][nn][nm] == 0) {
                    box[nh][nn][nm] = 1; // 익힌 상태로 변경
                    total--; // 익지 않은 토마토 개수 감소
                    q.add(new int[]{nh, nn, nm, time + 1}); // 큐에 추가
                }
            }
        }
        
        // 모든 토마토가 익지 않았다면
        if (total != 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}



import java.io.*;
import java.util.*;

public class Main{

static ArrayList<Integer>[] list;
static int answer;
static int[] group;
static int[] edge;
static boolean[] visited;
static int N;
static int num = 1;

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    while (true) {
        answer = 0;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (N == 0 && M == 0) {
            break;
        }
        list = new ArrayList[N + 1];
        group = new int[N + 1];
        edge = new int[N + 1];
        visited = new boolean[N + 1];
        for (int n = 1; n <= N; n++) {
            list[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (group[start] == 0 && group[end] == 0) {
                group[start] = start < end ? start : end;
                group[end] = group[start];
                edge[group[start]]++;

            } else if (group[start] == 0) {
                group[start] = group[end];
                edge[group[start]]++;
            } else if (group[end] == 0) {
                group[end] = group[start];
                edge[group[start]]++;
            } else if (group[start] != group[end]) {
            	
                if (group[start] < group[end]) {
                    edge[group[start]] += edge[group[end]] + 1;
                    edge[group[end]] = 0;
                    int x = group[end];
                    for (int i = 1; i <= N; i++) {
                    	
                        if (group[i] == x) {
                            group[i] = group[start];
                        }
                    }
                } else if (group[start] > group[end]) {
                    edge[group[end]] += edge[group[start]] + 1;
                    edge[group[start]] = 0;
                    int x = group[start];

                    for (int i = 1; i <= N; i++) {
                        if (group[i] == x) {
                            group[i] = group[end];
                        }
                    }
                }

            } else {
                edge[group[start]]++;
            }
        }
        
        for (int n = 1; n <= N; n++) {
            if(group[n]==0) {
                answer++;
                continue;
            }
            if (visited[group[n]]) {
                continue;
            }
            int member = 0;
            visited[group[n]] = true;
            
            for (int i = 1; i <= N; i++) {
                if (group[i] == group[n]) {
                    member++;
                }
            }
            if (member - edge[group[n]] == 1) {
                answer++;
            }
        }
        sb.append("Case " + (num++) + ": ");
        if (answer == 0) {
            sb.append("No trees.\n");
        } else if (answer == 1) {
            sb.append("There is one tree.\n");
        } else {
            sb.append("A forest of " + answer + " trees.\n");
        }
    }

    System.out.println(sb.toString());
}
}

import java.io.*;
import java.util.*;

public class Main{
    static int N, E, v1, v2;
    static ArrayList<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // 두 경로의 최단 거리 계산
        long path1 = calculatePath(1, v1, v2, N);
        long path2 = calculatePath(1, v2, v1, N);

        // 결과 출력
        long result = Math.min(path1, path2);
        System.out.println(result >= Integer.MAX_VALUE ? -1 : result);
    }

    // 다익스트라 알고리즘으로 최단 거리 계산
    private static long dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int current = cur[0];
            int currentDist = cur[1];

            if (currentDist > dist[current]) continue;

            for (int[] edge : list[current]) {
                int next = edge[0];
                int weight = edge[1];

                if (dist[next] > dist[current] + weight) {
                    dist[next] = dist[current] + weight;
                    pq.add(new int[]{next, (int) dist[next]});
                }
            }
        }
        return dist[end];
    }

    // 특정 경로의 전체 거리 계산
    private static long calculatePath(int start, int mid1, int mid2, int end) {
        long dist1 = dijkstra(start, mid1);
        long dist2 = dijkstra(mid1, mid2);
        long dist3 = dijkstra(mid2, end);

        if (dist1 == Integer.MAX_VALUE || dist2 == Integer.MAX_VALUE || dist3 == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return dist1 + dist2 + dist3;
    }
}
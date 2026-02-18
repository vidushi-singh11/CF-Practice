import java.io.*;
import java.util.*;

public class flightdiscount {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<long[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            graph.get(a).add(new long[]{b, c});
        }
        long[][] dist = new long[n + 1][2];

        for (int i = 1; i <= n; i++) {
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1] = Long.MAX_VALUE;
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0])
        );

        dist[1][0] = 0;
        pq.add(new long[]{0, 1, 0});

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();
            long curDist = cur[0];
            int node = (int) cur[1];
            int used = (int) cur[2];
            if (curDist > dist[node][used]) continue;
            for (long[] e : graph.get(node)) {

                int next = (int) e[0];
                long weight = e[1];

                if (dist[next][used] > curDist + weight) {
                    dist[next][used] = curDist + weight;
                    pq.add(new long[]{dist[next][used],next,used});
                }

                if (used == 0) {
                    long discounted = curDist + weight / 2;

                    if (dist[next][1] > discounted) {
                        dist[next][1] = discounted;
                        pq.add(new long[]{discounted, next, 1});
                    }
                }
            }
        }

        System.out.println(Math.min(dist[n][0], dist[n][1]));
    }
}

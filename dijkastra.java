import java.io.*;
import java.util.*;

public class dijkastra {

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws Exception {

        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long w = sc.nextLong();

            adj.get(a).add(new long[]{b, w});
            adj.get(b).add(new long[]{a, w});
        }

        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];

        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0])
        );

        dist[1] = 0;
        pq.add(new long[]{0, 1});

        while (!pq.isEmpty()) {

            long[] cur = pq.poll();
            long currDist = cur[0];
            int node = (int) cur[1];

            if (currDist > dist[node]) continue;

            for (long[] edge : adj.get(node)) {

                int next = (int) edge[0];
                long weight = edge[1];

                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    parent[next] = node;
                    pq.add(new long[]{dist[next], next});
                }
            }
        }

        if (dist[n] == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        int current = n;
        while (current != 0) {
            path.add(current);
            current = parent[current];
        }

        Collections.reverse(path);

        for (int node : path) {
            System.out.print(node + " ");
        }
    }
}

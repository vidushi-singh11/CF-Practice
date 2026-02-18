import java.io.*;
import java.util.*;

public class shortestpath {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            while ((c = read()) <= ' ') ;
            if (c == '-') { s = -1; c = read(); }
            while (c > ' ') {
                x = x * 10 + c - '0';
                c = read();
            }
            return x * s;
        }

        long nextLong() throws IOException {
            int c, s = 1;
            long x = 0;
            while ((c = read()) <= ' ') ;
            if (c == '-') { s = -1; c = read(); }
            while (c > ' ') {
                x = x * 10 + c - '0';
                c = read();
            }
            return x * s;
        }
    }

    static class Edge {
        int to;
        long weight;
        Edge(int t, long w) {
            to = t;
            weight = w;
        }
    }

    static class Pair {
        long dist;
        int node;
        Pair(long d, int n) {
            dist = d;
            node = n;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Edge>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();
            adj[a].add(new Edge(b, c));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[1] = 0;
        pq.add(new Pair(0, 1));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (curr.dist != dist[curr.node]) continue;

            for (Edge e : adj[curr.node]) {
                if (dist[curr.node] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[curr.node] + e.weight;
                    pq.add(new Pair(dist[e.to], e.to));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(dist[i]).append(" ");

        System.out.print(sb);
    }
}

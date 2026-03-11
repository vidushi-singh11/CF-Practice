import java.util.*;
public class jzzhuandcities {
    static class Edge {
        int to;
        long wt;
        Edge(int t, long w) {
            to = t;
            wt = w;
        }
    }
    static long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long x = sc.nextLong();
            graph.get(u).add(new Edge(v, x));
            graph.get(v).add(new Edge(u, x));
        }

        long[] trainCity = new long[k];
        long[] trainCost = new long[k];

        for (int i = 0; i < k; i++) {
            trainCity[i] = sc.nextLong();
            trainCost[i] = sc.nextLong();
        }
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<long[]> pq =new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        dist[1] = 0;
        pq.add(new long[]{1, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int) cur[0];
            long d = cur[1];

            if (d > dist[node]) continue;

            for (Edge e : graph.get(node)) {
                if (dist[e.to] > d + e.wt) {
                    dist[e.to] = d + e.wt;
                    pq.add(new long[]{e.to, dist[e.to]});
                }
            }
        }

        int removable = 0;

        for (int i = 0; i < k; i++) {
            int city = (int) trainCity[i];
            long cost = trainCost[i];

            if (dist[city] <= cost) {
                removable++;
            } else {
                dist[city] = cost;
            }
        }

        System.out.println(removable);
    }
}

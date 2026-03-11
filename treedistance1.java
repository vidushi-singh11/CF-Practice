import java.util.*;

public class treedistance1 {

    static ArrayList<Integer>[] adj;
    static int n;

    static int bfs(int start, int[] dist) {
        Queue<Integer> q = new LinkedList<>();

        Arrays.fill(dist, -1);

        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : adj[node]) {
                if (dist[next] == -1) {
                    dist[next] = dist[node] + 1;
                    q.add(next);
                }
            }
        }

        int far = start;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[far]) {
                far = i;
            }
        }

        return far;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj[a].add(b);
            adj[b].add(a);
        }
        int[] distA = new int[n + 1];
        int[] distB = new int[n + 1];
        int A = bfs(1, distA);
        int B = bfs(A, distA);
        bfs(B, distB);
        for (int i = 1; i <= n; i++) {
            System.out.print(Math.max(distA[i], distB[i]) + " ");
        }
    }
}
import java.io.*;
import java.util.*;

public class longestflightroute {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);

            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0)
                    q.add(v);
            }
        }

        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MIN_VALUE);
        int[] parent = new int[n + 1];
        dp[1] = 1;
        for (int u : topo) {
            if (dp[u] == Long.MIN_VALUE)
                continue;
            for (int v : adj.get(u)) {
                if (dp[u] + 1 > dp[v]) {
                    dp[v] = dp[u] + 1;
                    parent[v] = u;
                }
            }
        }
        if (dp[n] == Long.MIN_VALUE) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.println(dp[n]);
        List<Integer> path = new ArrayList<>();
        int curr = n;
        while (curr != 0) {
            path.add(curr);
            curr = parent[curr];
        }
        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();
        for (int x : path) {
         sb.append(x).append(" ");
     }
        System.out.println(sb);
    }
}
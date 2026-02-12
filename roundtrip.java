import java.io.*;
import java.util.*;

public class roundtrip {

    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static int[] parent;
    static List<Integer> cycle = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        visited = new boolean[n + 1];
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1)) break;
            }
        }

        if (cycle.isEmpty()) {
            System.out.println("IMPOSSIBLE");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(cycle.size()).append("\n");
            for (int node : cycle) {
                sb.append(node).append(" ");
            }
            System.out.println(sb);
        }
    }

    static boolean dfs(int u, int par) {

        visited[u] = true;
        parent[u] = par;

        for (int v : adj.get(u)) {

            if (v == par) continue;

            if (visited[v]) {

                List<Integer> temp = new ArrayList<>();
                int cur = u;

                temp.add(v);

                while (cur != v) {
                    temp.add(cur);
                    cur = parent[cur];
                }

                temp.add(v);

                Collections.reverse(temp);
                cycle = temp;

                return true;
            }

            if (dfs(v, u)) return true;
        }
        return false;
    }
}

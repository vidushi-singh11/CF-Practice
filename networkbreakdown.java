import java.io.*;
import java.util.*;

public class networkbreakdown {

    static class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n+1];
            size = new int[n+1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return false;

            if (size[pa] < size[pb]) {
                int temp = pa;
                pa = pb;
                pb = temp;
            }

            parent[pb] = pa;
            size[pa] += size[pb];
            return true;
        }
    }

    static class Edge {
        int u, v;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v);
        }

        Edge[] removed = new Edge[k];
        Set<String> removedSet = new HashSet<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            removed[i] = new Edge(u, v);

            int a = Math.min(u, v);
            int b = Math.max(u, v);
            removedSet.add(a + "#" + b);
        }

        DSU dsu = new DSU(n);
        int components = n;
        for (int i = 0; i < m; i++) {
            int u = edges[i].u;
            int v = edges[i].v;

            int a = Math.min(u, v);
            int b = Math.max(u, v);

            if (!removedSet.contains(a + "#" + b)) {
                if (dsu.union(u, v)) {
                    components--;
                }
            }
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = components;

            int u = removed[i].u;
            int v = removed[i].v;

            if (dsu.union(u, v)) {
                components--;
            }
        }

        for (int i = 0; i < k; i++) {
            out.println(ans[i]);
        }

    }
}
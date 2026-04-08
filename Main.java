import java.util.*;

public class Main {
    static List<Integer>[] adj;
    static int ans = 0;

    static void dfs(int u, int length) {
        ans = Math.max(ans, length);

        for (int v : adj[u]) {
            dfs(v, length + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x].add(y);
        }
        for (int i = 1; i <= n; i++) {
            dfs(i, 0);
        }

        System.out.println(ans);
    }
}
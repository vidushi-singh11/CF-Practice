import java.util.*;

public class Main {
    static List<Integer>[] adj;
    static int[] dp;

    static int dfs(int u) {
        if (dp[u] != -1) return dp[u];

        int maxLen = 0;

        for (int v : adj[u]) {
            maxLen = Math.max(maxLen, 1 + dfs(v));
        }

        return dp[u] = maxLen;
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

        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dfs(i));
        }

        System.out.println(ans);
    }
}
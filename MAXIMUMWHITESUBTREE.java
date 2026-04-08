import java.util.*;

public class MAXIMUMWHITESUBTREE {
    static ArrayList<Integer>[] tree;
    static int[] val;
    static int n;

    static int dfs(int node, int parent) {
        int sum = val[node];
        for (int nei : tree[node]) {
            if (nei == parent) continue;
            int child = dfs(nei, node);
            if (child > 0) sum += child;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        val = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            val[i] = (x == 1 ? 1 : -1);
        }

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            res[i] = dfs(i, 0);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

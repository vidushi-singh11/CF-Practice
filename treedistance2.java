import java.util.*;

public class treedistance2 {
    static List<Integer>[] tree;
    static int n;

    static int dfs(int node, int parent, int dist) {
        int sum = dist;
        for (int n : tree[node]) {
            if (n != parent) {
                sum += dfs(n, node, dist + 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(dfs(i, 0, 0) + " ");
        }
    }
}
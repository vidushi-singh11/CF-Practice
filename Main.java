import java.util.*;
public class Main {
    public static class DSU {
        int[] parent, size;
        DSU(int n) {
            parent = new int[n + 1];
            size = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b) {
            a = find(a);
            b = find(b);

            if (a == b) return;

            if (size[a] < size[b]) {
                parent[a] = b;
                size[b] += size[a];
            } else {
                parent[b] = a;
                size[a] += size[b];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            DSU dsu = new DSU(n);

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int d = sc.nextInt();
                int k = sc.nextInt();

                int prev = a;

                for (int j = 1; j <= k; j++) {
                    int curr = a + j * d;
                    dsu.union(prev, curr);
                    prev = curr;
                }
            }
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if (dsu.find(i) == i)
                    count++;
            }

            System.out.println(count);
        }
    }
}
import java.io.*;
import java.util.*;

public class rangeminimum {

    static int[] tree;
    static int n;

    static void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;

            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);

            tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
        }
    }

    static int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return Integer.MAX_VALUE;

        if (l <= start && end <= r) return tree[node];

        int mid = (start + end) / 2;

        int left = query(2 * node, start, mid, l, r);
        int right = query(2 * node + 1, mid + 1, end, l, r);

        return Math.min(left, right);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[4 * n];
        build(arr, 1, 0, n - 1);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;

            sb.append(query(1, 0, n - 1, l, r)).append("\n");
        }

        System.out.print(sb);
    }
}
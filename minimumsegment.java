import java.io.*;
import java.util.*;

public class minimumsegment {

    static class Node {
        int min, count;

        Node(int min, int count) {
            this.min = min;
            this.count = count;
        }
    }

    static Node[] tree;
    static int[] arr;
    static int n;
    static Node merge(Node left, Node right) {
        if (left.min < right.min) return left;
        if (right.min < left.min) return right;
        return new Node(left.min, left.count + right.count);
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(arr[start], 1);
        } else {
            int mid = (start + end) / 2;
            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);
            tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
        }
    }

    static void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = new Node(val, 1);
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid)
                update(2 * node, start, mid, idx, val);
            else
                update(2 * node + 1, mid + 1, end, idx, val);

            tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
        }
    }

    // Query
    static Node query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return new Node(Integer.MAX_VALUE, 0);
        }

        if (l <= start && end <= r) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        Node left = query(2 * node, start, mid, l, r);
        Node right = query(2 * node + 1, mid + 1, end, l, r);

        return merge(left, right);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        tree = new Node[4 * n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        build(1, 0, n - 1);

        StringBuilder sb = new StringBuilder();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int i = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                update(1, 0, n - 1, i, v);
            } else {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                Node res = query(1, 0, n - 1, l, r - 1);
                sb.append(res.min).append(" ").append(res.count).append("\n");
            }
        }

        System.out.print(sb);
    }
}
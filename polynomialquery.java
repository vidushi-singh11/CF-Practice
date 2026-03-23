import java.io.*;
import java.util.*;

public class polynomialquery {
    static int n, q;
    static long[] seg, lazyA, lazyD;

    static void build(long[] arr, int node, int l, int r) {
        if (l == r) {
            seg[node] = arr[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(arr, node << 1, l, mid);
        build(arr, node << 1 | 1, mid + 1, r);
        seg[node] = seg[node << 1] + seg[node << 1 | 1];
    }

    static void apply(int node, int l, int r, long A, long D) {
        long len = r - l + 1;
        seg[node] += A * len + D * (len * (len - 1) / 2);
        lazyA[node] += A;
        lazyD[node] += D;
    }

    static void update(int node, int l, int r, int ql, int qr) {
        if (r < ql || l > qr) return;

        if (ql <= l && r <= qr) {
            apply(node, l, r, l - ql + 1, 1);
            return;
        }

        if (lazyA[node] != 0 || lazyD[node] != 0) {
            int mid = (l + r) >> 1;

            apply(node << 1, l, mid, lazyA[node], lazyD[node]);
            apply(node << 1 | 1, mid + 1, r,
                    lazyA[node] + lazyD[node] * (mid - l + 1L),
                    lazyD[node]);

            lazyA[node] = 0;
            lazyD[node] = 0;
        }

        int mid = (l + r) >> 1;
        update(node << 1, l, mid, ql, qr);
        update(node << 1 | 1, mid + 1, r, ql, qr);

        seg[node] = seg[node << 1] + seg[node << 1 | 1];
    }

    static long query(int node, int l, int r, int ql, int qr) {
        if (r < ql || l > qr) return 0;

        if (ql <= l && r <= qr) return seg[node];

        if (lazyA[node] != 0 || lazyD[node] != 0) {
            int mid = (l + r) >> 1;

            apply(node << 1, l, mid, lazyA[node], lazyD[node]);
            apply(node << 1 | 1, mid + 1, r,
                    lazyA[node] + lazyD[node] * (mid - l + 1L),
                    lazyD[node]);

            lazyA[node] = 0;
            lazyD[node] = 0;
        }

        int mid = (l + r) >> 1;
        return query(node << 1, l, mid, ql, qr)
             + query(node << 1 | 1, mid + 1, r, ql, qr);
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            while ((c = read()) <= ' ') ;
            if (c == '-') {
                s = -1;
                c = read();
            }
            while (c > ' ') {
                x = x * 10 + c - '0';
                c = read();
            }
            return x * s;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        n = fs.nextInt();
        q = fs.nextInt();

        long[] arr = new long[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = fs.nextInt();

        seg = new long[4 * n];
        lazyA = new long[4 * n];
        lazyD = new long[4 * n];

        build(arr, 1, 1, n);

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            int type = fs.nextInt();
            int l = fs.nextInt();
            int r = fs.nextInt();

            if (type == 1) update(1, 1, n, l, r);
            else sb.append(query(1, 1, n, l, r)).append('\n');
        }

        System.out.print(sb);
    }
}
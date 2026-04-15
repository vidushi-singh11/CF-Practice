import java.io.*;
import java.util.*;
 
public class minimumsegment {
 
    static class Pair {
        int min, count;
 
        Pair(int min, int count) {
            this.min = min;
            this.count = count;
        }
    }
 
    static Pair[] st;
    static int n;
    static Pair combine(Pair x, Pair y) {
        if (x.min < y.min) return x;
        if (y.min < x.min) return y;
        return new Pair(x.min, x.count + y.count);
    }
    static void build(int i, int l, int r, int[] arr) {
        if (l == r) {
            st[i] = new Pair(arr[l], 1);
            return;
        }
 
        int mid = (l + r) / 2;
        build(2 * i + 1, l, mid, arr);
        build(2 * i + 2, mid + 1, r, arr);
 
        st[i] = combine(st[2 * i + 1], st[2 * i + 2]);
    }
    static void update(int index, int value, int start, int end, int pos) {
        if (start == end) {
            st[pos] = new Pair(value, 1);
            return;
        }
 
        int mid = (start + end) / 2;
 
        if (index <= mid)
            update(index, value, start, mid, 2 * pos + 1);
        else
            update(index, value, mid + 1, end, 2 * pos + 2);
 
        st[pos] = combine(st[2 * pos + 1], st[2 * pos + 2]);
    }
    static Pair query(int l, int r, int i, int sl, int sr) {
        if (sl > r || sr < l) {
            return new Pair(Integer.MAX_VALUE, 0);
        }
 
        if (sl >= l && sr <= r) {
            return st[i];
        }
 
        int mid = (sl + sr) / 2;
 
        Pair left = query(l, r, 2 * i + 1, sl, mid);
        Pair right = query(l, r, 2 * i + 2, mid + 1, sr);
 
        return combine(left, right);
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine());
 
        n = Integer.parseInt(stt.nextToken());
        int q = Integer.parseInt(stt.nextToken());
 
        int[] arr = new int[n];
        st = new Pair[4 * n];
 
        stt = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stt.nextToken());
        }
 
        build(0, 0, n - 1, arr);
 
        StringBuilder sb = new StringBuilder();
 
        while (q-- > 0) {
            stt = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(stt.nextToken());
            int a = Integer.parseInt(stt.nextToken());
            int b = Integer.parseInt(stt.nextToken());
 
            if (type == 1) {
                update(a, b, 0, n - 1, 0);
            } else {
                Pair res = query(a, b - 1, 0, 0, n - 1);
                sb.append(res.min).append(" ").append(res.count).append("\n");
            }
        }
 
        System.out.print(sb);
    }
}
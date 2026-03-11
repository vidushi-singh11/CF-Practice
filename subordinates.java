import java.util.*;
import java.io.*;   
public class subordinates {
    static int [] SubOrdinates ;
    static ArrayList<ArrayList<Integer>> adj ;
    public static void dfs(int node){
        for(int j : adj.get(node)){
            dfs(j);
            SubOrdinates[node] += SubOrdinates[j] + 1;
        }
    }
    public static void main(String[] args) throws Exception {
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        SubOrdinates = new int[n+1];
        adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 2;i<=n;i++){
            int node = reader.nextInt();
            adj.get(node).add(i);
        }
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=n;i++){
            sb.append(SubOrdinates[i]).append(" ");
        }
        System.out.println(sb);
    }
    static class FastReader {
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
            int c;
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = c - '0';
            while ((c = read()) > ' ')
                val = val * 10 + c - '0';
            return val * sign;
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = c - '0';
            while ((c = read()) > ' ')
                val = val * 10 + c - '0';
            return val * sign;
        }
    }
}
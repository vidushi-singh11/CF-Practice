import java.io.*;
import java.util.*;

public class buildingteams {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {

        FastReader sc = new FastReader();

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] teams = new int[n + 1];
        Arrays.fill(teams, -1);

        boolean ans = true;

        for (int i = 1; i <= n; i++) {
            if (teams[i] == -1) {

                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                teams[i] = 0;

                while (!q.isEmpty()) {

                    int u = q.poll();

                    for (int v : adjList.get(u)) {

                        if (teams[v] == -1) {
                            teams[v] = 1 - teams[u];
                            q.add(v);
                        } 
                        else if (teams[v] == teams[u]) {
                            ans = false;
                            break;
                        }
                    }

                    if (!ans) break; 
                }
            }

            if (!ans) break;  
        }

        if (!ans) {
            System.out.println("IMPOSSIBLE");
        } else {
            StringBuilder sb = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                sb.append(teams[i] + 1).append(" ");
            }
            System.out.println(sb);

        }
    }
}

import java.io.*;
import java.util.*;

public class companyqueries {

    static int LOG = 20;
    static int[][] parent;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PrintWriter out = new PrintWriter(System.out);

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        parent = new int[n + 1][LOG];

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            parent[i][0] = Integer.parseInt(st.nextToken());
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                parent[i][j] = parent[parent[i][j - 1]][j - 1];
            }
        }

        while (q-- > 0) {

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < LOG; j++) {
                if ((k & (1 << j)) != 0) {
                    x = parent[x][j];
                    if (x == 0) break;
                }
            }

            if (x == 0) out.println(-1);
            else out.println(x);
        }

        out.flush();
    }
}
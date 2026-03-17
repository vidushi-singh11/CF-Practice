import java.util.*;
public class distancequeries {
    int LOG = 20;
    int n;
    int[][] parent;
    public distancequeries(int n) {
        this.n = n;
        parent = new int[n + 1][LOG];
    }
    public void addEdge(int u, int v) {
        parent[v][0] = u;
    }
    public void fxn() {
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                parent[i][j]=
            }
        }
    }
}

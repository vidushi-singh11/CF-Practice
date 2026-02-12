import java.io.*;
import java.util.*;

public class courseschedule {

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
    }

    public static void main(String[] args) throws Exception {

        FastReader sc = new FastReader();

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();  
        int[] indegree = new int[n+1];

        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

       
        for (int i=1; i<=n;i++){
            if(indegree[i]==0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int u = q.poll();
            ans.add(u);
            for(int v: adjList.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }

        if(ans.size()!=n){
            System.out.println("IMPOSSIBLE");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int x: ans){
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
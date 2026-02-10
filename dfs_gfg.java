import java.util.*;
public class dfs_gfg {
  static  ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        int V= sc.nextInt();
        int E=sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < V; i++){
        adjList.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u=sc.nextInt();
            int v =sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean [] visited = new boolean[V];
        
        fxn(0,adjList, visited);
        System.out.println(ans);
    }
private static void fxn(int node, ArrayList<ArrayList<Integer>> adjList , boolean[] visited){
    visited[node] =true;
    ans.add(node);
    for(int u : adjList.get(node)){
        if(visited[u]==false){
            visited[u]= true;
            fxn(u, adjList, visited);
        }
    }
}
}

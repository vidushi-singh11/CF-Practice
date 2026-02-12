import java.util.*;
public class message_route {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();
    int m = sc.nextInt();
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    for(int i = 0; i<=n; i++){ 
        adjList.add(new ArrayList<>());
    }
    for(int i=0;i<m;i++){
        int u=sc.nextInt();
        int v =sc.nextInt();
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    bfs(1, n, adjList);
   } 
    static void bfs(int start, int n, ArrayList<ArrayList<Integer>> adjList) {
     boolean[] visited = new boolean[n + 1];
     int[] parent = new int[n + 1];
     Arrays.fill(parent, -1);
     Queue<Integer> queue = new LinkedList<>();
     queue.add(start);
     visited[start] = true;
     while (!queue.isEmpty()) {
          int node = queue.poll();
          for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                 visited[neighbor] = true;
                 parent[neighbor] = node;
                 queue.add(neighbor);
                }
          }
     }
     if (!visited[n]) {
          System.out.println("IMPOSSIBLE");
          return;
     }
     List<Integer> path = new ArrayList<>();
     for (int v = n; v != -1; v = parent[v]) {
          path.add(v);
     }
     Collections.reverse(path);
     System.out.println(path.size());
     for (int node : path) {
          System.out.print(node + " ");
     }
    }
}

import java.lang.reflect.Array;
import java.util.*;
public class toposort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V= sc.nextInt();
        int E =sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[V+1];
        for(int i=0;i<=V;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=1;i<=E;i++){
            int u= sc.nextInt();
            int v= sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<=V;i++){
            if (indegree[i]==0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            ans.add(u);
            for(int v: adjList.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    queue.add(v);
                }
            }
        }
        System.out.println(ans);
    }
}


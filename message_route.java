import java.util.*;
public class message_route {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n= sc.nextInt();
    int m = sc.nextInt();
    ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    for(int i = 0; i< n; i++){ 
        adjList.add(new ArrayList<>());
    }
    for(int i=0;i<m;i++){
        int u=sc.nextInt()-1;
        int v =sc.nextInt()-1;
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }
    System.out.println(adjList);
   } 
}

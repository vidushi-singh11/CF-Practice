import java.util.*;
public class knightmoves_spoj {
   
    static class Pair {
        int x, y, dist;
        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int t= sc.nextInt();
        while (t-->0) {
             String start = sc.next();
            String end = sc.next();
            int sx = start.charAt(0) - 'a';
            int sy = start.charAt(1) - '1';
            int ex = end.charAt(0) - 'a';
            int ey = end.charAt(1) - '1';
            System.out.println(minMoves(sx, sy, ex, ey));
            
        }
    
    }
    static int minMoves(int sx, int sy, int ex, int ey) {
     int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
     int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};
        boolean[][] visited = new boolean[8][8];
        Queue<Pair>queue = new LinkedList<>();
        queue.add(new Pair(sx, sy, 0));
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (p.x == ex && p.y == ey) {
                return p.dist;
            }
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny, p.dist + 1));
                }
            }
        }
        return -1;
    }
}
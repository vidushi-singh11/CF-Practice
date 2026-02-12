
import java.util.*;
public class practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   
        int m = sc.nextInt();
        char[][] grid = new char[n][m]; 
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
            }
            int sx = sc.nextInt();
            int sy = sc.nextInt();  
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            List<Character> path = new ArrayList<>();
            if (backtrack(grid, sx, sy, ex, ey, path)) {
                for (char move : path) {
                    System.out.print(move + " ");
                }
            } 
            else {
                System.out.println("No path found");
            }
        }
    }
    static boolean backtrack(char[][] grid, int x, int y, int ex, int ey, List<Character> path) {
        if (x == ex && y == ey) {
            return true;
        }
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '#') {
            return false;
        }
        char move = grid[x][y];
        grid[x][y] = '#'; 
        int newX = x, newY = y;
        switch (move) {
            case 'L': newY = y - 1; break;
            case 'R': newY = y + 1; break;
            case 'U': newX = x - 1; break;
            case 'D': newX = x + 1; break;
        }
        path.add(move);
        if (backtrack(grid, newX, newY, ex, ey, path)) {
            return true;
        }
        path.remove(path.size() - 1); 
        grid[x][y] = move; 
        return false;
    }
}
    
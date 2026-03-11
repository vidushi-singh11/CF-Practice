import java.util.*;
public class gridpath1{
    static final int MOD = 1_000_000_007;
    static int dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
         sc.nextLine();  
        char[][] grid = new char[n][n];
            dp = new int[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(dp[i], -1);
            }
        for(int i=0;i<n;i++){
           String row = sc.nextLine();
           for(int j=0;j<n;j++){
            grid[i][j]= row.charAt(j);
           }
        }
        int path = fxn(grid, 0,0,n);
        System.out.println(path);
    }
    public static int fxn (char[][] grid, int i, int j,int n){
         if (i>=n || j>= n){
            return 0;
        }
        if(grid[i][j] == '*'){ 
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i==n-1 && j==n-1){
            return 1;
        }
         
        int right=0;
        int down=0;
            right = fxn(grid, i, j+1, n);
            down = fxn(grid, i+1, j, n);

        dp[i][j] = (right+down)%MOD;
        return dp[i][j];
    }
}

    

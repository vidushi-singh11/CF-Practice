import java.util.*;

class Main {

    static final int MOD = 1000000007;
    static int H, W;
    static char[][] grid;
    static int[][] dp;

    static int solve(int i, int j) {

        if (i >= H || j >= W)
            return 0;

        if (grid[i][j] == '#')
            return 0;

        if (i == H - 1 && j == W - 1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int right = solve(i, j + 1);
        int down = solve(i + 1, j);

        dp[i][j] = (right + down) % MOD;

        return dp[i][j];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        H = sc.nextInt();
        W = sc.nextInt();

        grid = new char[H][W];

        for (int i = 0; i < H; i++) {
            String s = sc.next();

            for (int j = 0; j < W; j++) {
                grid[i][j] = s.charAt(j);
            }
        }

        dp = new int[H][W];

        for (int i = 0; i < H; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(0, 0));
    }
}
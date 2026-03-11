import java.util.*;

public class VacationAtCoder {
    static int n;
    static int[][]arr;
    static int dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][3];
        dp = new int[n][4];
        for (int i = 0; i < n; i++) {
             Arrays.fill(dp[i], -1);
            }
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        int result = fxn(0, -1);
        System.out.println(result);

    }
    public static int fxn( int day,int task){
        if (day==n) {
            return 0;
        }
        if (dp[day][task+1]!=-1) {
            return dp[day][task+1];
        }
        int max=0;
        if(task!=0){
            max = Math.max(max, arr[day][0]+fxn(day+1, 0));
        }
        if(task!=1){
            max = Math.max(max, arr[day][1]+fxn(day+1, 1));
        }
        if(task!=2){
            max = Math.max(max, arr[day][2]+fxn(day+1, 2));
        }
        dp[day][task+1]=max;
        return max;
    }
}

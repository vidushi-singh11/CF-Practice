import java.util.*;
public class elevatorOrStair {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int c= sc.nextInt();
        int [] a = new int[n];
        int [] b = new int [n];
        for(int i=1;i<n;i++){
            a[i]= sc.nextInt();
        }
        for(int i=1;i<n;i++){
            b[i]= sc.nextInt();
        }
        int [] dp = new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            dp[i]= Math.min(dp[i-1]+a[i],dp[i-1]+b[i]+c);
        }
        System.out.println(dp[n-1]);
        
       }

}

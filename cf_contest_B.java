import java.util.*;

public class cf_contest_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int[] a = new int[7];
            int sum = 0;
            int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < 7; i++) {
                a[i] = sc.nextInt();
                sum += a[i];
                max = Math.max(max, a[i]);
            }
            
            int ans = 2 * max - sum;
            System.out.println(ans);
        }
        
        sc.close();
    }
}
import java.util.*;

public class cf_contest_c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int left = 1;
            int right = 3 * n;
            
            for (int i = 0; i < n; i++) {
                System.out.print(left + " ");        // small
                System.out.print(right - 1 + " ");   // median (large)
                System.out.print(right + " ");       // largest
                
                left++;
                right -= 2;
            }
            System.out.println();
        }
        
        sc.close();
    }
}
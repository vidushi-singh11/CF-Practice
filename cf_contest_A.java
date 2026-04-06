import java.util.*;

public class cf_contest_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            
            if (x < 67) {
                System.out.println(x + 1);
            } else {
                System.out.println(67);
            }
        }
        
        sc.close();
    }
}
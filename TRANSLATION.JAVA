import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        int n = s.length();
        boolean ok = true;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) != t.charAt(n - i - 1)) {
                ok = false;
                break;
            }
        }

        if(ok) System.out.println("YES");
        else System.out.println("NO");
    }
}
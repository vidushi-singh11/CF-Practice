import java.util.*;

public class missingnumbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long total = n * (n + 1) / 2;

        long sum = 0;

        for (int i = 0; i < n - 1; i++) {
            sum += sc.nextLong();
        }

        System.out.println(total - sum);
    }
}
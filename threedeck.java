import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();

            long total = a + b + c;

            if (total % 3 != 0) {
                System.out.println("NO");
            } else {
                long each = total / 3;
                if (each >= b)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }

            t--;
        }

        sc.close();
    }
}

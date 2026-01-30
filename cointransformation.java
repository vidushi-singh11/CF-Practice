import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t > 0) {
            long n = sc.nextLong();
            long coins = 1;

            while (n >= 4) {
                n = n / 4;
                coins = coins * 2;
            }

            System.out.println(coins);
            t = t - 1;
        }

        sc.close();
    }
}

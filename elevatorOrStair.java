import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long c = sc.nextLong();

        long[] a = new long[n - 1];
        long[] b = new long[n - 1];

        for (int i = 0; i < n - 1; i++) {
            a[i] = sc.nextLong();
        }

        for (int i = 0; i < n - 1; i++) {
            b[i] = sc.nextLong();
        }

        long[] dpS = new long[n];
        long[] dpE = new long[n];

        dpS[0] = 0;
        dpE[0] = c;

        System.out.print(0 + " ");

        for (int i = 0; i < n - 1; i++) {

            dpS[i + 1] = Math.min(dpS[i], dpE[i]) + a[i];

            dpE[i + 1] = Math.min(
                    dpE[i] + b[i],
                    dpS[i] + c + b[i]
            );

            System.out.print(Math.min(dpS[i + 1], dpE[i + 1]) + " ");
        }
    }
}
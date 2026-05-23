import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class distnictnumbers {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Long> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            long x = Long.parseLong(st.nextToken());
            set.add(x);
        }

        System.out.println(set.size());
    }
}
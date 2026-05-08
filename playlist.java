import java.util.*;

public class playlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] songs = new int[n];

        for (int i = 0; i < n; i++) {
            songs[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {

            while (set.contains(songs[right])) {
                set.remove(songs[left]);
                left++;
            }

            set.add(songs[right]);

            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
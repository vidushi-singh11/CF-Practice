import java.util.*;
public class increasingarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        long arr[] = new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        int left =0;
        int right =1;
        long moves =0;
        for(int i=0;i<n-1;i++){
            if(arr[right]<arr[left]){
                moves = moves+( arr[left]-arr[right]);
                arr[right]=arr[left];
            }
            right++;
            left++;
        }
        System.out.println(moves);

    }
}

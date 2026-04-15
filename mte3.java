public class mte3 {
    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int left = 0;
        int right = arr.length - 1;

        boolean found = false;

        while(left < right) {

            int sum = arr[left] + arr[right];

            if(sum == target) {
                System.out.println("Indexes = " + left + ", " + right);
                found = true;
                break;
            }
            else if(sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        if(found == false) {
            System.out.println(-1);
        }
    }
}
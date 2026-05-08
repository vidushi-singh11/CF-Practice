
public class mte4 {
    public static void main(String[] args) {

        int[] arr = {2,2,1,1,1,2,2};

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.get(num) > arr.length / 2) {
                System.out.println(num);
                return;
            }
        }

        System.out.println(-1);
    }
}
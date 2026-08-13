public class problem01 {
    public int prefixSum(int[] arr, int L, int R) {

        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
            System.out.println("Prefix sum at index " + i + " is: " + prefix[i]);
        }

        if(L == 0) {
            return prefix[R];
        } else {
            return prefix[R] - prefix[L - 1];//  Ans = prefix[R] - prefix[L] + arr[L]
        }
    }

    public static void main(String[] args) {

        problem01 p = new problem01();
        int[] arr = {10, 5, 20, 25};
        int result = p.prefixSum(arr, 1, 3);
        
        System.out.println("The prefix sum is: " + result);

    }
}

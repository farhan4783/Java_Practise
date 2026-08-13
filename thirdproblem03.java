// sliding window problem


public class thirdproblem03 {

    public int slidingWindow(int[] arr, int K) {

        int maxSum;
        int windowSum = 0;

        for (int i = 0; i < K; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        for (int i = K; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - K];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
       
    }

    public static void main(String[] args) {

        thirdproblem03 t = new thirdproblem03();
        int[] arr = {10, 5, 20, 25};
        int result = t.slidingWindow(arr, 3);
        
        System.out.println("The sliding window's Maximum sum is: " + result);

    }
    
}

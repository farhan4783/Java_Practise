public class sufic {
    public int sufix(int[] arr, int L, int R) {

        int sufix[] = new int[arr.length];
        sufix[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            sufix[i] = sufix[i + 1] + arr[i];
            System.out.println("Sufix sum at index " + i + " is: " + sufix[i]);
        }

        if(R == arr.length - 1) {
            return sufix[L];
        } else {
            return sufix[L] - sufix[R + 1];//  Ans = sufix[L] - sufix[R] + arr[R]
        }
    }
    public static void main(String[] args) {

        sufic s = new sufic();
        int[] arr = {10, 5, 20, 25};
        int result = s.sufix(arr, 1, 3);
        
        System.out.println("The sufix sum is: " + result);

    }
}

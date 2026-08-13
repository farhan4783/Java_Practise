import java.util.Scanner;

public class fact {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    // find factorial of a number 
        System.out.print("Enter a number to find its factorial: ");
        int num = sc.nextInt();
        int factorial = 1;
        for (int j = 1; j <= num; j++) {
            factorial *= j;
        }
        System.out.println("Factorial of " + num + " is: " + factorial);
    }    
}

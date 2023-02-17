import java.util.Scanner;

public class ArrayReducer {

    // Method to compute the reduced form of an input array
    public static int[] reduceArray(int[] arr) {
        int n = arr.length;
        
        // Create a copy of the array to avoid modifying the original array
        int[] arrCopy = new int[n];
        for (int i = 0; i < n; i++) {
            arrCopy[i] = arr[i];
        }
        
        // Sorted the copy using bubble sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arrCopy[j] > arrCopy[j+1]) {
                    int temp = arrCopy[j];
                    arrCopy[j] = arrCopy[j+1];
                    arrCopy[j+1] = temp;
                }
            }
        }

        // Create the reduced form of the input array
        int[] reducedArr = new int[n];
        for (int i = 0; i < n; i++) {
            int index = 0;
            while (arr[i] != arrCopy[index]) {
                index++;
            }
            reducedArr[i] = index;
        }
        return reducedArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] reducedArr = reduceArray(arr);
        System.out.println("Reduced form of the array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(reducedArr[i] + " ");
        }
    }
}

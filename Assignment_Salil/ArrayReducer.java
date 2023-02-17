import java.util.Scanner;

public class ArrayReducer {

    // Method to compute the reduced form of an input array
    public static int[] reduceArray(int[] inputArr) {
        int arrayLength = inputArr.length;
        
        // Create a copy of the array to avoid modifying the original array
        int[] inputArrCopy = new int[arrayLength];
        for (int inputIndex = 0; inputIndex < arrayLength; inputIndex++) {
            inputArrCopy[inputIndex] = inputArr[inputIndex];
        }
        
        // Sorted the copy using bubble sort
        for (int outerIndex = 0; outerIndex < arrayLength - 1; outerIndex++) {
            for (int innerIndex = 0; innerIndex < arrayLength - outerIndex - 1; innerIndex++) {
                if (inputArrCopy[innerIndex] > inputArrCopy[innerIndex+1]) {
                    int temp = inputArrCopy[innerIndex];
                    inputArrCopy[innerIndex] = inputArrCopy[innerIndex+1];
                    inputArrCopy[innerIndex+1] = temp;
                }
            }
        }

        // Create the reduced form of the input array
        int[] reducedArr = new int[arrayLength];
        for (int reducedIndex = 0; reducedIndex < arrayLength; reducedIndex++) {
            int index = 0;
            while (inputArr[reducedIndex] != inputArrCopy[index]) {
                index++;
            }
            reducedArr[reducedIndex] = index;
        }
        return reducedArr;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int inputVar = userInput.nextInt();
        int[] arr = new int[inputVar];
        System.out.println("Enter the elements of the array:");
        for (int elementIndex = 0; elementIndex < inputVar; elementIndex++) {
            arr[elementIndex] = userInput.nextInt();
        }
        
        int[] reducedArr = reduceArray(arr);
        System.out.println("Reduced form of the array: ");
        for (int reducedElementIndex = 0; reducedElementIndex < inputVar; reducedElementIndex++) {
            System.out.print(reducedArr[reducedElementIndex] + " ");
        }
    }
}


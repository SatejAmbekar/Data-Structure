public class Main {
    public static void main(String[] args) {
        int [] arr = {40, 30, 12, 9, 5, 19, 80, 60, 23, 45, 39};

        /*int passes = Util.bubbleSort(arr);
        System.out.println("Passes: " + passes);*/
        // Util.selectionSort(arr);
        //Util.insertionSort(arr);
        //Util.quickSort(arr, 0, arr.length-1);
        //Util.mergeSort(arr, 0, arr.length - 1);
        Util.heapSort(arr, arr.length);

        for(int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}

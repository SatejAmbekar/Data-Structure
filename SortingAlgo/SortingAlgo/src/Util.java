public class Util {

    public static int bubbleSort(int [] arr) {
        int passes = arr.length - 1;
        int comps = arr.length - 1;

        for(int i = 0; i < passes; i++) {

            int count = 0;

            for(int j = 0; j < (comps - i); j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    count++;
                }
            }

            if(count == 0) {
                return i+1;
            }

        }

        return arr.length - 1;

    }

    public static void selectionSort(int [] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for(int j = min+1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

        }
    }

    public static void insertionSort(int [] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void quickSort(int [] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        int pivotLocation = partition(arr, left, right);
        quickSort(arr, left, pivotLocation - 1);
        quickSort(arr, pivotLocation + 1, right);
    }

    private static int partition(int [] arr, int left, int right) {
        int pivot = arr[left];

        while(left < right) {
            while (arr[right] > pivot && left < right) {
                right--;
            }
            if(left < right) {
                arr[left] = arr[right];
                left++;
            }

            while (arr[left] < pivot && left < right) {
                left++;
            }
            if(left < right) {
                arr[right] = arr[left];
                right--;
            }
        }

        arr[left] = pivot;
        return right;
    }

    public static void mergeSort(int [] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, mid+1, right);
    }

    private static void merge(int [] arr, int leftStart, int leftEnd, int rightStart, int rightEnd) {

        int numElements = rightEnd - leftStart + 1;
        int [] newArr = new int[numElements];
        int tempPosition = -1; //index into the new array

        while((leftStart <= leftEnd) && (rightStart <= rightEnd)) {
            if(arr[leftStart] < arr[rightStart]) {
                newArr[++tempPosition] = arr[leftStart];
                leftStart++;
            }
            else {
                newArr[++tempPosition] = arr[rightStart];
                rightStart++;
            }
        }

        while(leftStart <= leftEnd) {
            newArr[++tempPosition] = arr[leftStart];
            leftStart++;
        }

        while(rightStart <= rightEnd) {
            newArr[++tempPosition] = arr[rightStart];
            rightStart++;
        }

        while(numElements > 0) {
            arr[rightEnd] = newArr[tempPosition];
            rightEnd--;
            tempPosition--;
            numElements--;
        }

    }

    /*private static void merge(int [] arr, int leftStart, int leftEnd, int rightStart, int rightEnd) {

        while(both arrays have elements){
            if (arr[leftStart] < arr[rightStart]) {
                copy left start ele to new array
            } else {
                copy right start ele to new array
            }
        }

        if(left array still has elements) {
            copy remaining elements of left array to new arrary
        }

        if(right array still has elements) {
            copy remaining elements to new array
        }

        copy the new array to the actual array
    }*/

    public static void heapSort(int [] arr, int len) {

        if(len <= 1) {
            return;
        }

        for(int i = len - 1; i > 0; i--) {
            if(arr[i] > arr[(i-1)/2]) {
                int temp = arr[i];
                arr[i] = arr[(i-1)/2];
                arr[(i-1)/2] = temp;
            }
        }

        int temp = arr[0];
        arr[0] = arr[len-1];
        arr[len-1] = temp;

        heapSort(arr, len-1);

    }
}









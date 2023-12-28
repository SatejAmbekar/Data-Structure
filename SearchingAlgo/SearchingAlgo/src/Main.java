public class Main {
    public static void main(String[] args) {

        int [] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        System.out.println("key: 10: " + Util.binarySearch(arr, 10));
        System.out.println("key: 50: " + Util.binarySearch(arr, 50));
        System.out.println("key: 80: " + Util.binarySearch(arr, 80));
        System.out.println("key: 100: " + Util.binarySearch(arr, 100));
        System.out.println("key: 110: " + Util.binarySearch(arr, 110));
        System.out.println();

        System.out.println("key: 10: " + Util.binarySearch(arr, 0, arr.length-1, 10));
        System.out.println("key: 50: " + Util.binarySearch(arr, 0, arr.length-1, 50));
        System.out.println("key: 80: " + Util.binarySearch(arr, 0, arr.length-1,80));
        System.out.println("key: 100: " + Util.binarySearch(arr, 0, arr.length-1,100));
        System.out.println("key: 110: " + Util.binarySearch(arr, 0, arr.length-1,110));

    }
}

class Util {
    public static int binarySearch(int [] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }

            if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int binarySearch(int [] arr, int low, int high, int key) {
        if(low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if(arr[mid] == key) {
            return mid;
        }

        if(key < arr[mid]) {
            return binarySearch(arr, low, mid-1, key);
        }
        else {
            return binarySearch(arr, mid+1, high, key);
        }
    }
}










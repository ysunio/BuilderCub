package One;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(bSearch(new int[]{1,2,3,4,5,12,20,30}, 30));
    }

    public static boolean bSearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            System.out.println(start+" "+end+" "+mid);
            if(arr[mid] == target) return true;

            if(arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return false;
    }
}

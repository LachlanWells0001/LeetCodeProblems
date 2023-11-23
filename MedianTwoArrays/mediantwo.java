public class mediantwo {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;
        int x = n + m;
        int[] mergedArray = new int[x];

        int i = 0, j = 0, k = 0;

        while (i < n || j < m){
            //If num1 not empty and num1 smaller or num 2 empty
            if (i < n && (j == m || nums1[i] <= nums2[j])) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }    
        }

        int medIdx = (x - 1) / 2;

        if ((x & 1) == 0) {
            return (mergedArray[medIdx] + mergedArray[medIdx + 1]) / 2.0;
        } else {
            return (double) mergedArray[medIdx];
        }
    }

    public static void main(String[] args){
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}

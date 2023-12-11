package interviews;

public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        //int[] a = new int[] {10, 1, 4, 6, 7};
        //int[] a = new int[] {4, 5 , 6, 1};
        int[] a = new int[] { 1, 4, 6, 7, 10};
        int e  = 1;
        System.out.println(search(a, e));
    }
    private static int search(int[] a, int e) {
        int length = a.length;
        if (length == 0) throw new IllegalArgumentException("Array is Empty");
        int l = 0;
        int h = length - 1;
        while (l <= h) {
            int m = l +(h-l)/2;
            if (a[m] == e) return m;
            if ((a[l] <= a[m])) {
                if ((e >= a[l] && e <a[m])) {
                   h = m -1;
                } else {
                    l = m + 1;
                }
            } else {
                if ((e > a[m] && e <= a[h])) {
                    l = m + 1;
                } else {
                    h = m -1;
                }
            }
        }
        return -1;
    }
}

import java.util.List;

public class Median_of_Two_Sorted_Arrays_0004 {
    /**
     * O(n)= log(m+n)
     * @param args
     */
    public static void main(String[] args) {
        int[] arrayA = {1,3,6,9,14,26,89,99,102,107};
        int[] arrayB = {2,4,7,9,10,23,25,26,32};
        int median = findMedian(arrayA,arrayB);
        System.out.println(median);
    }
    public static Integer findMedian(int[] a, int[] b){
        if(a.length == 0){
            System.out.println(b);
            return -1;
        }
        if(b.length == 0){
            System.out.println(a);
            return -1;
        }
        // 假设初始切分位置在中间
        // 切分位置A
        int pozA = a.length / 2 - 1;
        // 切分位置B
        int pozB = a.length / 2 - 1;
    }
}

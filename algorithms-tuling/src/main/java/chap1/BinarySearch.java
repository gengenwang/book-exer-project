package chap1;

import java.util.Arrays;

/**
 * <p>二分查找</p>
 *
 * @author gengen.wang
 * @version $$ Id: BinarySearch.java, V 0.1 2018/5/28 下午3:50 wanggengen Exp $$
 **/
public class BinarySearch {

    public static int rank(int key, int[] a){
        if (a != null){
            //数组必须是有序的
            Arrays.sort(a);
            int lo = 0;
            int hi = a.length - 1;
            while (lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if (key < a[mid]){
                    hi = mid - 1;
                } else if (key > a[mid]){
                    lo = mid + 1;
                } else {
                    return mid;
                }
            }
        } else {
            throw new RuntimeException("数组不能为空");
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {12,45,89,34,50};
        System.out.println(rank(45,array));
    }



}

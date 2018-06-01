package chap2;

import org.junit.Test;

/**
 * <p>选择排序</p>
 *
 * @author gengen.wang
 * @version $$ Id: Selection.java, V 0.1 2018/6/1 下午2:38 wanggengen Exp $$
 **/
public class Selection extends SortTemplate{

    /**
     * 首先，找到数组中最小的那个元素
     * 其次，将它和数组中的第一个元素交换位置（如果第一个元素就是最小元素那么它和自己交换）
     * 再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序
     *
     * 选择排序：因为它在不断的选择剩余元素之中的最小者
     * @param a
     */
    public void sort(Comparable[] a){
        //将a[]升序排列
        int N = a.length;
        for (int i = 0; i < N; i++){
            //将a[i]和a[i+1..N]中最小的元素交换
            int minIndex = i;
            for (int j = i + 1; j < N; j++){
                if (less(a[j],a[minIndex])) {
                    minIndex = j;
                }
            }
            exch(a,i,minIndex);
        }
    }


    @Test
    public void test(){
        String[] arr = {"4","7","2","8"};
        sort(arr);
        show(arr);
    }

}

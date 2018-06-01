package chap2;

import org.junit.Test;

/**
 * <p>插入排序</p>
 *
 * @author gengen.wang
 * @version $$ Id: Insertion.java, V 0.1 2018/6/1 下午3:17 wanggengen Exp $$
 **/
public class Insertion extends SortTemplate {

    /**
     * 对于0到N-1之间的每一个i，将a[i]与a[0]到a[i-1]中比它小的所有元素一次有序地交换
     * 在索引i由左向右变化的过程中，他左侧的元素总是有序的，所以当i到达数组的右侧时排序就完成了
     * @param a
     */
    public void sort(Comparable[] a) {
        //将a[]按升序排列
        int N = a.length;
        for (int i = 1; i < N; i++) {
            //将a[i],插入到a[i - 1]、a[i - 2]...之中
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    @Test
    public void test() {
        String[] arr = {"4", "7", "2", "8"};
        sort(arr);
        show(arr);
    }
}

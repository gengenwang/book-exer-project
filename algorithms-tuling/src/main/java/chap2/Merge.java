package chap2;

import org.junit.Test;

import static chap2.SortTemplate.less;
import static chap2.SortTemplate.show;

/**
 * <p>归并排序</p>
 *
 * @author gengen.wang
 * @version $$ Id: Merge.java, V 0.1 2018/6/4 上午11:07 wanggengen Exp $$
 **/
public class Merge {

    private static Comparable[] aux;

    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    /**
     * 自顶向下的归并排序
     *
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        //将数组a[lo..hi]
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);//将左半边排序
        sort(a, mid + 1, hi);//将右半边排序
        Merge(a, lo, mid, hi);//归并结果

    }

    /**
     * 自底向上的归并排序
     */
    public static void sort2(Comparable[] a) {
        //进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {//sz子数组大小
            for (int lo = 0; lo < N - sz; lo += sz + sz) {//lo：子数组索引
                Merge(a, lo, lo + sz - 1, Math.min(lo + sz - 1, N - 1));
            }
        }
    }


    /**
     * 首先复制元素到aux[]中，然后再回归a[]中
     * 归并是用了4个条件判断：
     * 左半边用尽（取右半边的元素）、右半边用尽（取左半边的元素）、
     * 右半边的当前元素小于左半边的当前元素（取右半边的元素）、右半边的当前元素大于等于左半边的当前元素（取左半边的元素）
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void Merge(Comparable[] a, int lo, int mid, int hi) {
        //将a[lo..mid]和a[mid+1..hi]归并
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {//复制数组
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {//归并
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }


    @Test
    public void test() {
        String[] arr = {"4", "9", "7", "8", "2"};
        sort(arr);
        show(arr);
    }


}

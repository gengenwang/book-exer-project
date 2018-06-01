package chap2;

import org.junit.Test;

/**
 * <p>希尔排序</p>
 *
 * @author gengen.wang
 * @version $$ Id: ShellSort.java, V 0.1 2018/6/1 下午4:13 wanggengen Exp $$
 **/
public class ShellSort extends SortTemplate {

    public void sort(Comparable[] a) {
        //升序排列
        int N = a.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;//1,4,13,40,121,...
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                //将a[i]插入a[i-h]，a[i-2*h]，a[i-3*h]...之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }


    @Test
    public void test() {
        String[] arr = {"4", "7", "2", "8"};
        sort(arr);
        show(arr);
    }
}

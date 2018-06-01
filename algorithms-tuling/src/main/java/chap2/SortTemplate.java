package chap2;

/**
 * <p>排序算法类模板</p>
 *
 * @author gengen.wang
 * @version $$ Id: SortTemplate.java, V 0.1 2018/6/1 上午11:32 wanggengen Exp $$
 **/
public abstract class SortTemplate {

    public abstract void sort(Comparable[] a);

    public static boolean less(Comparable v, Comparable w){
        return  v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i < a.length; i++){
            if (less(a[i], a[i - 1])){
                return false;
            }
        }
        return true;
    }

}

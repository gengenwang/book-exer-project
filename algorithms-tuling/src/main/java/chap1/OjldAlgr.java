package chap1;

/**
 * <p></p>
 *
 * @author gengen.wang
 * @version $$ Id: OjldAlgr.java, V 0.1 2018/5/25 下午3:44 wanggengen Exp $$
 **/
public class OjldAlgr {

    /**
     * 计算两个非负整数的最大公约数
     * @param p
     * @param q
     * @return
     */
    public static int gcd(int p, int q){
        if (q == 0){
            return p;
        }
        int r = p % q;
        return gcd(q,r);
    }

    public static void main(String[] args) {
        int p = 15;
        int q = 6;
        int gcd = gcd(p, q);
        System.out.println(gcd);
    }
}

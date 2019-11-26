import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @PackageName：PACKAGE_NAME
 * @ClassName：
 * @Description：
 * @author：
 * @date：2019/10/26 19:24
 */
public class test {
    public static void main(String[] args) {
//        test1();

//        test2();

        int[] dd = null;
        dd[0] = 1;

        System.out.println(dd[0]);

    }

    public static void test2() {
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        Integer c = new Integer(130);

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

        Integer d = new Integer(130);
        Integer e = new Integer(130);
        System.out.println(d==e);
        System.out.println(d.equals(e));
    }

    public static void test1() {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\娱乐相关软件\\ee.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

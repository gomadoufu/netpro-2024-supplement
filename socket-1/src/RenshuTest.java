import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class RenshuTest {
    Renshu renshu = new Renshu();

    @Test
    void printHello() {
        renshu.printHello();
    }

    @Test
    void printHello2() {
        renshu.printHello2();
    }

    @Test
    void calc5() {
        assertEquals(20, renshu.calc5(5, 1, 4));
        System.out.println(renshu.calc5(5, 1, 4));
    }

    @Test
    void sum() {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // (9)
        assertEquals(55, renshu.sum(10));

        // (10)
        assertEquals(5050, renshu.sum(1, 100));

        // (11)
        assertEquals(55, renshu.sum(a, 0));
        assertEquals(10, renshu.sum(a, 9));
        assertEquals(-1, renshu.sum(a, 10));

    }

    @Test
    void selectMaxValue() {
        int a[] = { 10, 9, 8, 4, 15, 0, -3, 18, 9, 7 };
        assertEquals(18, renshu.selectMaxValue(a));
        System.out.println(renshu.selectMaxValue(a));
    }

    @Test
    void selectMaxIndex() {
        int a[] = { 10, 9, 8, 4, 15, 0, -3, 18, 9, 7 };
        // (13)
        assertEquals(7, renshu.selectMaxIndex(a));
        System.out.println(renshu.selectMaxIndex(a));

        // (17)
        assertEquals(4, renshu.selectMaxIndex(a, 1, 6));
        System.out.println(renshu.selectMaxIndex(a, 1, 6));
    }

    @Test
    void selectMinIndex() {
        int a[] = { 10, 9, 8, 4, 15, 0, -3, 18, 9, 7 };
        assertEquals(6, renshu.selectMinIndex(a));
        System.out.println(renshu.selectMinIndex(a));
    }

    @Test
    void selectDiffMaxMinValue() {
        int p[] = { 10, 9, 8, 4, 15, 0, -3, 18, 9, 7 };
        assertEquals(21, renshu.selectDiffMaxMinValue(p));
        System.out.println(renshu.selectDiffMaxMinValue(p));
    }

    @Test
    void swapArrayElements() {
        // 0番目と9番目入れ替え前の配列
        int[] p = { 10, 9, 8, 4, 15, 0, -3, 18, 9, 7 };
        // 0番目と9番目入れ替え後の配列
        int[] q = { 7, 9, 8, 4, 15, 0, -3, 18, 9, 10 };
        renshu.swapArrayElements(p, 0, 9);
        assertTrue(Arrays.equals(p, q));
    }

    @Test
    void swapTwoArrays() {
        // 関数処理前
        int[] a = { 1, 2, 3, 4 };
        int[] b = { 4, 3, 2, 1 };
        System.out.print("a:");
        for (int n : a) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.print("b:");
        for (int n : b) {
            System.out.print(n + " ");
        }
        System.out.println();
        assertTrue(renshu.swapTwoArrays(a, b));

        // 関数処理後
        System.out.print("a(after):");
        for (int n : a) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.print("b(after):");
        for (int n : b) {
            System.out.print(n + " ");
        }

    }

}

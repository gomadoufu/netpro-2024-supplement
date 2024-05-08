public class Renshu {
    public static void main(String[] args) {
        new Renshu();
    }

    public Renshu() {// コンストラクタ
        // printHello();
    }

    void printHello() {
        System.out.println("hello world!");
    }

    void printHello2() {
        printHello();
        printHello();
    }

    public int calc5(int x, int y, int z) {
        return (x + y + z) * 2;
    }

    public int sum(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        return s;
    }

    public int sum(int p, int q) {
        int s = 0;
        for (int i = p; i <= q; i++) {
            s += i;
        }
        return s;
    }

    public int sum(int[] a, int index) {

        if (index < 0 || a.length <= index) {
            return -1;
        }
        int s = 0;
        for (int i = a[index]; i <= a.length; i++) {
            s += i;
        }
        return s;

    }

    public int selectMaxValue(int[] a) {
        if (a == null) {
            return -1;
        }
        int max = -100;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public int selectMaxIndex(int[] a) {
        if (a == null) {
            return -1;
        }
        int max = -100;
        int maxindex = -1;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                maxindex = i;
            }
        }
        return maxindex;
    }

    public int selectMaxIndex(int[] a, int p, int q) {
        if (a == null || p < 0 || q < 0 || a.length <= p || a.length <= q) {
            return -1;
        }
        int max = -100;
        int maxindex = -1;
        for (int i = p; i < q; i++) {
            if (max < a[i]) {
                max = a[i];
                maxindex = i;
            }
        }
        return maxindex;
    }

}

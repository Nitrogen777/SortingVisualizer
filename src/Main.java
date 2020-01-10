import java.util.ArrayList;
import java.util.Random;

public class Main {
    static Visual v;

    public Main() throws javax.sound.midi.MidiUnavailableException{
        new Sort("Bubble Sort"){
            @Override
            public void sortAlgorithm(int[] a) throws InterruptedException {
                bubbleSort(a);
            }

        };
        new Sort("Insertion Sort"){
            @Override
            public void sortAlgorithm(int[] a) throws InterruptedException {
                insertionSort(a);
            }

        };
        new Sort("Slow Sort"){
            @Override
            public void sortAlgorithm(int[] a) throws InterruptedException {
                slowSort(a, 0, a.length-1);
            }

        };
        new Sort("Merge Sort"){
            @Override
            public void sortAlgorithm(int[] a) throws InterruptedException {
                mergeSort(a,0);
            }

        };
        new Sort("Quick Sort"){
            @Override
            public void sortAlgorithm(int[] a) throws InterruptedException {
                inplcQuickSort(a, 0, a.length-1);
            }

        };
        new Sort("Cocktail Shaker Sort"){
            @Override
            public void sortAlgorithm(int[] a) throws InterruptedException {
                cocktailShakerSort(a);
            }

        };
        new Sort("Selection Sort"){
            @Override
            public void sortAlgorithm(int[] a) throws InterruptedException {
                selectionSort(a, 0);
            }

        };
        new Sort("Double Selection Sort"){
            @Override
            public void sortAlgorithm(int[] a) throws InterruptedException {
                doubleSelectionSort(a);
            }

        };
        new Sort("Radix LSD Base 10"){
            @Override
            public void sortAlgorithm(int[] a) throws InterruptedException {
                radixLSDBase10(a);
            }

        };
        new Sort("Counting Sort"){
            @Override
            public void sortAlgorithm(int[] a) throws InterruptedException {
                countingSort(a);
            }

        };
        v = Visual.getInstance();
    }
    public static void main(String[] args) throws InterruptedException, javax.sound.midi.MidiUnavailableException{
        Main m = new Main();
    }

    static int[] tem;
    public static void setup(int[] a)
            throws InterruptedException
    {
        for (int i = 1; i <= a.length; i++) {
            a[(i - 1)] = i;
        }
        tem = new int[a.length];
        Thread.sleep(90L);
        v.display(a, -1, -1);
    }

    public static void shuffle(int[] a) throws InterruptedException { v.setTitle("Shuffeling");
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            int n1 = r.nextInt(a.length);
            int n2 = r.nextInt(a.length);
            int t = a[n2];
            a[n2] = a[n1];
            a[n1] = t;
            v.display(a, n1, n2);
        }
        v.setTitle("");
        v.display(a, -1, -1);
    }

    public static void bubbleSort(int[] a) throws InterruptedException {
        while (!isSort(a)) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[(i + 1)] <= a[i]) {
                    int t = a[i];
                    a[i] = a[(i + 1)];
                    a[(i + 1)] = t;
                }
                v.display(a, i, i + 1);
            }
        }
        v.display(a, -1, -1);
    }
    public static void insertionSort(int[] a) throws InterruptedException {
        for(int i = 0; i < a.length; i++){
            for(int j = i; j > 0; j--){
                if(a[j-1] > a[j]){
                    int k = a[j];
                    a[j] = a[j-1];
                    a[j-1] = k;
                    v.display(a, i, j);
                }else{
                    break;
                }
            }
        }
        v.display(a, -1, -1);
    }

    public static void slowSort(int[] a, int f, int t) throws InterruptedException {
        if (f >= t) {
            return;
        }
        int m = (t + f) / 2;
        slowSort(a, f, m);
        slowSort(a, m + 1, t);
        if (a[t] < a[m]) {
            int p = a[t];
            a[t] = a[m];
            a[m] = p;
        }
        v.display(a, t, m);
        slowSort(a, f, t - 1);
        v.display(a, -1, -1);
    }

    public static void mergeSort(int[] a, int spos) throws InterruptedException {
        if (a.length == tem.length) {
            for (int d = 0; d < a.length; d++) {
                tem[d] = a[d];
            }
        }
        if (a.length <= 1) {
            return;
        }

        int m = a.length / 2;
        int[] l = new int[m];
        int[] r = new int[a.length - m];
        for (int i = 0; i < l.length; i++) {
            l[i] = a[i];
        }
        for (int i = 0; i < r.length; i++) {
            r[i] = a[(m + i)];
        }

        mergeSort(l, spos);
        mergeSort(r, spos + m);
        int[] c = new int[a.length];
        int i = 0;
        int j = 0;
        int k = 0;
        for (; (i < m) && (j < a.length - m); k++) {
            if (l[i] > r[j]) {
                c[k] = r[(j++)];
            } else {
                c[k] = l[(i++)];
            }
        }
        for (; i < m; k++) {
            c[k] = l[(i++)];
        }
        for (; j < a.length - m; k++) {
            c[k] = r[(j++)];
        }

        for (int h = 0; h < c.length; h++) {
            a[h] = c[h];
        }
        for (int d = 0; d < a.length; d++) {
            tem[(d + spos)] = a[d];

            v.display(tem, spos, d + spos);
        }
        if (a.length == tem.length) {
            v.display(a, -1, -1);
        }
    }


    public static void quickSort(int[] a, int spos) throws InterruptedException {
        if (a.length == tem.length) {
            for (int d = 0; d < a.length; d++) {
                tem[d] = a[d];
            }
        }
        if (a.length <= 1) {
            return;
        }
        Random ran = new Random();
        int axisi = ran.nextInt(a.length);
        int axis = a[axisi];
        int ls = 0;
        int rs = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < axis) {
                ls++;
            } else {
                rs++;
            }
        }
        int[] l = new int[ls];
        int[] r = new int[rs];
        int li = 0;
        int ri = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < axis) {
                l[(li++)] = a[i];
            } else {
                r[(ri++)] = a[i];
            }
        }
        quickSort(l, spos);
        quickSort(r, spos + ls);
        int[] c = new int[a.length];
        int k = 0;
        for (int i = 0; i < ls; i++) {
            System.out.println(k);
            c[(k++)] = l[i];
        }
        System.out.println(k);
        for (int i = 0; i < rs; i++) {
            c[(k++)] = r[i];
        }
        for (int h = 0; h < c.length; h++) {
            a[h] = c[h];
        }
        for (int d = 0; d < a.length; d++) {
            tem[(d + spos)] = a[d];

            v.display(tem, spos, d + spos);
        }
        if (a.length == tem.length) {
            v.display(a, -1, -1);
        }
    }
    public static void inplcQuickSort(int[] a, int s, int f) throws InterruptedException {
        if (f - s <= 0) {
            return;
        }
        int axisi = f;
        int axis = a[axisi];
        int k = s-1;
        for (int i = s; i <= f; i++) {
            if (a[i] < axis) {
                k++;
                int t = a[k];
                a[k] = a[i];
                a[i] = t;
            }
            v.display(a, axisi,i);
        }
        k++;
        int t = a[k];
        a[k] = a[axisi];
        a[axisi] = t;
        axisi = k;
        inplcQuickSort(a, s,axisi-1);
        inplcQuickSort(a, axisi+1, f);
        v.display(a, -1,-1);

    }

    public static void cocktailShakerSort(int[] a) throws InterruptedException {
        while (!isSort(a)) {
            for (int i = 0; i < a.length - 1; i++) {
                if (a[(i + 1)] <= a[i]) {
                    int t = a[i];
                    a[i] = a[(i + 1)];
                    a[(i + 1)] = t;
                }
                v.display(a, i, i + 1);
            }
            for (int i = a.length - 2; i >= 0; i--) {
                if (a[(i + 1)] <= a[i]) {
                    int t = a[i];
                    a[i] = a[(i + 1)];
                    a[(i + 1)] = t;
                }
                v.display(a, i, i + 1);
            }
        }
        v.display(a, -1, -1);
    }

    public static void selectionSort(int[] a, int f) throws InterruptedException {
        if (f >= a.length - 1) {
            return;
        }
        v.setTitle("Selection Sort");
        int min = a[f];
        int inm = f;
        for (int i = f; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                inm = i;
            }
            v.display(a, f, i);
        }
        a[inm] = a[f];
        a[f] = min;
        v.display(a, -1, -1);
        selectionSort(a, f + 1);
    }
    public static void doubleSelectionSort(int[] a) throws InterruptedException {
        int f = 0;
        int l = a.length -1;
        while(f < l){
            v.setTitle("Double Selection Sort");
            int inm = f;
            int inx = l;
            for (int i = f ; i <= l; i++) {
                if (a[i] <= a[inm]) {
                    inm = i;
                }
                v.display(a, f, i);
            }
            int t = a[inm];
            a[inm] = a[f];
            a[f] = t;
            f++;
            for (int i = l ; i >= f; i--) {
                if (a[i] >= a[inx]) {
                    inx = i;
                }
                v.display(a, i, l);
            }

            t = a[inx];
            a[inx] = a[l];
            a[l] = t;
            l--;
        }
        v.display(a, -1, -1);

    }

    public static void radixLSDBase10(int[] a) throws InterruptedException { v.setTitle("Radix LSD Base-10");
        for (int i = 0; i < numOfDigits(max(a)); i++) {
            int[] r = new int[a.length];
            int in = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < a.length; k++) {
                    if (digiAt(a[k], i) == j) {
                        int t = a[k];



                        r[in] = t;
                        in++;
                    }
                }
            }

            for (int l = 0; l < a.length; l++) {
                a[l] = r[l];
                v.display(a, l, -1);
            }
        }
        v.display(a, -1, -1);
    }
    public static void countingSort(int[] a) throws InterruptedException { v.setTitle("Counting Sort");
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[(a[i] - 1)] = a[i];
        }
        for (int l = 0; l < a.length; l++) {
            a[l] = c[l];
            v.display(a, l, -1);
        }
        v.display(a, -1, -1);
    }

    public static int numOfDigits(int num) {
        int n = num;
        int c = 0;
        while (n > 0) {
            n /= 10;
            c++;
        }
        return c;
    }

    public static int digiAt(int num, int at) { int n = num;
        for (int i = 0; i < at; i++) {
            n /= 10;
        }
        return n % 10;
    }

    public static int max(int[] a) { int m = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > m) {
                m = a[i];
            }
        }
        return m;
    }

    public static boolean isSort(int[] a) { for (int i = 0; i < a.length - 1; i++) {
        if (a[(i + 1)] < a[i]) {
            return false;
        }
    }
        return true;
    }

    public static int[] reverse(int[] a) throws InterruptedException { int[] r = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            r[i] = a[(a.length - 1 - i)];
            v.display(r, i, a.length - 1 - i);
        }
        v.display(r, -1, -1);
        return r;
    }
}

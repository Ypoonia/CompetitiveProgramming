import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;




// हर हर महादेव
// हरे कृष्णा
public class Main {
    static Scanner sc = new Scanner(System.in);
    static FastReader in = new FastReader();

    static class FastReader { //I don't understand how this works lmao
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int[] nextIntArray(int n) {
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) ar[i] = Integer.parseInt(next());
            return ar;
        }

        long[] nextlongArray(int n) {
            long ar[] = new long[n];
            for (int i = 0; i < n; i++) ar[i] = Long.parseLong(next());
            return ar;
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static final long MOD = 1000000007; // 1e9 + 7

    public static long powerOfTwo(int n) {
        long result = 1;
        long a = 2;
        for (int i = 0; i < n; i++) {
            result = (result * a) % MOD;
        }
        return result;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lowerBound(int[] a, long x) {
        int low = 0;
        int high = a.length - 1;
        int ans = a.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }

    public static int upperBound(int[] a, int n, int x) {
        // Write your code here
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    private static void addMap(HashMap<Integer, Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }


    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }


    public static int findMaximum(int[] array) { // tell max element in the array
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static boolean Prime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

    private static int getParent(int curr) {
        return curr / 2; // Example parent calculation
    }

    static class Pair implements Comparable<Pair> {
        long first;
        long second;

        Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }


        public int compareTo(Pair other) {
            return Long.compare(this.first, other.first);
        }
    }
    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            // Swap the elements
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            // Move the pointers
            start++;
            end--;
        }
    }






    static Random random = new Random();

    public static void main(String[] args) throws IOException {
//  t = in.nextInt();
 int t=1;
  while (t-- > 0) {
            solve();
      // ^  but I'll try it;
        }
 }

    // A


    /*  stuff you should look for
     * int overflow, array bounds
     * special cases (n=1?)
     * do smth instead of nothing and stay organized
     * WRITE STUFF DOWN
     * DON'T GET STUCK ON ONE APPROACH; */

    static int n ;
    static long dp[];
    static boolean flag = true;

    public static void solve() throws IOException {
        

    }






}



















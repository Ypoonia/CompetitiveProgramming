import java.util.Scanner;

public class SegmentTree  {
    static Scanner in = new Scanner(System.in);
    private int[] tree;
    private int[] arr;
    private int n;

    public SegmentTree(int[] input) {
        this.n = input.length;
        this.arr = new int[n];
        System.arraycopy(input, 0, this.arr, 0, n);
        // A segment tree array can be up to 4*n in size
        this.tree = new int[4 * n];
        build(0, 0, n - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            // Leaf node
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;
            // Recursively build the segment tree
            build(leftChild, start, mid);
            build(rightChild, mid + 1, end);
            // Internal node will have the sum of both of its children
            tree[node] = tree[leftChild] + tree[rightChild];
        }
    }

    public void update(int idx, int value) {
        update(0, 0, n - 1, idx, value);
    }

    private void update(int node, int start, int end, int idx, int value) {
        if (start == end) {
            // Leaf node
            arr[idx] = value;
            tree[node] = value;
        } else {
            int mid = (start + end) / 2;
            int leftChild = 2 * node + 1;
            int rightChild = 2 * node + 2;
            if (start <= idx && idx <= mid) {
                // If idx is in the left child, recurse on the left child
                update(leftChild, start, mid, idx, value);
            } else {
                // If idx is in the right child, recurse on the right child
                update(rightChild, mid + 1, end, idx, value);
            }
            // Internal node will have the sum of both of its children
            tree[node] = tree[leftChild] + tree[rightChild];
        }
    }

    public int query(int L, int R) {
        return query(0, 0, n - 1, L, R);
    }

    private int query(int node, int start, int end, int L, int R) {
        if (R < start || end < L) {
            // range represented by a node is completely outside the given range
            return 0;
        }
        if (L <= start && end <= R) {
            // range represented by a node is completely inside the given range
            return tree[node];
        }
        // range represented by a node is partially inside and partially outside the given range
        int mid = (start + end) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        int leftQuery = query(leftChild, start, mid, L, R);
        int rightQuery = query(rightChild, mid + 1, end, L, R);
        return leftQuery + rightQuery;
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i]= in.nextInt();
        }
        SegmentTree segTree = new SegmentTree(a);

        // Test the query method
        System.out.println("Sum of values in given range = " + segTree.query(1, 3)); // Output: 15

        // Test the update method
        segTree.update(1, 10);
        System.out.println("Sum of values in given range after update = " + segTree.query(1, 3)); // Output: 22
    }
}

package my.ds;

import java.util.function.BiFunction;

public class SegmentTree {
    private class SegmentTreeNode{
        public int l;
        public int r;
        public Elem value;
        public SegmentTreeNode left;
        public SegmentTreeNode right;

        public SegmentTreeNode(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public SegmentTreeNode(int l, int r, Elem value) {
            this.l = l;
            this.r = r;
            this.value = value;
        }
    }

    public int[] nums;
    public SegmentTreeNode root;
    public BiFunction<Elem, Elem, Elem> func;

    public SegmentTree(int[] nums, BiFunction<Elem, Elem, Elem> func) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("构造数组不能为空!");
        }
        this.nums = nums;
        this.func = func;
        this.root = build(0, nums.length - 1);
    }

    private SegmentTreeNode build(int l, int r) {
        if (l > r) {
            return null;
        }
        else if (l == r) {
            return new SegmentTreeNode(l, r, new Elem(nums[l], l));
        }
        int mid = (l + r) / 2;
        SegmentTreeNode root = new SegmentTreeNode(l, r);
        root.left = build(l, mid);
        root.right = build(mid + 1, r);
        root.value = this.func.apply(root.left.value, root.right.value);
        return root;
    }

    public Elem search(int i, int j) {
        if(i < 0 || j >= this.nums.length || i > j){
            throw new RuntimeException("区间不合法");
        }
        return _search(root, i, j);
    }

    private Elem _search(SegmentTreeNode root, int l, int r) {
        if (root.l == l && root.r == r) {
            return root.value;
        }
        int mid = (root.l + root.r) / 2;
        if (r <= mid) {
            return _search(root.left, l, r);
        }
        else if (l > mid) {
            return _search(root.right, l, r);
        }
        else {
            return this.func.apply(_search(root.left, l, mid), _search(root.right, mid + 1, r));
        }
    }
}

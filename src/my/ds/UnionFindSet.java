package my.ds;

public class UnionFindSet {

    private int[] pre;

    public UnionFindSet(int length) {
        this.pre = new int[length];
        for (int i = 0; i < this.pre.length; i++) {
            this.pre[i] = i;
        }
    }

    public int find(int x) {
        // 路径压缩
        int root = x;
        while (root != this.pre[root]) {
            root = this.pre[root];
        }
        while (x != this.pre[x]) {
            int tmp = this.pre[x];
            this.pre[x] = root;
            x = tmp;
        }
        return root;
    }

    public void union(int x, int y) {
        this.pre[find(x)] = find(y);
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

}

/**
 * @author kuang
 * @description
 * @date 2022/6/6  21:13
 */
class UF {

    // 所属集合
    int[] eleGroup;
    // 集合数量
    private int count;

    //初始化并查集
    UF(int n) {
        eleGroup = new int[n];
        this.count = n;
        for (int i = 0; i < eleGroup.length; i++) {
            eleGroup[i] = i;
        }
    }

    //组的个数
    public int getCount() {
        return this.count;
    }

    //查找元素所在的组
    public int find(int ele) {
        return eleGroup[ele];
    }

    //判断两个元素是否在同一个组
    public boolean connected(int e1, int e2) {
        return find(e1) == find(e2);
    }

    //合并两个组
    public void union(int g1, int g2) {
        if (connected(g1, g2)) {
            return;
        }
        int g1Group = find(g1);
        int g2Group = find(g2);
        for (int i = 0; i < eleGroup.length; i++) {
            if (eleGroup[i] == g1Group) {
                eleGroup[i] = g2Group;
            }
        }
        this.count--;
    }

}

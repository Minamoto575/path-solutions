import java.util.Arrays;

/**
 * @author kuang
 * @description
 * @date 2022/6/6  21:13
 */
class FGraph {

    //顶点集合
    private char[] vertex;
    //邻接矩阵
    private int[][] arcs;
    //前驱矩阵
    private int[][] path;

    public FGraph(int vertexNum, int[][] arcs, char[] vertex) {
        this.vertex = vertex;
        this.arcs = arcs;
        this.path = new int[vertexNum][vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            Arrays.fill(path[i], i);
        }
    }

    // 展示结果
    public void show() {
        System.out.println("==========邻接矩阵==========");
        for (int i = 0; i < arcs.length; i++) {
            for (int j = 0; j < arcs.length; j++) {
                System.out.print(arcs[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==========前驱矩阵==========");
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                System.out.print(vertex[path[i][j]] + " ");
            }
            System.out.println();
        }
    }

    // floyd算法
    public void floyd() {
        //保存距离
        int len = 0;
        //k为中间顶点
        for (int k = 0; k < arcs.length; k++) {
            //i为开始顶点
            for (int i = 0; i < arcs.length; i++) {
                //j为结束顶点
                for (int j = 0; j < arcs.length; j++) {
                    len = arcs[i][k] + arcs[k][j];
                    if (len < arcs[i][j]) {
                        arcs[i][j] = len;//更新距离
                        path[i][j] = path[k][j];//更新前驱矩阵
                    }
                }
            }
        }
    }

    // 展示任意两个点距离与路径
    public void showAToB(char a, char b, char[] vertex) {
        int beginIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < vertex.length; i++) {
            if (a == vertex[i]) {
                beginIndex = i;
            }
            if (b == vertex[i]) {
                endIndex = i;
            }
        }
        System.out.println(" ");
        System.out.print(a + "到" + b + "的距离为：" + arcs[beginIndex][endIndex]);
        System.out.print(" 路径为：");
        showAToBPath(beginIndex, endIndex, vertex);
        System.out.print(b);
    }

    //展示路径
    public void showAToBPath(int beginIndex, int endIndex, char[] vertex) {
        if (path[beginIndex][endIndex] == endIndex && path[beginIndex][endIndex] == beginIndex) {
            return;
        }
        showAToBPath(beginIndex, path[beginIndex][endIndex], vertex);
        System.out.print(vertex[path[beginIndex][endIndex]] + " ");
    }

}

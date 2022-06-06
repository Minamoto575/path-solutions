import java.util.Arrays;

/**
 * @author kuang
 * @description
 * @date 2022/6/6  20:36
 */
public class Solution2 {
    private static PathData pathData = new PathData();

    public static void main(String[] args) {
        char[] vertex = pathData.getVertex();
        int[][] matrix = pathData.getMatrix();
        //创建 Graph 对象
        FGraph graph = new FGraph(vertex.length, matrix, vertex);
        //调用弗洛伊德算法
        graph.floyd();
        graph.show();
    }
}


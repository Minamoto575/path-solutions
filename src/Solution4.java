import java.util.Arrays;

/**
 * @author kuang
 * @description
 * @date 2022/6/6  20:36
 */
public class Solution4 {
    private static PathData pathData = new PathData();
    
    public static void main(String[] args) {
        char[] vertex = pathData.getVertex();
        int[][] matrix = pathData.getMatrix();
        //创建 Graph 对象
        FGraph graph = new FGraph(vertex.length, matrix,vertex);
        //调用弗洛伊德算法
        graph.floyd();
        // 展示任意两点的路径
        for(int i = 0 ;i<vertex.length;i++){
            for(int j=i+1;j<vertex.length;j++){
                graph.showAToB(vertex[i], vertex[j], vertex);
            }
        }
    }
}




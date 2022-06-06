import java.util.Arrays;

/**
 * @author kuang
 * @description
 * @date 2022/6/6  21:52
 */
public class PathData {
    // 为N认为不可达，及无穷远
    private static int N = 999999;
    // 顶点集合
    private static char[] vertex = {'1', '2', '3', '4', '5', '6', '7','8'};
    // 路径边
    private static int[][] paths = {
        {2,1,436},
        {4,1,767},
        {8,1,1026},
        {4,2,515},
        {8,2,866},
        {5,3,269},
        {8,3,843},
        {8,4,365},
        {8,5,849},
        {7,6,197},
        {8,6,683},
        {8,7,488},
        {7,1,522},
        {6,3,486},
        {4,5,620}
    };
    // 邻接矩阵
    private static int[][] matrix = new int [vertex.length][vertex.length];

    // 初始化临界矩阵
    public static void init(){
        for(int i= 0;i<vertex.length;i++){
            Arrays.fill(matrix[i],N);
            matrix[i][i]=0;
        }
        for(int[] path:paths){
            matrix[path[0]-1][path[1]-1]=path[2];
            matrix[path[1]-1][path[0]-1]=path[2];
        }
    }

    PathData(){
        init();
    }

    int[][] getPaths(){
        return paths;
    }
    char[] getVertex(){
        return vertex;
    }
    int[][] getMatrix(){
        return matrix;
    }
    int getN(){
        return N;
    }

}

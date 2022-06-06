import java.util.Arrays;

/**
 * @author kuang
 * @description
 * @date 2022/6/6  21:00
 */
public class Solution3 {


    private static PathData pathData = new PathData();

    public static void main(String[] args) {
        boolean[] visited = new boolean[pathData.getVertex().length];
        visited[0] = true;
        int[] sons = new int[pathData.getVertex().length];
        dfs(0,visited,sons,0,1);
    }

    /*
     * @description 深度优先算法
     * @param cur: 当前在哪个点
     * @param visited:  访问数组，记录那些顶点之前访问过了
     * @param sons: 记录路径，表示sons[i]表示从i出发去sons[i]
     * @param distance: 当前的路径距离
     * @param count:  经过了几个顶点
     * @return: void
     * @data 2022/6/6
     */
    public static void dfs(int cur,boolean[] visited,int[] sons,int distance,int count) {
        // 经过了所有顶点 找到了一条路
        if(count==visited.length){
            System.out.print("找到一条路径，"+"距离为："+distance);
            System.out.print(" 路径是：1");
            int index = 0;
            // 打印路径
            for(int i=0;i<visited.length-1;i++){
                System.out.print(" "+(sons[index]+1));
                index = sons[index];
            }
            System.out.println("");
        }
        int[][] matrix = pathData.getMatrix();
        int N = pathData.getN();
        // 遍历没经过的顶点
        for (int i = 0; i < visited.length; i++) {
            // 没有访问过 而且能够直达
            if (!visited[i] && matrix[cur][i] != N) {
                visited[i] = true;
                sons[cur] = i;
                dfs(i, visited, sons, distance + matrix[cur][i],count+1);
                // 回溯
                visited[i] = false;
            }
        }
    }

}

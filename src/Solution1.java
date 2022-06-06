import java.util.Arrays;

/**
 * @author kuang
 * @description
 * @date 2022/6/6  20:03
 */
public class Solution1 {
    private static PathData pathdata = new PathData();

    public static void main(String[] args) {
        int[][] paths = pathdata.getPaths();

        // 并查集
        UF uf = new UF(8);
        for(int[] path:paths){
            // 合并
            uf.union(path[0]-1,path[1]-1);
        }
        // 如果只剩一个集合
        if(uf.getCount()==1){
            System.out.println("图是连通的！");
        }else{
            System.out.println("图不是连通的！");
        }
    }
}


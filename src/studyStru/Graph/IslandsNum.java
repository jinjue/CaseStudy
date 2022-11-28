package studyStru.Graph;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 */
public class IslandsNum {

    public int numIslands(char[][] grid) {
        //排除非法输入
        if(grid == null)
            return 0;
        int count = 0;
        //对二维数组进行循环
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                //当遇到‘1’时，进行深度搜索，岛屿数量+1
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        //返回岛屿数量
        return count;
    }

    public void dfs(char[][] grid , int i, int j){
        //递归结束条件，i、j越界
        if(i <0 || j < 0 || i > grid.length || j > grid[0].length || grid[i][j] == '0')
            return;
        //将访问到的设为‘0’
        grid[i][j] = '0';
        //查找i-1，j
        dfs(grid,i-1,j);
        //查找i+1，j
        dfs(grid,i+1,j);
        //查找i，j-1
        dfs(grid,i,j-1);
        //查找i，j+1
        dfs(grid,i,j+1);
    }

}

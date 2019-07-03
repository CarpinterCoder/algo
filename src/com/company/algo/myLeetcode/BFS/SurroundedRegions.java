package com.company.algo.myLeetcode.BFS;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 10:44 2018/8/6
 */
/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region .
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board==null || board.length<3 || board[0]==null || board[0].length<3)
            return;

        Set<String> visited = new HashSet<String>();

        //从上下左右四个边界出发遍历连续的'O'(未被'X'包围的'O')，加入集合visited中
        //上下边界
        for (int y=1; y<board[0].length-1;y++){
            search(0,y,visited,board);
            search(board.length-1,y,visited,board);
        }
        //左右边界
        for (int x=1;x<board.length-1;x++){
            search(x,0,visited,board);
            search(x,board[0].length-1,visited,board);
        }

        for (int i=1;i<board.length-1;i++){
            for (int j=1;j<board[0].length-1;j++){
                if (board[i][j]=='O' && !visited.contains(i+"=".trim()+j))
                    board[i][j] = 'X';
            }
        }


    }

    private void search(int x, int y, Set<String> visited, char[][] board) {
        if (x<0 || x>board.length-1 || y<0 || y>board[0].length-1)
            return;
        if (board[x][y]=='X')
            return;
        String location = x+"=".trim()+y;
        if (visited.contains(location))
            return;
        visited.add(location);
        //上
        search(x-1,y,visited,board);
        //下
        search(x+1,y,visited,board);
        //左
        search(x,y-1,visited,board);
        //右
        search(x,y+1,visited,board);
    }

}

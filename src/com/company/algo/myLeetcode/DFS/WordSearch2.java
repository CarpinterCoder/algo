package com.company.algo.myLeetcode.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 20:44 2018/8/15
 */
/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighbouring. The same letter cell may not be used more than once.
 * For example, Given board =
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 *
 * */
public class WordSearch2 {
    public boolean exist(char[][] board, String word) {
        List<String> visited = new ArrayList<String>(word.length());
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (dfs(board,word,0,i,j,visited))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y, List<String> visited) {
        if (index==word.length())
            return true;

        if (x<0 || x>=board.length || y<0 || y>=board[0].length)
            return false;

        if (visited.contains(x+"="+y))
            return false;

        if (board[x][y]!=word.charAt(index))
            return false;

        visited.add(x+"="+y);

        boolean flag = dfs(board,word,index+1,x-1,y,visited) ||
                       dfs(board,word,index+1,x+1,y,visited) ||
                       dfs(board,word,index+1,x,y-1,visited) ||
                       dfs(board,word,index+1,x,y+1,visited);

        visited.remove(x+"="+y);

        return flag;
    }
}

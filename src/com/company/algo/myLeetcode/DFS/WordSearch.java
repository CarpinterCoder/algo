package com.company.algo.myLeetcode.DFS;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 10:55 2018/8/14
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
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        return backLine(board,word,0,0,0,new HashSet<String>());
    }

    private boolean backLine(char[][] board, String word, int x, int y,int index,Set<String> record) {
        if (x<0 || x>=board.length || y<0 || y>=board[0].length)
            return false;

        if (record.contains(x+"="+y))
            return false;

        char ch = word.charAt(index);

        while (true){
            if (board[x][y]!=ch){
                if (index>0)
                    return  false;
                else{

                    a:for (int i=x;i<board.length;i++){
                        for (int j=0;j<board[0].length;j++){
                            if (board[i][j]==ch){
                                x=i;y=j;
                                break a;
                            }
                        }
                    }
                }
            }
            if (index==word.length()-1)
                return true;

            boolean flag = false;
            record.add(x+"="+y);
            flag =  backLine(board,word,x-1,y,index+1,record) ||
                    backLine(board,word,x+1,y,index+1,record) ||
                    backLine(board,word,x,y-1,index+1,record) ||
                    backLine(board,word,x,y+1,index+1,record);


            if (flag)
                return true;
            else{
                record.remove(x+"="+y);
                if (index!=0)
                    break;
                else {
                    if (x==board.length-1 && y==board[0].length-1)
                        break;

                    if (y<board[0].length-1)
                        y++;

                    while (y<board[0].length && board[x][y]!=ch)
                        y++;

                    if (y==board[0].length){
                        if (x==board.length-1)
                            break;
                        else{
                            y=0;
                            x++;
                        }
                    }
                }
            }

        }

        return false;

    }
}

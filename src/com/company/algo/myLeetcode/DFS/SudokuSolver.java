package com.company.algo.myLeetcode.DFS;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:10 2018/8/13
 */

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 *
 *  深浅拷贝问题
 */
public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        dfs(board,0,0);
    }

    private static boolean dfs(char[][] board, int x, int y) {

        if (y>8 && x<8){
            x++;
            y=0;
        }

        if (board[x][y]!='.'){
            if (x==8 && y==8)
                return true;
            return dfs(board,x,y+1);
        }

        List<Character> set = new ArrayList<Character>(9);
        for (char i='1';i<='9';){
            set.add(i);
            i = (char)(i+1);
        }
        for (int i=0;i<9;i++){
            char chy = board[i][y];
            if (set.contains(chy))
                set.remove((Character)chy);
        }

        for (int j=0;j<9;j++){
            char chx = board[x][j];
            if (set.contains(chx))
                set.remove((Character)chx);
        }

        int m = (x/3)*3,n = (y/3)*3;
        for (int i=m;i<m+3;i++){
            for (int j=n;j<n+3;j++){
                char ch = board[i][j];
                if (set.contains(ch))
                    set.remove((Character)ch);
            }
        }

        if (set.isEmpty())
            return false;

        if (x==8 && y==8){
            board[x][y]=set.get(0);
            return true;
        }



        for (char ch:set){
            char[][] tmp = new char[9][9];
            for (int i=0;i<9;i++)
                System.arraycopy(board[i],0,tmp[i],0,9);
            tmp[x][y]=ch;
            boolean flag = dfs(tmp,x,y+1);
            if (flag){
                for (int i=0;i<9;i++)
                    System.arraycopy(tmp[i],0,board[i],0,9);
                board = tmp;
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){

        char[][] board = {{'.','.','9','7','.','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}};
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++)
                System.out.print(board[i][j]+" ");
            System.out.println();
        }
        System.out.println("===============================");
        solveSudoku(board);
        for (int i=0;i<9;i++){
            System.out.println();
            for (int j=0;j<9;j++)
                System.out.print(board[i][j]+" ");
        }
    }
}

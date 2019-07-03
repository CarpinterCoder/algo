package com.company.algo.myLeetcode.array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 20:50 2018/7/30
 */
/**
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character,ArrayList<int[]>> map = new HashMap<Character, ArrayList<int[]>>();
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                char num = board[i][j];
                if (map.containsKey(num)){
                    ArrayList<int[]> list = map.get(num);
                    for (int[] ints:list){
                        int x = ints[0],y=ints[1];
                        if (x==i || y==j || (x/3==i/3 && y/3==j/3))
                            return false;
                    }
                }
                if (num!='.'){
                    ArrayList<int[]> list = map.get(num);
                    if (list==null)
                        list = new ArrayList<int[]>();
                    int[] indexs = new int[]{i,j};
                    list.add(indexs);
                    map.put(num,list);
                }
            }
        }
        return true;
    }
}

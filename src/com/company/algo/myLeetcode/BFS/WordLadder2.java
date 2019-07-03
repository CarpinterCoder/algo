package com.company.algo.myLeetcode.BFS;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:47 2018/8/5
 */
public class WordLadder2 {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start==null || end==null)return 0;
        if (start.equals(end))return 0;

        ArrayList<String> visited = new ArrayList<String>();
        visited.add(start);
        if (dict.contains(start))
            dict.remove(start);
        int step = 1;

        while (!visited.contains(end)){
            ArrayList<String> temp = new ArrayList<String>();
            for (String word:visited){
                for (int i=0;i<word.length();i++){
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i,'.');
                    String regex = sb.toString();
                    for (String s:dict){
                        if (s.matches(regex)){
                            temp.add(s);
//                            dict.remove(s);//在遍历集合dict的时候，不能试图改变它
                        }
                    }
                    for (String s:temp)
                        dict.remove(s);

                }
            }
            if (temp.size()==0)//无法到达
                return 0;

            visited = temp;
            step+=1;
        }

        return step;
    }
}

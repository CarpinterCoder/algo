package com.company.algo.myLeetcode.BFS;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 16:44 2018/8/5
 */
/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence
 * from start to end, such that:
 * • Only one letter can be changed at a time
 * • Each intermediate word must exist in the dictionary
 * For example, Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * Note:
 * • Return 0 if there is no such transformation sequence.
 * • All words have the same length.
 * • All words contain only lowercase alphabetic characters.
 *
 * */
public class WordLadder {
    public static int ladderLength(String start, String end, HashSet<String> dict) {
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
                    char[] chars = word.toCharArray();
                    for (char c='a';c<='z';){
                        chars[i] = c;
                        String s = new String(chars);
                        if (dict.contains(s)){
                            temp.add(s);
                            dict.remove(s);
                        }
                        c = (char)(c+1);
                    }
                }
            }
            if (temp.size()==0)//无法到达
                return 0;

            visited = temp;
            step+=1;
        }

        return step;
    }

    public static void main(String[] args){
        String start = "a";
        String end = "c";
        HashSet<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        System.out.println(ladderLength(start,end,dict));
    }
}

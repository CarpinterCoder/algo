package com.company.algo.myLeetcode.BFS;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:59 2018/8/5
 */
@Deprecated
public class WordLadderII {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
        if (dict.contains(start))
            dict.remove(start);
        ArrayList<String> first = new ArrayList<String>();
        first.add(start);
        paths.add(first);
        while (true){
            int gets = 0;
            ArrayList<ArrayList<String>> temps = new ArrayList<ArrayList<String>>();
            for (ArrayList<String> path:paths){
                if (path.contains(end)){
                    temps.add(path);
                    gets++;
                }

                while (!path.contains(end)){
                    String word = path.get(path.size()-1);
                    for (int i=0;i<word.length();i++){
                        char[] chars = word.toCharArray();
                        for (char c='a';c<='z';){
                            chars[i] = c;
                            String newWord = new String(chars);
                            if (dict.contains(newWord)){
                                ArrayList<String> newPath = new ArrayList<String>(path);
                                newPath.add(newWord);
                                temps.add(newPath);
                                dict.remove(newWord);
                            }
                            c = (char)(c+1);
                        }
                    }

                }
            }

            if (gets==paths.size())
                break;
            paths = temps;
        }
        return paths;
    }
}

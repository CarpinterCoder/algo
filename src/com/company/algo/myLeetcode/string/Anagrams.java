package com.company.algo.myLeetcode.string;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 15:08 2018/8/5
 */
public class Anagrams {
    public ArrayList<ArrayList<String>> anagrams(String[] strs) {
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        if (strs==null || strs.length==0)
            return lists;

        if (strs.length==1){
            ArrayList<String> list = new ArrayList<String>(1);
            list.add(strs[0]);
            lists.add(list);
            return lists;
        }

        HashMap<String,Integer> map = new HashMap<String, Integer>();
        int num = 0;
        for (int i=0;i<strs.length;i++){
            StringBuilder sb = new StringBuilder(strs[i]);
            //用插入排序法对每个字符串进行排序
            for (int x=1;x<sb.length();x++){
                for (int y=x;y>0 && sb.charAt(y)<sb.charAt(y-1);y--){
                    char c = sb.charAt(y);
                    sb.setCharAt(y,sb.charAt(y-1));
                    sb.setCharAt(y-1,c);
                }
            }
            Integer k = map.get(sb.toString());
            if (k==null){
                map.put(sb.toString(),++num);
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                lists.add(list);
            }else {
                ArrayList<String> list = lists.get(k-1);
                list.add(strs[i]);
            }
        }
        return lists;
    }
}

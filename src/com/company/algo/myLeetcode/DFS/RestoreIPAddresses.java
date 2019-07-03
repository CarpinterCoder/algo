package com.company.algo.myLeetcode.DFS;

import java.util.ArrayList;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 21:49 2018/8/12
 */
/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example: Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 * */
public class RestoreIPAddresses {
    public static ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s==null || s.length()==0){
            return res;
        }
        char[] chs = s.trim().toCharArray();
        dfs(res,chs,0,1,new StringBuilder());
        return res;
    }

    private static void dfs(ArrayList<String> res, char[] chs, int start, int order,StringBuilder strs) {
        if (start>=chs.length)
            return;
        if (order==4){
            if (start<chs.length-1 && chs[start]=='0')
                return;
            String s = new String(chs,start,chs.length-start);
            if (chs.length-start>3 || Integer.valueOf(s)>255)
                return;
            else{
                strs.append(s);
                res.add(strs.toString());
                return;
            }
        }

        int scope = 3;
        if (chs[start]=='0')
            scope=1;
        if (chs[start]-'0'>2)
            scope = 2;

        for (int i=1;i<=scope && start+i<chs.length;i++){
            String s = new String(chs,start,i);
            int num = Integer.valueOf(s);
            if (num>255)
                break;
            StringBuilder tmp = new StringBuilder(strs);
            tmp.append(s).append('.');
            dfs(res,chs,start+i,order+1,tmp);
        }
    }

    public static void main(String[] args){
        System.out.println(restoreIpAddresses("010010"));
    }


}

package com.company.algo.myLeetcode.string;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 19:06 2018/8/4
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0)return "";
        for (int i=0;i<strs.length;i++){
            if (strs[i]==null || strs[i].length()==0)
                return "";
        }
        boolean flag = false;//标志某个字符串以达到最大长度

        for (int len = 1;;len++){
            char c = ' ';
            if (len<=strs[0].length())
                c = strs[0].charAt(len-1);

            for (int i=0;i< strs.length;i++){
                if (!flag && len<=strs[i].length()){
                    if (c!=strs[i].charAt(len-1))
                        return strs[i].substring(0,len-1);
                    if (len==strs[i].length())
                        flag = true;
                }
                if (flag){
                    if (c!=strs[i].charAt(len-1))
                        return strs[i].substring(0,len-1);

                }
            }
            if (flag)
                return strs[0].substring(0,len);
        }
    }
}

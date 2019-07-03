package com.company.algo.myLeetcode.string;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 16:22 2018/8/4
 */
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        if (s.length()==0 && p.length()==0 || p.equals("*"))
            return true;
        if (p.length()==0)
            return false;

        boolean[][] res = new boolean[s.length()+1][p.length()+1];
        res[0][0] = true;
        for (int j=0;j<p.length();j++){
            if (p.charAt(j)=='*'){
                if (j<1){
                    for (int i=0;i<s.length();i++){
                        res[i][j+1] = true;
                    }
                    continue;
                }

                if (res[0][j])
                    res[0][j+1] = true;

                if (p.charAt(j-1)!='?'){
                    int i=0;
                    while (i<s.length() && !res[i+1][j])
                        i++;

                    while (i<s.length()){
                        res[i+1][j+1]=true;
                        i++;
                    }
                }else if (p.charAt(j-1)=='?'){
                    int i=0;
                    while (i<s.length() && !(res[i+1][j] || res[i][j-1]))
                        i++;
                    while (i<s.length()){
                        res[i+1][j+1] = true;
                        i++;
                    }
                }

            }else {
                for (int i=0;i<s.length();i++){
                    if (p.charAt(j)=='?' || p.charAt(j)==s.charAt(i)){
                        res[i+1][j+1] = res[i][j];
                    }
                }
            }
        }

        return res[s.length()][p.length()];

    }

    public static void main(String[] args){
        System.out.println(isMatch("c","*?*"));
    }
}

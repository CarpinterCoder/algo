package com.company.algo.myLeetcode.string;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 14:09 2018/8/5
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n<=0)return "";
        StringBuilder res = new StringBuilder("1");
        for (int i=2;i<=n;i++){
            String copy = res.toString();
            res.delete(0,copy.length());
            int num = 0;
            for (int j=0;j<copy.length();j++){
                char c = copy.charAt(j);
                if (j==0 || c!=copy.charAt(j-1)){
                    if (j>0){
                        res.append(num+Character.toString(copy.charAt(j-1)));
                    }
                    num = 0;
                    num++;
                }else if (c==copy.charAt(j-1)){
                    num++;
                }

                if (j==copy.length()-1){
                    res.append(num+Character.toString(c));
                }

            }

        }
        return res.toString();
    }
}

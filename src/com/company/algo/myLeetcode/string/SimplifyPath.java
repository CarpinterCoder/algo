package com.company.algo.myLeetcode.string;

import java.util.LinkedList;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 16:03 2018/8/5
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        // write your code here
        if (path==null || path.length()==0)
            return "";

        StringBuilder res = new StringBuilder("/");
        String[] strs = path.split("/");
        LinkedList<String> queue = new LinkedList<String>();
        for (int i=0;i<strs.length;i++){
            if ("..".equals(strs[i])){
                if (!queue.isEmpty()){
                    queue.pollFirst();
                }
            }else if (!".".equals(strs[i]) && !"".equals(strs[i])){
                queue.offerFirst(strs[i]);
            }
        }

        while (!queue.isEmpty()){
            res.append(queue.pollLast());
            if (!queue.isEmpty())
                res.append("/");
        }

        return res.toString();
    }
}

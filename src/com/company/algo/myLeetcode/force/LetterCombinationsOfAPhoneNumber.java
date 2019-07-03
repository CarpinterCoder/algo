package com.company.algo.myLeetcode.force;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 16:06 2018/8/10
 */
/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters just like on the telephone buttons.
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note: Although the above answer is in lexicographical order, your answer could be in any order you
 * want.
 *
 * */
public class LetterCombinationsOfAPhoneNumber {
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if (digits==null || digits.trim().length()==0){
            res.add("");
            return res;
        }

        HashMap<Character,String[]> map = new HashMap<Character, String[]>(10);
        map.put('0',new String[]{" "});
        map.put('1',new String[]{""});
        map.put('2',new String[]{"a","b","c"});
        map.put('3',new String[]{"d","e","f"});
        map.put('4',new String[]{"g","h","i"});
        map.put('5',new String[]{"j","k","l"});
        map.put('6',new String[]{"m","n","o"});
        map.put('7',new String[]{"p","q","r","s"});
        map.put('8',new String[]{"t","u","v"});
        map.put('9',new String[]{"w","x","y","z"});

        decare(digits,0,"",res,map);
        return res;
    }

    private void decare(String digits,int index, String obj, ArrayList<String> res, HashMap<Character, String[]> map) {
        if (index==digits.length())
            return;
        String[] dict = map.get(digits.charAt(index));
        if (index==digits.length()-1){
            for (int i=0;i<dict.length;i++){
                res.add(obj+dict[i]);
            }
            return;
        }
        for (int i=0;i<dict.length;i++){
            decare(digits,index+1,obj+dict[i],res,map);
        }
    }
}

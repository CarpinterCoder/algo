package com.company.algo.myLeetcode.array;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 14:09 2018/7/30
 */
/**
 *
 *
 * 思路
 *
 *  对于序列{1,2,...,n}的全排列：注：索引从0开始(0~n-1)
 *        当第一个数字确定以后，剩余n-1个数字有(n-1)!个全排列，因此第一个数字索引index=k/(n-1)!
 *        当第二个数字确定以后，剩余n-2个数有有(n-2)!个全排列，因此第二个数字索引index=(k%(n-1)!)/(n-2)!
 *        ...
 *        以此类推
 *
 * */
public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        int i=1;
        int product = 1;
        while (k>product)//k<=i!=product
            product*=(++i);

        int[] num = new int[i];//将1,2,...,n-1,n序列中后i个数按顺序加入数组num中
        int m = n;
        for (int j=i-1;j>=0;j--)
            num[j]=m--;

        k--;
        for (int p=i,objIndex=i-1;p>=1 && objIndex>=0;p--,objIndex--){
            product/=p;
            int srcIndex = k/product;//

            int temp = num[srcIndex];
            for (int x=srcIndex;x<=objIndex-1;x++){
                num[x] = num[x+1];
            }
            num[objIndex] = temp;
            k%=product;
        }
        StringBuilder sb = new StringBuilder();
        for (int y=1;y<=n-i;y++){
            sb.append(y);
        }

        for(int y=i-1;y>=0;y--){
            sb.append(num[y]);
        }

        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(getPermutation(2,2));
    }
}

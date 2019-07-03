package com.company.algo.myLeetcode.array;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 20:06 2018/7/28
 */
/**
 * 题目：求有序数组A、B的中位数
 *
 * 思路：见下面注释
 *
 * */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {

        int total = A.length+B.length;

        if ((total & 1)==1)
            //A、B数组的元素数量为奇数，取中间元素为中位数
            return findKth(A, B, total / 2 + 1);
        else
            //A、B数组的元素数量为偶数，取中间两个元素的平均值为中位数
            return (findKth(A, B, total / 2)+findKth(A, B, total / 2 + 1))/2.0;


    }

    //求A、B数组中第k大的数
    //比较A、B数组的第k/2个元素，较小者的前k/2个元素必然包含于前k个元素中，排除它们后剩下元素的第k/2大的数即为所求；按照此思路递归求解
    private int findKth(int[] A, int[] B, int k) {
        int loA = 0, loB = 0;
        while(loA<A.length && loB<B.length && k>1){

            int ia = (A.length-loA>k/2)?loA+k/2-1:A.length-1;
            int ib = (B.length-loB>k/2)?loB+k/2-1:B.length-1;
            if (A[ia]<B[ib]){
                k = k - (ia-loA+1);
                loA = ia + 1;
            }else if (B[ib]<A[ia]){
                k = k - (ib-loB+1);
                loB = ib + 1;
            }else {
                if ((k & 1)==1){
                    if (ia==A.length-1)
                        return B[ib+1];
                    else if (ib==B.length-1)
                        return A[ia+1];
                    else
                        return Math.min(A[ia+1],B[ib+1]);
                }else {
                    return A[ia];
                }
            }
        }

        if (loA==A.length)return B[loB+k-1];
        if (loB==B.length)return A[loA+k-1];

        return Math.min(A[loA],B[loB]);
    }


//    private int findKthElement(int[] A, int loA, int[] B, int loB, int k) {
//        if (loA==A.length)return B[loB+k-1];
//        if (loB==B.length)return A[loA+k-1];
//        if (A.length-loA>=k/2 && B.length-loB>=k/2){
//            if (A[loA+k/2-1]>B[loB+k/2-1])
//                loB = loB+k/2;
//            else if (A[loA+k/2-1]<B[loB+k/2-1])
//                loA = loA+k/2;
//            else
//                return A[loA+k/2-1];
//            return findKthElement(A,loA,B,loB,k-k/2);
//        }else if (A.length-loA<k/2 && B.length-loB>=k/2){
//            if (A[A.length-1]<B[loB+k/2-1])
//                return findKthElement(A,A.length,B,loB,k-(A.length-loA));
//            else if (A[A.length-1]>=B[loB+k/2-1])
//                loB = loB+k/2;
//            return findKthElement(A,loA,B,loB,k/2);
//
//        }else if (A.length-loA>=k/2 && B.length-loB<k/2){
//            if (A[loA+k/2-1]>B[B.length-1])
//                return findKthElement(A,loA,B,B.length-1,k-(B.length-loB));
//            else if (A[loA+k/2-1]<=B[B.length-1])
//                loA = loA + k/2;
//            return findKthElement(A,loA,B,loB,k/2);
//        }else {
//            return Math.max(A[A.length-1],B[B.length-1]);
//        }
//    }


}

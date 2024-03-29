package com.company.algo.sort.heap;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 12:09 2018/6/10
 */
/**
 * 堆排序利用了大根堆（或小根堆）堆顶记录的关键字最大（或最小）这一特征， 使得在当前无序区中选取最大（或最小）关键字的记录变得简单。
 * （1）用大根堆排序的基本思想 ① 先将初始文件R[1..n]建成一个大根堆，此堆为初始的无序区 ②
 * 再将关键字最大的记录R[1]（即堆顶）和无序区的最后一个 记录R[n]交换，由此得到新的无序区R[1..n-1]和有序区R[n]，
 * 且满足R[1..n-1].keys≤R[n].key ③由于交换后新的根R[1]可能违反堆性质，故应将当前无序区R[1..n-1]调整为堆。
 * 然后再次将R[1..n-1]中关键字最大的记录R[1]和该区间的最后一个记录R[n-1]交换，
 * 由此得到新的无序区R[1..n-2]和有序区R[n-1..n]，
 * 且仍满足关系R[1..n-2].keys≤R[n-1..n].keys，同样要将R[1..n-2]调整为堆。 直到无序区只有一个元素为止。
 * （2）大根堆排序算法的基本操作： ① 初始化操作：将R[1..n]构造为初始堆； ②
 * 每一趟排序的基本操作：将当前无序区的堆顶记录R[1]和该区间的最后一个记录交换， 然后将新的无序区调整为堆（亦称重建堆）。
 */
public class MaxHeap {
    public void sort(int[] data){
        Heap h = new Heap();
        h.init(data);
        for (int i=0;i<data.length;i++){
            h.remove();
            h.fixDown(1);
        }
        System.arraycopy(h.queue,1,data,0,data.length);
    }
    //大根堆
    public class Heap{
        int size;
        int[] queue;
        public void init(int[] data){
            queue = new int[data.length+1];
            for (int k=0;k<data.length;k++){
                queue[++size] = data[k];
                fixUp(size);
            }
        }
        public void remove(){
            exch(queue,1,size--);
        }
        public void fixUp(int k) {
            while (k>1){
                int j = k/2;
                if (queue[j]>queue[k])
                    break;
                exch(queue,k,j);
                k = j;
            }
        }
        public void fixDown(int k){
            while (2*k<size){
                int j = 2*k;
                if (j<size && queue[j]<queue[j+1])
                    j++;
                if(queue[k]>queue[j])
                    break;
                exch(queue,k,j);
                k = j;
            }
        }
    }
    private void exch(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }
}

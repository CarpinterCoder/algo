package com.company.algo.myLeetcode.sort.basic;

/**
 * @Description:
 * @Author:XiaoNing
 * @Date:Greated in 22:22 2018/7/23
 */
/**
 * 大(小)根堆概念：根节点值必定大(小)于其两个子节点的值
 *          特点：根节点值就是其最大(小)值
 *
 * (大根)堆排序：在构造大根堆的时候，依次将数组中的元素添加到另一个数组(索引从1开始)，
 *              然后将新元素从数组尾部按照大根堆的规则上浮到合适的位置(重新达到平衡)，
 *              待整个大根堆构建好以后，将大根堆的根节点与数组最后一个元素调换，size--，
 *              将根节点下沉，重新达到平衡以后，重复同样的操作，数组后半段逐渐形成有序区
 *
 * 时间复杂度：O(NlgN)
 * 空间消耗：O(N)
 *
 *
 */
public class MaxHeapSort {
    public void sort(int[] data){
        MaxHeap heap = new MaxHeap();
        heap.init(data);
        for (int i=0;i<data.length;i++)
            heap.remove();
        System.arraycopy(heap.queue,1,data,0,data.length);
    }

    private class MaxHeap{
        int size = 0;
        int[] queue;

        public void init(int[] data){
            queue = new int[data.length+1];
            for (int i=0;i< data.length;i++){
                queue[++size] = data[i];
                fixUp(size);
            }
        }

        private void fixUp(int k) {
            while (k>1){
                int j = k/2;
                if (queue[j]>=queue[k])
                    break;
                SortUtils.swap(queue,k,j);
                k=j;
            }
        }

        public void remove() {
            SortUtils.swap(queue,1,size--);
            fixDown(1);
        }

        private void fixDown(int k) {
            while (k<size){
                int j = 2*k;
                if (j<size && queue[j]<queue[j+1])
                    j++;
                if (queue[k]>=queue[j])
                    break;
                SortUtils.swap(queue,k,j);
                k=j;
            }
        }
    }
}

package com.lu.practice.list;

/**
 * @Author lupeng
 * @Date 2022/8/5
 */
    public class MaxPQ<Key extends Comparable<Key>> {
        // 存储元素的数组
        private Key[] pq;
        // 当前 Priority Queue 中的元素个数
        private int size = 0;

        public MaxPQ(int cap) {
            // 索引 0 不用，所以多分配一个空间
            pq = (Key[]) new Comparable[cap + 1];
        }

        /* 返回当前队列中最大元素 */
        public Key max() {
            return pq[1];
        }

        /* 插入元素 e */
        public void insert(Key e) {
            size++;
            pq[size] = e;
            swim(size);
        }

        /* 删除并返回当前队列中最大元素 */
        public Key delMax() {
            Key max = pq[1];
            swap(1,size);
            pq[size] = null;
            size--;
            sink(1);
            return max;

        }

        /* 上浮第 x 个元素，以维护最大堆性质 */
        private void swim(int x) {
            // 如果浮到堆顶，就不能再上浮了
            while (x > 1 && less(parent(x), x)) {
                // 如果第 x 个元素比上层大
                // 将 x 换上去
                swap(parent(x), x);
                x = parent(x);
            }
        }

        /* 下沉第 x 个元素，以维护最大堆性质 */
        private void sink(int x) {
            while (left(x) <= size){
                //假设左边子节点最大
                int max = left(x);
                //如果存在右边子节点，比一下大小
                if (right(x) <= size && less(max,right(x))){
                    max = right(x);
                }
                //如果节点比两个子节点大不用下沉
                if (less(max,x)){
                    break;
                }
                swap(x,max);
                x = max;
            }
        }

        /* 交换数组的两个元素 */
        private void swap(int i, int j) {
            Key temp = pq[i];
            pq[i] = pq[j];
            pq[j] = temp;
        }

        /* pq[i] 是否比 pq[j] 小？ */
        private boolean less(int i, int j) {
            return pq[i].compareTo(pq[j]) < 0;
        }

        /* 还有 left, right, parent 三个方法 */
   // 父节点的索引
        int parent(int root) {
            return root / 2;
        }
    // 左孩子的索引
    int left(int root) {
        return root * 2;
    }
    // 右孩子的索引
    int right(int root) {
        return root * 2 + 1;
    }
    }


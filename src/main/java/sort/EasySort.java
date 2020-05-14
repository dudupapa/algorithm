package sort;

/**
 * @author: yandan
 * @date: 2020/5/11
 * @description:
 */
public class EasySort {

    public static void main(String[] args) {
        int[] array = {4,5,6,1,3,2};
        int length = array.length;

        //bubbleSort(array,length);

        //insertSort(array,length);

        selectSort(array,length);
    }

    /**
     * 选择排序：将数组分为有序区和无序区，从无序区取最小值与无序区第一个元素交换，从而保证有序区一直有序，无序区为空即可
     *      初始时有序区大小为0
     * @param array
     * @param length
     */
    private static void selectSort(int[] array, int length) {
        if(length<=1) {
            return;
        }
        for(int i=0;i<length-1;i++) {
            //进行第i次比较，交换
            int k=i;
            //将当前元素与后面的元素依次比较，
            for(int j=k+1;j<length;j++) {
                if(array[j] < array[k]) {
                    //记录当前最小值所在的下标
                    k = j;
                }
            }
            //无序区最小值和无序区第一个元素交换
            if(k!=i) {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
    }

    /**
     * 插入排序
     * @param a
     * @param n
     */
    private static void insertSort(int[] a, int n) {
        if(n<=1) {
            return;
        }
        //进行n-1次插入操作，保证每次插入之后有序区间一直有序;i的位置为待插入数据的下标,a[i]为待插入到有序区的值
        for(int i=1;i<n;i++) {
            int value = a[i];
            int j=i-1;
            //从尾往头遍历有序区的数据，与待插入的值对比，将待插入的数据放置到合适位置
            for(;j>=0;j--) {
                if(a[j]>value) {
                    //a[j]需要往后搬移一位，给待插入的值腾位置
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            //数据插入到寻找到的位置，为什么下标是j+1着重理解下
            a[j+1] = value;
        }
    }


    /**
     * 冒泡排序(理论意义多，实际用的少)
     * @param a 待排序数组
     * @param n 数组长度
     */
    public static void bubbleSort(int[] a,int n) {
        if(n<=1) {
            return;
        }
        //进行n次冒泡，每一次冒泡会将一个元素放到正确位置
        for(int i=0;i<n;i++) {
            //单次冒泡排序过程，数据比较+交换
            for(int j=0;j<n-i-1;j++) {
                if(a[j]>a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}

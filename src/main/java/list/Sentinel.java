package list;

/**
 * @author: yandan
 * @date: 2020/5/14
 * @description: 哨兵用法避免边界处理异常
 */
public class Sentinel {

    public static void main(String[] args) {
        char[] array={'h','e','l','l','o'};
        int len = array.length;

        //int res = find(array, len,'l');

        int res = findWithSentinel(array,len,'k');
        System.out.println(res);
    }

    /**
     * 在数组中查找key对应的位置
     * @param a
     * @param n
     * @param key
     * @return
     */
    public static int find(char[] a,int n,char key) {
        //边界条件处理，传入的数组为空则不需要进行下面的处理
        if(a==null || n<=0) {
            return -1;
        }
        //i用于记录key对应的位置
        for(int i=0;i<n;i++) {
            if(a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 通过引入哨兵查找,避免循环中i和n的比较
     * @param a
     * @param n
     * @param key
     * @return
     */
    public static int findWithSentinel(char[] a, int n, char key) {
        if(a==null || n<=0) {
            return -1;
        }

        //将a数组的最后一个元素赋值给临时变量，待查找完成后再恢复，避免因为该方法改变了原始数组的内容
        char temp = a[n-1];
        //对a[n-1]做额外处理
        if(key == a[n-1]) {
            return n-1;
        }
        //引入哨兵
        a[n-1] = key;
        int i=0;
        while(key != a[i]) {
            i++;
        }
        //恢复原始数组
        a[n-1] = temp;

        if(i==n-1) {
            //如果i==n-1，说明一直没有找到，a[n-1]是哨兵的值，不是真实找到的，所以返回-1；
            return -1;
        } else {
            //key元素的下标
            return i;
        }

    }

}

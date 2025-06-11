package 数据结构.link.约瑟夫问题;


/**
 * Created by lixin on 2020/8/9.
 *
 * 约瑟夫问题:
 * 约瑟夫问题是个有名的问题：N个人围成一圈，从第一个开始报数，第M个将被杀掉，最后剩下一个，其余人都将被杀掉。
 * 例如N=8，M=3，被杀掉的顺序是：3 , 6 , 1 , 5 , 2 , 8 , 4 , 7
 */
class TestLinkedListJoseph {

    public static void main(String[] args) {
        int n = 8;
        int m = 3;

        LinkedListJoseph<Integer> integerList = new LinkedListJoseph<>();
        for (int i = 1; i <= n; i++) {
            integerList.add(i);
        }


        //开始
        integerList.reset();
        while (!integerList.isEmpty()){
            for (int i = 1; i < m; i++) {
                integerList.next();
            }
            Integer remove = integerList.remove();
            System.out.print(remove + " , ");
        }

    }
}

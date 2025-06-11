package java基础;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * 日期 : 2021/10/26.
 * 创建 : xin.li
 * 描述 :
 */
class OrderTest {

    public static void main(String[] args) {
        List<OrderBean> sorts = new LinkedList<OrderBean>(Arrays.asList(
                new OrderBean(8, 10, "西安"),
                new OrderBean(10, 11, "西安"),
                new OrderBean(12, 13, "西安"),

                new OrderBean(13, 14, "北京"),
                new OrderBean(15, 27, "北京"),
                new OrderBean(15, 16, "北京"),
                new OrderBean(16, 17, "北京"),
                new OrderBean(19, 20, "北京"),
                new OrderBean(26, 27, "北京"),

                new OrderBean(29, 30, "北京"),
                new OrderBean(30, 31, "上海"),
                new OrderBean(31, 32, "北京")
        ));

        List<OrderBean> sorts2 = new LinkedList<OrderBean>(Arrays.asList(

                new OrderBean(19, 20, "西安"),
                new OrderBean(19, 20, "北京"),
                new OrderBean(22, 23, "北京"),
                new OrderBean(20, 21, "北京"),
                new OrderBean(19, 22, "北京"),
                new OrderBean(22, 23, "北京"),
                new OrderBean(18, 19, "北京")

        ));
        sortOrder2(sorts2);

    }
    static void sortOrder2(List<OrderBean> sorts){
        List<OrderBean> sortedList = new LinkedList<OrderBean>();
        OrderBean currentItem = sorts.get(0);
        sortedList.add(new OrderBean("我是title:" + currentItem.getCity()));
        sortedList.add(currentItem);
        int mergeEnd = 0;//3
        for (int i = 1; i < sorts.size(); i++) {
            currentItem = sorts.get(i);
            int currentStartDate = currentItem.getStartDate();
            int currentEndDate = currentItem.getEndDate();
            for (int j = i - 1; j >= 0; j--) {
                OrderBean previousItem = sorts.get(j);
                if (!currentItem.getCity().equalsIgnoreCase(previousItem.getCity())){
                    //相同城市下的日期比对完成发现没有交集, 比对到不一致城市, 添加title
                    sortedList.add(new OrderBean("我是title:" + currentItem.getCity()));
                    mergeEnd = i;
                    break;
                }
                int previousStartDate = previousItem.getStartDate();
                int previousEndDate = previousItem.getEndDate();
                if (currentStartDate > previousEndDate || currentEndDate < previousStartDate){
                    if (j == mergeEnd){
                        //扫描到达该合并集合末尾, 发现日期没有交集
                        sortedList.add(new OrderBean("我是title:" + currentItem.getCity()));
                        mergeEnd = i;
                        break;
                    }
                } else {
                    //订单日期有交集
                    break;
                }
            }
            sortedList.add(currentItem);
        }
        System.out.println(sortedList);
    }
    static void sortOrder(List<OrderBean> sorts){
        List<OrderBean> sortedList = new LinkedList<OrderBean>();
        OrderBean currentItem = sorts.get(0);
        sortedList.add(new OrderBean("我是title:" + currentItem.getCity()));
        sortedList.add(currentItem);
        for (int i = 1; i < sorts.size(); i++) {
            currentItem = sorts.get(i);
            int currentStartDate = currentItem.getStartDate();
            int currentEndDate = currentItem.getEndDate();
            int mergeEnd = 0;
            for (int j = i - 1; j >= mergeEnd; j--) {
                OrderBean previousItem = sorts.get(j);
                if (!currentItem.getCity().equalsIgnoreCase(previousItem.getCity())){
                    //相同城市下的日期比对完成发现没有交集, 比对到不一致城市, 添加title
                    sortedList.add(new OrderBean("我是title:" + currentItem.getCity()));
                    mergeEnd = i;
                    break;
                }
                int previousStartDate = previousItem.getStartDate();
                int previousEndDate = previousItem.getEndDate();
                if (!(currentStartDate > previousEndDate || currentEndDate < previousStartDate)){
                    //订单日期有交集
                    break;
                }
                if (j == 0){
                    //城市一致, 日期没有交集
                    sortedList.add(new OrderBean("我是title:" + currentItem.getCity()));
                    mergeEnd = i;
                }
            }
            sortedList.add(currentItem);
        }
        System.out.println(sortedList);
    }

    public static void main1(String[] args) {
        List<OrderBean> sorts = new LinkedList<OrderBean>(Arrays.asList(
                new OrderBean(26, 28, "北京"),
                new OrderBean(27, 29, "西安"),
                new OrderBean(28, 31, "北京"),
                new OrderBean(29, 34, "上海"),
                new OrderBean(29, 30, "北京"),
                new OrderBean(34, 35, "北京"),
                new OrderBean(34, 35, "上海"),
                new OrderBean(34, 36, "北京")
        ));

        for (int i = 0; i < sorts.size(); i++) {
            int currentIndex = i;
            for (int j = i+1; j < sorts.size(); j++) {
                OrderBean currentItem = sorts.get(currentIndex);
                OrderBean nextItem = sorts.get(j);
                if (!currentItem.getCity().equalsIgnoreCase(nextItem.getCity())){
                    //城市不一致,不合并
                    break;
                }
                if (nextItem.getStartDate() <= currentItem.getEndDate()){
                    //订单日期有交集,合并
                    currentIndex++;
                    sorts.remove(nextItem);
                    sorts.add(currentIndex, nextItem);
                }
            }
        }
        System.out.println(sorts);
        
    }

    private static boolean compareOrder(OrderBean first, OrderBean second){
        return second.getStartDate() <= first.getEndDate();
    }

    static class OrderBean{
        int startDate;
        int endDate;
        String city;

        @Override
        public String toString() {
            return city + "-" + startDate + "-" + endDate + "\n";
        }

        public OrderBean(String city) {
            this.city = city;
        }

        public OrderBean(int startDate, int endDate, String city) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.city = city;
        }

        public int getStartDate() {
            return startDate;
        }

        public void setStartDate(int startDate) {
            this.startDate = startDate;
        }

        public int getEndDate() {
            return endDate;
        }

        public void setEndDate(int endDate) {
            this.endDate = endDate;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}

package java基础;


import java.util.*;

import static java.util.Calendar.*;

public class Filter {


    public static void main2(String[] args) {
        List<String> bedFilters = new ArrayList<String>();
    }

    public static final String URI_WEB_VIEW = "slscheme://app/WebView?url=";

    public static void main3(String[] args) {
//        Object aaa = null;
//        System.out.println((String) aaa);

//        String aaa = URI_WEB_VIEW + "https://uat-m.shangri-la.com/cn/touch/coupon-detail?dealCode=VSLCDRP003&aaa=bbb&time=+8";
//        System.out.println(aaa);
//        System.out.println(aaa.replace(URI_WEB_VIEW, ""));

//        LinkedHashMap<String, Object> nameValuePairs = new LinkedHashMap<>();
//        System.out.println(nameValuePairs.get("fsdf"));


//        Calendar instance = Calendar.getInstance();
//        System.out.println(instance.getTimeZone().getDisplayName() + instance.getTime().toString());
//        instance.setTimeZone(TimeZone.getTimeZone("GMT-11:00"));
//        System.out.println(instance.getTimeZone().getDisplayName() + instance.getTime().toString());
//        instance.setTimeZone(TimeZone.getTimeZone("GMT+11:00"));
//        System.out.println(instance.getTimeZone().getDisplayName() + instance.getTime().toString());


//        byte[] array = {1, 0, 64, 0, 0, 0, 105, 0, 1, 0, 17, 3, 17, 37, 21, 0, 0};
//
//        System.out.println(bytesToInt(array, 0));

        Calendar instance = Calendar.getInstance(TimeZone.getDefault(), Locale.JAPANESE);
        instance.set(DAY_OF_MONTH, 1);
        instance.add(DAY_OF_MONTH, 4);
        printlnCalendar(instance);
        int offset = instance.getFirstDayOfWeek() - instance.get(DAY_OF_WEEK);
        if (offset > 0) {
            offset -= 7;
        }
        System.out.println(instance.getFirstDayOfWeek());
//        instance.add(Calendar.DATE, -2);
        printlnCalendar(instance);

    }

    public static void printlnCalendar(Calendar instance){
        System.out.println(instance.get(Calendar.YEAR) + "-" + instance.get(Calendar.MONTH) + "-星期" + instance.get(DAY_OF_WEEK) + "-" + instance.get(Calendar.DATE));
    }


    public static int bytesToInt(byte[] src, int offset) {
        int value;
        value = (int) ((src[offset] & 0xFF)
                | ((src[offset+1] & 0xFF)<<8)
                | ((src[offset+2] & 0xFF)<<16)
                | ((src[offset+3] & 0xFF)<<24));
        return value;
    }

    public static void main(String[] args) {
        // A数组
        String[] arrayA = {"A", "AA", "b", "BBB", "BBB", "D", "D", "DDD", "EFG"};

        // B数组
        String[] arrayB = {"D", "A", "C"};

        // 使用HashMap记录A和B数组中各元素的出现次数
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();

        // 遍历A数组，记录元素的出现次数
        for (String item : arrayA) {
            mapA.put(item, mapA.getOrDefault(item, 0) + 1);
        }

        // 遍历B数组，记录元素的出现次数
        for (String item : arrayB) {
            mapB.put(item, mapB.getOrDefault(item, 0) + 1);
        }

        // 创建一个新的HashMap用于存放结果
        Map<String, Integer> resultMap = new HashMap<>();

        // 遍历A数组，找出与B数组相同的元素及其出现次数
        for (Map.Entry<String, Integer> entry : mapA.entrySet()) {
            String key = entry.getKey();
            int countA = entry.getValue();
            int countB = mapB.getOrDefault(key, 0);

            // 取两者的较小值，即为交集元素的出现次数
            int intersectionCount = Math.min(countA, countB);

            // 将交集元素及其出现次数加入结果集合
            if (intersectionCount > 0) {
                resultMap.put(key, intersectionCount);
            }
        }

        // 输出结果
        System.out.println(resultMap.keySet());
    }
}

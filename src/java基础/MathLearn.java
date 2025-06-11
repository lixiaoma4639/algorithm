package java基础;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by lixin on 2020/8/15.
 */
class MathLearn {

    public static void main(String[] args) {

//        Object fff= null;
//        String ccc = (String) fff;
//        System.out.println(ccc);
//
//        String ddd = "";
//        String[] split = ddd.split("&");
//        System.out.println(split);
//        System.out.println(split.length);

    }

    static int getIndexOfKey(String key) {
        Integer integer = null;
        return integer;
    }

    public static void main6(String[] args) {
        int aaa = 87;
        float b = 100/3;
        float c = 100/3;
        float d = 100/3;
        System.out.println(Math.round(b) + Math.round(c) + Math.round(d));


    }


    public static void main5(String[] args) {
//        int aaa = (int) Math.ceil(21f/10);
//        System.out.println(aaa);
//        List<String> sss = new ArrayList<>();
//        sss.add("1");
//        sss.add("2");
//        sss.add("3");
//        for (String aaa: sss) {
//            System.out.println(aaa);
//        }
//        sss.remove(null);
//        System.out.println(sss.size());

        String s = "シャングリ・ラにご滞在いただくと、宿泊数";
        s = "ダイヤモンド会員まであと15,000ティアポイント";
        s = "ご滞在またはお食事でティアポイントを獲得";
        s = "ジェイド会員まであと6,000ティアポイント";
        s = "ダイヤモンド会員まであと1,000,015,000ティアポイント";
        System.out.println(s.length());
        System.out.println(s.toCharArray().length);

    }

    public static void main4(String[] args) {
//        List<Integer> integers = Arrays.asList(12, 20, 22,25, 75, 80, 110, 15, 11, 14, 22, 24, 24, 186);
//        for (int aaa: integers ) {
//            System.out.println(aaa + " = " + (aaa / 12f * 10));
//        }

        Set<Integer> intSet = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            intSet.add(i);
        }
        System.out.println(intSet);
    }



    public static void main3(String[] args) {
//        Map<String ,Object> map = new HashMap<>();
//        for (Map.Entry<String , Object> entry : map.entrySet()) {
//            System.out.println(entry);
//        }

//        System.out.println((float) Math.sin(Math.toRadians(0)));
//        System.out.println((float) Math.sin(Math.toRadians(30)));
//        System.out.println((float) Math.sin(Math.toRadians(90)));
//        System.out.println((float) Math.sin(Math.toRadians(120 % 90)));
//        System.out.println((float) Math.sin(Math.toRadians(210 % 90)));
//        System.out.println((float) Math.sin(Math.toRadians(300 % 90)));
//        System.out.println("-------");
//        System.out.println((float) Math.cos(Math.toRadians(0)));
//        System.out.println((float) Math.cos(Math.toRadians(30)));
//        System.out.println((float) Math.cos(Math.toRadians(60)));
//        System.out.println(Math.cos(Math.toRadians(90)));
        System.out.println("-------");
//        System.out.println((float) Math.sin(0/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.sin(30d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.sin(60d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.sin(90d/ 360d * 2 * Math.PI));
//
//        System.out.println((float) Math.sin(120d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.sin(150d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.sin(180d/ 360d * 2 * Math.PI));
//
//        System.out.println((float) Math.sin(210d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.sin(240d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.sin(270d/ 360d * 2 * Math.PI));
//
//        System.out.println((float) Math.sin(300d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.sin(330d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.sin(360d/ 360d * 2 * Math.PI));


        System.out.println((float) Math.sin(0/ 180d * Math.PI));
        System.out.println((float) Math.sin(30d/ 180d * Math.PI));
        System.out.println((float) Math.sin(60d/ 180d * Math.PI));
        System.out.println((float) Math.sin(90d/ 180d * Math.PI));

        System.out.println((float) Math.sin(120d/ 180d * Math.PI));
        System.out.println((float) Math.sin(150d/ 180d * Math.PI));
        System.out.println((float) Math.sin(180d/ 180d * Math.PI));

        System.out.println((float) Math.sin(210d/ 180d * Math.PI));
        System.out.println((float) Math.sin(240d/ 180d * Math.PI));
        System.out.println((float) Math.sin(270d/ 180d * Math.PI));

        System.out.println((float) Math.sin(300d/ 180d * Math.PI));
        System.out.println((float) Math.sin(330d/ 180d * Math.PI));
        System.out.println((float) Math.sin(360d/ 180d * Math.PI));

//        System.out.println((float) Math.cos(0/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.cos(30d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.cos(60d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.cos(90d/ 360d * 2 * Math.PI));
//
//        System.out.println((float) Math.cos(120d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.cos(150d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.cos(180d/ 360d * 2 * Math.PI));
//
//        System.out.println((float) Math.cos(210d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.cos(240d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.cos(270d/ 360d * 2 * Math.PI));
//
//        System.out.println((float) Math.cos(300d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.cos(330d/ 360d * 2 * Math.PI));
//        System.out.println((float) Math.cos(360d/ 360d * 2 * Math.PI));
    }
    
    
    public static void main2(String[] args) {
        int a = 3 ;
        int b = 2;

        //a 的 b次方幂
        double c = Math.pow(a , b);
        System.out.println("c = " + c);
    }
}

package java基础;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 日期 : 2021/9/13.
 * 创建 : xin.li
 * 描述 :
 */
class InputMath {

    public static void main(String[] args) {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    throw new NullPointerException("hjjj...");
                }
            }).start();
            System.out.println("fff");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static int initSdk() {
        Object object = getAAA();
        return (Integer)object;
    }
    private static Object getAAA() {
        return null;
    }

    public static void main4(String[] args) {
        int aa = 1;
        if (aa >=0 && aa <= 1){
            System.out.println(1);
        } else if(aa >= 1 && aa <= 2){
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }

    public static void main5(String[] args) {
        List<StarNode> starTimes = new ArrayList<>();
        starTimes.add(new StarNode(0f, 0.016f, 0,true));
        starTimes.add(new StarNode(0.016f, 0.08f, 0,false));
        starTimes.add(new StarNode(0.08f, 0.128f, 1,false));
        starTimes.add(new StarNode(0.128f, 0.136f, 2,true));
        starTimes.add(new StarNode(0.136f, 0.164f, 2,false));
        starTimes.add(new StarNode(0.164f, 0.348f, 3,true));
        starTimes.add(new StarNode(0.348f, 0.392f, 3,false));
        starTimes.add(new StarNode(0.392f, 0.436f, 4,false));
        starTimes.add(new StarNode(0.436f, 0.504f, 5,true));
        starTimes.add(new StarNode(0.504f, 0.544f, 5,false));
        starTimes.add(new StarNode(0.544f, 0.556f, 6,true));
        starTimes.add(new StarNode(0.556f, 0.576f, 6,false));
        starTimes.add(new StarNode(0.576f, 0.676f, 7,true));
        starTimes.add(new StarNode(0.676f, 0.732f, 7,false));
        starTimes.add(new StarNode(0.732f, 0.748f, 8,false));
        starTimes.add(new StarNode(0.748f, 0.76f, 9,true));
        starTimes.add(new StarNode(0.76f, 0.808f, 9,false));
        starTimes.add(new StarNode(0.808f, 0.876f, 10,false));
        starTimes.add(new StarNode(0.876f, 0.888f, 11,true));
        starTimes.add(new StarNode(0.888f, 0.936f, 11,false));
        starTimes.add(new StarNode(0.936f, 0.968f, 12,false));
        starTimes.add(new StarNode(0.968f, 1f, 13,true));

        List<StarNode> dotTimes = new ArrayList<>();
        dotTimes.add(new StarNode(0f, 0.008f, 0,false));
        dotTimes.add(new StarNode(0.008f, 0.08f, 1,false));
        dotTimes.add(new StarNode(0.08f, 0.128f, 2,false));
        dotTimes.add(new StarNode(0.128f, 0.136f, 3,true));
        dotTimes.add(new StarNode(0.136f, 0.164f, 3,false));
        dotTimes.add(new StarNode(0.164f, 0.348f, 4,true));
        dotTimes.add(new StarNode(0.348f, 0.392f, 4,false));
        dotTimes.add(new StarNode(0.392f, 0.436f, 5,false));
        dotTimes.add(new StarNode(0.436f, 0.504f, 6,true));
        dotTimes.add(new StarNode(0.504f, 0.544f, 6,false));
        dotTimes.add(new StarNode(0.544f, 0.556f, 7,true));
        dotTimes.add(new StarNode(0.556f, 0.576f, 7,false));
        dotTimes.add(new StarNode(0.576f, 0.676f, 8,true));
        dotTimes.add(new StarNode(0.676f, 0.732f, 8,false));
        dotTimes.add(new StarNode(0.732f, 0.748f, 9,false));
        dotTimes.add(new StarNode(0.748f, 0.76f, 10,true));
        dotTimes.add(new StarNode(0.76f, 0.808f, 10,false));
        dotTimes.add(new StarNode(0.808f, 0.876f, 11,false));
        dotTimes.add(new StarNode(0.876f, 0.888f, 12,true));
        dotTimes.add(new StarNode(0.888f, 0.936f, 12,false));
        dotTimes.add(new StarNode(0.936f, 0.968f, 13,false));
        dotTimes.add(new StarNode(0.968f, 1f, 14,true));

        System.out.println(starTimes.size());
        System.out.println(dotTimes.size());
    }

    private static class StarNode{
        public float startTime;
        public float endTime;
        public boolean keep;
        public StarNode(float startTime, float endTime, int index,boolean keep ) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.keep = keep;
        }

        @Override
        public String toString() {
            return "startTime: " + startTime + ", endTime: " + endTime;
        }
    }

    public static void main2(String[] args) {
        List<Float> floats = Arrays.asList(0.67f, 0.84f, 9.96f);
        float total = 0;
        for (float item : floats) {
            float input = time2Input(item);
            total += input;
            System.out.print("时间" + item + "转换为input: " + input + " ; ");
        }
        System.out.println();
        System.out.println("总数为: " + total);
    }



    static Float time2Input(float time){
        return time / 10f;
    }
}

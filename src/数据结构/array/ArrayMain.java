package 数据结构.array;

/**
 * Created by lixin on 2020/6/24.
 */
class ArrayMain {
    public static void main(String[] args) {
//        ArrayStudy<Integer> arrayStudy = new ArrayStudy<>();
//
//        for (int i = 0; i < 10; i++) {
//            arrayStudy.add(i);
//        }
//        arrayStudy.add(null);
//        for (int i = 0; i < 10; i++) {
//            PersonBean personBean = new PersonBean("李鑫" + String.valueOf(i) , i);
//            arrayStudy.add(personBean);
//        }

//        System.out.println(arrayStudy.toString());
//        arrayStudy.remove(5);
//        System.gc();
//        System.out.println(arrayStudy.toString());
//        System.out.println(arrayStudy.contains(5));
//        System.out.println(arrayStudy.indexOf(null));

//        arrayStudy.add(arrayStudy.size() , 100);
//        arrayStudy.set(3, 88);
//        arrayStudy.remove(3);
//        arrayStudy.clear();
//        arrayStudy.size();

        //扩容缩容验证
        ArrayStudy<Integer> arrayStudy = new ArrayStudy<>();
        for (int i = 0; i < 50; i++) {
            arrayStudy.add(i);
        }
        for (int i = 0; i < 50; i++) {
            arrayStudy.remove(0);
        }


    }
}

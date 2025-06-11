package java基础;

/**
 * 日期 : 2021/6/7.
 * 创建 : xin.li
 * 描述 :
 */
class BaseLifeLearn {
    private static String aaa = print("1");
    public BaseLifeLearn() {
        print("4");
    }


    private String aaa111 = print("3");
    static {
        print("a");
    }

    {
        print("aa");
    }





    protected static String print(String aaa) {
        System.out.println("我是 " + aaa);
        return "我是 " + aaa;
    }
}

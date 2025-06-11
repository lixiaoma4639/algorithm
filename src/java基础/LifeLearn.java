package java基础;

/**
 * 日期 : 2021/6/7.
 * 创建 : xin.li
 * 描述 :
 */
class LifeLearn extends BaseLifeLearn{
    private static String aaaBBB = print("2");
    private String aaa111 = print("5");

    static {
        print("b");
    }

    {
        print("bb");
    }


    public LifeLearn() {
        print("6");
    }

    public static void main(String[] args) {
        LifeLearn lifeLearn = new LifeLearn();
    }
}

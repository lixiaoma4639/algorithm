package java基础;

public class ComObject {
    public static void main(String[] args) {
        ComObject comObject = new ComObject();
        ComObject.AAA aaa = comObject.new AAA();
    }

    private class AAA{

    }
}

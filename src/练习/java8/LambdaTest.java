package 练习.java8;

/**
 * Created by lixin on 2020/8/6.
 *
 * 以下是lambda表达式的重要特征:
 * 1.可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
 * 2.可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
 * 3.可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
 * 4.可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
 *
 * 使用 Lambda 表达式需要注意以下两点：
 * 1.Lambda 表达式主要用来定义行内执行的方法类型接口,其实lambda整体就是匿名对象，例如，一个简单方法接口。在上面例子中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法。然后我们定义了sayMessage的执行。
 * 2.Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
 * 3.Lambda 因为Lambda是对接口中方法的执行,因此可以不用生命参数类型,参数类型与接口中方法的参数类型一致
 */
class LambdaTest {
    public static void main(String args[]){

        LambdaTest tester = new LambdaTest();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}

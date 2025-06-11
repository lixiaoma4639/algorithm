package 数据结构_树.二叉搜索树;

/**
 * 日期 : 2020/8/24.
 * 创建 : xin.li
 * 描述 :
 */
public class Person implements Comparable<Person>{

    private int age;
    private String name;

    public Person(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
//        int result = age - person.age;
//        return result > 0 ? 1 : (result == 0 ? 0 : -1);
        return age - person.age;
    }

    @Override
    public String toString() {
        return age+"";
    }
}

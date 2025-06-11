package 数据结构.array;

/**
 * Created by lixin on 2020/6/28.
 */
class PersonBean {

    private String name;
    private int age;

    public PersonBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {

        return "{" + name + ", " + age + "}";
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize : 被回收了");
    }
}

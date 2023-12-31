package 单例模式;

/**
 *
 *
 *
 Java规范中规定，每一个枚举类型极其定义的枚举变量在JVM中都是唯一的，
 因此在枚举类型的序列化和反序列化上，Java做了特殊的规定。
 在序列化的时候Java仅仅是将枚举对象的name属性输出到结果中，
 反序列化的时候则是通过 java.lang.Enum 的 valueOf() 方法来根据名字查找枚举对象。
 也就是说，以下面枚举为例，序列化的时候只将 DATASOURCE 这个名称输出，
 反序列化的时候再通过这个名称，查找对于的枚举类型，因此反序列化后的实例也会和之前被序列化的对象实例相同。

 public enum DataSourceEnum {
    DATASOURCE;
 }
 */

//使用枚举，可以实现单例, 推荐
enum Singleton8 {
    INSTANCE; //属性

    private Singleton8() {}
    public void sayOK() {
        System.out.println("ok~");
    }
}
public class 单例_枚举 {
    public static void main(String[] args) {
        Singleton8 instance = Singleton8.INSTANCE;
//        Singleton1 instance2 = Singleton1.INSTANCE;
//        System.out.println(instance == instance2);
//
//        System.out.println(instance.hashCode());
//        System.out.println(instance2.hashCode());
//
//        instance.sayOK();

        EscapeSingletonUtil.serializeTest(instance);
        EscapeSingletonUtil.reflectTest(instance);
    }
}



package demo3_Polymorphism;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        callanimal(cat);
        callanimal(dog);

    }
    public static void callanimal(Animal a)
    {
        a.eat();
        if(a instanceof Dog)//类型判断
        {
            Dog d =(Dog) a;//父转子类
            d.show();
        }else if(a instanceof Cat)
        {
            Cat c = (Cat) a;
            c.show();
        }
    }

}
abstract class Animal{
    public abstract void eat();
}

class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("dog eat");
    }

    public void show()
    {
        System.out.println("dog yes");
    }

}
class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("cat eat");
    }

    public void show()
    {
        System.out.println("cat yes");
    }
}

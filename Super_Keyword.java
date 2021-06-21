
class Super_Keyword{

    public static void main(String[] args){

        Hero hero1 = new Hero("Iron Man",34,"Technology");

        System.out.println(hero1);
    }
}

class Person{

    String name ;
    int age;
    Person(String name , int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return this.name + " " + this.age;
    }
}

class Hero extends Person{

    String power;
    Hero(String name, int age , String power){
        super(name , age);
        this.power = power;

    }

    public String toString(){
        return super.toString() + " " + this.power;
    }

}
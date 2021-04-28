class InnerClass {
    int x = 4;
    class OuterClass {
        int y = 5;
    }
    
    public static void main(String[] args){
        
        InnerClass obj1 = new InnerClass();
        InnerClass.OuterClass obj2 = obj1.new OuterClass();
        System.out.println(obj1.x + " " + obj2.y);
    }
}
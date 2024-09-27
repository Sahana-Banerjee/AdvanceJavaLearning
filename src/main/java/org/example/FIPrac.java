package org.example;

public interface FIPrac {
    void display(String msg);

    default void printMsg(){
        System.out.println("This is default method");
    }
}

class MyConcrete{

    public  void printMsgInConcrete(String m){
        int a=3, b=4;
        System.out.println(m +":" + (a+b));
    }
    public static void main(String[] args) {
        String msg = "This msg is from concrete";
        FIPrac fi = System.out::println;
        FIPrac fii = (s)-> System.out.println(s);
        fi.display(msg);
        fii.display(msg);
        fii.printMsg();

        MyConcrete mc =new MyConcrete();
        String methodRef = "This is from concrete for mr";
        FIPrac f = mc::printMsgInConcrete; // take the body of my method as that of FIs abstract .
        f.display(methodRef);
    }


}

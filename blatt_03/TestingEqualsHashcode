package EqualsHashcode;

public class ComplexTest {

    public static void main(String[] args)  {
        Student c1 = new Student("fabian", 123456);
        Student c2 = new Student("fabian", 123456);
        Student c3 = new Student("fabian", 123456);
        Student c4 = new Student("Carlos", 32545);
        
        Person d1 = new Person("fabian");
        Person d2 = new Person("fabian");
        
        
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
       
         
        System.out.println("c1: " + c1);
        System.out.println(" == :" + (c1 == c2));
        System.out.println("equals: " + c1.equals(c2));
        System.out.println("hashcode(c1): " + c1.hashCode());
        System.out.println("hashcode(c2): " + c2.hashCode());
     
        System.out.println("reflexivity: " + c1.equals(c1));
        System.out.println("consistency: " + (c1.equals(c2) && c1.equals(c2)));
        System.out.println("symmetric: " + (c1.equals(c2) && c2.equals(c1)));
        System.out.println("Transitivität: " + (c1.equals(c2) && c1.equals(c3) && c2.equals(c3)));
        
        
        /* hashcode muss noch geprüft werden */
        
        
              
    }
}

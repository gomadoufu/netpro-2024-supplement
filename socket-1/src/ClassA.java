public class ClassA {

    String name = "classA";

    public static void main(String arsg[]) {

        ClassA class_a = new ClassA();

        ClassCSub c = new ClassCSub();
        System.out.println("Class c' value is=" + c.getValue());

        System.out.println(class_a.name);

    }

    ClassA() {

        System.out.println("Constructor ClassA");

        /*
         * InnerClassBSub b=new InnerClassBSub();
         * System.out.println(b.name);
         * System.out.println(b.value);
         * b.printValue();
         */

        /*
         * ClassCSub c= new ClassCSub();
         * System.out.println("Class c' value is="+c.getValue());
         */

    }

    /*
     * class InnerClassB{
     * int value=0;
     * String name="Inner ClassB";
     * 
     * InnerClassB(){
     * System.out.println("constractor ClassB");
     * value=50;
     * }
     * 
     * void printValue(){
     * System.out.println("value is:"+value);
     * }
     * 
     * }//inner ClassB end
     * 
     * class InnerClassBSub extends InnerClassB{
     * InnerClassBSub(){
     * super();
     * name="InnnerClassBSub";
     * }
     * }
     */
}

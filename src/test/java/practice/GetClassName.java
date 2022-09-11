package practice;

public class GetClassName {

    public static void main(String[] args) {

        Class<? extends Object> thisClass = new Object() {
        }.getClass();

        String className = thisClass.getEnclosingClass().getSimpleName();
        String methodName = thisClass.getEnclosingMethod().getName();
        System.out.println("Class Name   : " + className);
        System.out.println("Method Name  : " + methodName);

    }

}

package staticfinal;

public class staticfinal {

    static final int staticFinalNumber = 10;
    static int staticNumber = 10;
    final int finalNumber = 10;
    int number = 10;
    
    public static void main(String[] args) {

        System.out.println("main");
        
        
        //객체생성 없이 메서드를 호출하기위해서는 해당 메서드는 static 메서드이여야 함
        //static - > static 호출 가능 
        callStaticMethod();
        
        //The final field staticnonstatic.number cannot be assigned
        // staticFinalNumber = 100; //static final은 변경 안됨
        System.out.println(staticFinalNumber);
        
        //static 변수는 static class 내에서만 변경 가능
        staticNumber = 20;
        System.out.println( staticNumber); //20
        
        // Cannot make a static reference to the non-static field finalNumber
        //finalNumber = 1;  
        
        //static 메서드내 non-static 변수 사용 불가 
        //number = 50;

    }

    private static void callStaticMethod() {
        System.out.println("callStaticMethod");
        
        //staic -> non-static  호출할 수 없음 
        //클래스 생성후 멤버필드.메소드로 호출해야함 
        //callNonStatic();
        
    }
    
    private void callNonStatic(){
        System.out.println("callNonStatic");
        
        //non static  -> static  호출 가능
        callStaticMethod();
    }
    
    private void callNonStatic2() {
        System.out.println("callNonStatic2");
        
        // finalNumber = 100; //final 변수는 변경 안됨
        staticNumber = 30; //static 변수 변경 가능 
        
        //notstatic 메서드내 non static 변수 사용 가능 
        number = 50;
        System.out.println(number);
        
        //non static  -> non static  호출 가능
        callNonStatic();
    }

}

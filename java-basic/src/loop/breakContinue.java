package loop;

public class breakContinue {

    public static void main(String[] args) {

        System.out.println("-- Break for start");
        usageBreakFor();
        
        System.out.println();
        System.out.println("-- Continue for start");
        usageContinueFor();

        
        System.out.println();
        System.out.println("-- Break while start");
        usageBreakWhile();
        
        System.out.println();
        System.out.println("-- Continue while start");
        usageContinueWhile();
    }

    public static void usageBreakFor() {
        
        //해당 조건에서 loop문 빠져나옴(종료)
        System.out.println("break ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            if (i==5) {
                break;
            }
        }
        System.out.println();
        System.out.println("end for");
        
        //중첩문일 경우 해당 조건에서 내부 loop만 빠져나옴 (종료)
        System.out.println();
        System.out.println("break (nested loop)");
        for (int i = 0; i < 10; i++) {
           
            System.out.println();
            System.out.println("(i) : "  + i);
           
            for (int j = 0; j < 10; j++) {
                System.out.print(j + " ");
                if (j==5) {
                    break;
                }
            }
            
        }
        System.out.println();
        System.out.println("end for");
        
    }
        
    public static void usageContinueFor() {
        
        System.out.println("continue ");
 
        for (int i = 0; i < 10; i++) {
            //해당 조건 건너뛰고 계속실행
            if (i==5) {
                continue;
            }
            System.out.print(i + " ");
        }
        
        System.out.println();
        System.out.println("end for");
        
        
        //중첩문일 경우 해당조건 건너 뛰고 실행
        System.out.println();
        System.out.println("continue (nested loop)");
        for (int i = 0; i < 10; i++) {
           
            System.out.println();
            System.out.println("(i) : "  + i);
            //j==5일때는 건너뛰고 계속실행 
            for (int j = 0; j < 10; j++) {
                System.out.print(j + " ");
                if (j==5) {
                    continue;
                }

            }
            
        }
        System.out.println();
        System.out.println("end for");
        
    }

    public static void usageBreakWhile() {

        int count = 10; 
        System.out.println("break");
        //해당조건문 빠져나와서 종료
        while (count > 0) { 
            
            if (count == 5) { 
                break; 
            } 
            System.out.print(count + " "); 
            count--; 
        }
        
        System.out.println();
        System.out.println("break (nested loop)");
        int i = 10;
        int j= 5;
        while(i > 0 ) {
            System.out.println();
            System.out.println("(i) : "+ i);
            j=5;
            while (j > 0) {
                System.out.print(j + " ");
                if (j == 3) {
                    break;
                }
                j--;
            }
            i--;
        }

    }

    public static void usageContinueWhile() {

        System.out.println("continue");
        int count = 10; 

        //해당조건문 빠져나와서 종료
        while (count >= 0) { 
            
            if (count == 5) { 
                count--;
                continue; 
            } 
            System.out.print(count + " "); 
            count--; 
        }
        
        System.out.println();
        System.out.println("continue (nested loop)");
        int i = 10;
        int j= 5;
        while(i > 0 ) {
            
            System.out.println("(i) : "+ i);
            j=5;
            while (j > 0) {
                if (j == 3) {
                    j--;
                    continue;
                }
                System.out.print(j + " ");
                j--;
            }
            System.out.println();
            i--;
        }

    }

}

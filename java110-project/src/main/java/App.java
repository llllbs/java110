import java.util.Scanner;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        
        //배열을 선언
        
        String[] names = new String[100];
        String[] emails = new String[100];
        String[] passwords = new String[100];
        
        int index = 0;
        
        // 1) 키보드 입력을 처리할 객체 준비
        Scanner keyIn = new Scanner(System.in);
        
        // 2) 사용자로부터 회원 정보 입력 받기
        
        while(true) {
            
            System.out.print("이름? ");
            names[index] = keyIn.nextLine();
            
            System.out.print("이메일? ");
            emails[index] = keyIn.nextLine();
            
            System.out.print("암호? ");
            passwords[index] = keyIn.nextLine();
            
            index++;
            
            System.out.print("계속하시겠습니까? (Y/n) ");// 대문자 Y는 default값이 Y라는 것
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                
                break;
                
            }
            
        }
        for(int i=0; i<index; i++) {
        System.out.printf("%s, %s, %s\n", names[i], emails[i], passwords[i]);
        
        }
        keyIn.close(); // scanner는 사용 후 닫아주기
    }
}

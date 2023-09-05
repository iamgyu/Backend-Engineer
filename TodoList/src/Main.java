import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;    // 숫자를 입력 받기 위한 변수

        Map<String, Todo> todo = TodoFunction.load();
        if(todo == null){
            todo = new HashMap<>();
        }

        while (true) {
            System.out.println("To-do List");
            System.out.println("1. 할 일 추가");
            System.out.println("2. 할 일 목록 조회");
            System.out.println("3. 할 일 완료");
            System.out.println("4. 할 일 삭제");
            System.out.println("그 외 숫자 입력은 종료");
            System.out.print("숫자를 입력하세요 : ");

            try {
                num = sc.nextInt();
                String temp = sc.nextLine();    // 오류 해결용 nextLine 추가
                if (num == 1) {
                    TodoFunction.input(todo);
                } else if (num == 2) {
                    TodoFunction.inquire(todo);
                } else if (num == 3) {
                    TodoFunction.done(todo);
                } else if (num == 4) {
                    TodoFunction.remove(todo);
                } else {
                    System.out.println("그 외 숫자가 입력되었습니다 프로그램을 종료합니다");
                    break;
                }
            } catch (Exception e) {
                System.out.println("정수가 아닙니다 프로그램을 종료합니다");
                break;
            }
            System.out.println();
        }
    }
}
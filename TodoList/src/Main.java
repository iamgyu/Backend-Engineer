import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;    // 숫자를 입력 받기 위한 변수

        List<Map<String, String>> todo = new ArrayList<>();

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
                    Map<String, String> map = new HashMap<>();
                    System.out.print("할 일 제목을 입력하세요 : ");
                    String title = sc.nextLine();
                    map.put("title", title);

                    System.out.print("할 일 내용을 입력하세요 : ");
                    String detail = sc.nextLine();
                    map.put("detail", detail);

                    map.put("done", "false");

                    String uuid = UUID.randomUUID().toString().replace("-", "");
                    map.put("uuid", uuid);

                    todo.add(map);
                } else if (num == 2) {
                    for (Map<String, String> map : todo) {
                        System.out.println(map.get("title") + " : " + map.get("detail")
                        + ", done : " + map.get("done") + ", uuid : " + map.get("uuid"));
                    }
                } else if (num == 3) {
                    System.out.print("완료한 일의 uuid를 입력하세요 : ");
                    String uuid = sc.nextLine();

                    for (Map<String, String> map : todo) {
                        if(map.get("uuid").equals(uuid)) {
                            map.put("done", "true");
                        }
                    }
                } else if (num == 4) {
                    System.out.print("삭제할 일의 uuid를 입력하세요 : ");
                    String uuid = sc.nextLine();

                    List<Map<String, String>> removeTodo = new ArrayList<>();
                    for (Map<String, String> map : todo) {
                        if (map.get("uuid").equals(uuid) && map.get("done").equals("true")) {
                            removeTodo.add(map);
                        } else {
                            System.out.println("할 일이 끝나지 않았거나 해당 uuid 할 일이 없어 삭제가 불가능 합니다");
                        }
                    }
                    todo.removeAll(removeTodo);
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
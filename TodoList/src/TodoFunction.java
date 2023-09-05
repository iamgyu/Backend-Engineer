import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class TodoFunction {
    // 파일 주소
    public static final String FILEPATH = "todo.txt";

    // 파일로 저장
    public static void save(Map<String, Todo> map) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILEPATH));
            oos.writeObject(map);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 파일 정보 변환
    public static HashMap<String, Todo> load() {
        HashMap<String, Todo> map = null;

        File file = new File(FILEPATH);
        if(!file.exists()){
            return null;
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILEPATH));
            map = (HashMap<String, Todo>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }

        return map;
    }
    // 할 일 추가
    public static void input(Map<String, Todo> map) {
        Scanner sc = new Scanner(System.in);
        System.out.print("할 일 제목을 작성하세요 : ");
        String title = sc.nextLine();

        System.out.print("할 일 내용을 입력하세요 : ");
        String detail = sc.nextLine();

        Todo todo = new Todo(title, detail);

        String uuid = UUID.randomUUID().toString().replace("-", "");

        map.put(uuid, todo);
        save(map);
    }

    // 할 일 목록 조회
    public static void inquire(Map<String, Todo> map) {
        for (Map.Entry<String, Todo> entrySet : map.entrySet()) {
            System.out.println("id : " + entrySet.getKey() + ", title : " + entrySet.getValue().getTitle()
            + ", detail : " + entrySet.getValue().getDetail() + ", done : " + entrySet.getValue().isDone());
        }
    }

    // 할 일 완료
    public static void done(Map<String, Todo> map) {
        Scanner sc = new Scanner(System.in);
        System.out.print("완료한 할 일의 ID를 입력하세요 : ");
        String uuid = sc.nextLine();

        if (map.containsKey(uuid)) {
            map.get(uuid).setDone(true);
            System.out.println("해당 ID의 할 일을 완료했습니다");
        } else {
            System.out.println("해당 ID의 할 일이 없습니다");
        }
        save(map);
    }

    // 할 일 삭제
    public static void remove(Map<String, Todo> map) {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 할 일의 ID를 입력하세요 : ");
        String uuid = sc.nextLine();

        if (map.containsKey(uuid)) {
            if (!map.get(uuid).isDone()) {
                System.out.println("아직 할 일이 끝나지 않아 삭제가 불가능합니다");
            } else {
                map.remove(uuid);
                System.out.println("해당 할 일을 삭제하였습니다");
            }
        } else {
            System.out.println("해당 할 일이 없습니다");
        }
        save(map);
    }
}

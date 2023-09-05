import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Main {
    // SQLite 데이터베이스 연결 정보
    public static final String DB_URL = "jdbc:sqlite:todo.db";

    public static void main(String[] args) {
        // SQLite JDBC 드라이를 로드
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("SQLite JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
            return;
        }

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            // 테이블 생성
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS todos (" +
                    "id TEXT PRIMARY KEY, " +
                    "title TEXT, " +
                    "detail TEXT, " +
                    "done BOOLEAN)");

            Scanner sc = new Scanner(System.in);
            int num;    // 숫자를 입력 받기 위한 변수

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
                        TodoFunction.input(conn);
                    } else if (num == 2) {
                        TodoFunction.inquire(conn);
                    } else if (num == 3) {
                        TodoFunction.done(conn);
                    } else if (num == 4) {
                        TodoFunction.remove(conn);
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
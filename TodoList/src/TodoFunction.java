import javax.xml.transform.Result;
import java.sql.*;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
public class TodoFunction {
    // 할 일 추가
    public static void input(Connection conn) {
        Scanner sc = new Scanner(System.in);
        System.out.print("할 일 제목을 작성하세요 : ");
        String title = sc.nextLine();

        System.out.print("할 일 내용을 입력하세요 : ");
        String detail = sc.nextLine();

        String uuid = UUID.randomUUID().toString().replace("-", "");

        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO todos(id, title, detail, done) " +
                    "VALUES (?, ?, ? ,?)");
            pstmt.setString(1, uuid);
            pstmt.setString(2, title);
            pstmt.setString(3, detail);
            pstmt.setBoolean(4, false);
            pstmt.executeUpdate();
            pstmt.close();

            System.out.println("할 일이 추가 되었습니다");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 할 일 목록 조회
    public static void inquire(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM todos");

            while (rs.next()) {
                String id = rs.getString("id");
                String title = rs.getString("title");
                String detail = rs.getString("detail");
                boolean done = rs.getBoolean("done");
                System.out.println("id : " + id + ", title : " + title + ", detail : " + detail
                + ", done : " + done);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 할 일 완료
    public static void done(Connection conn) {
        Scanner sc = new Scanner(System.in);
        System.out.print("완료한 할 일의 ID를 입력하세요 : ");
        String uuid = sc.nextLine();

        try {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE todos SET done = ? WHERE id = ?");
            pstmt.setBoolean(1, true);
            pstmt.setString(2, uuid);
            int ret = pstmt.executeUpdate();
            if (ret > 0) {
                System.out.println("해당 ID의 할 일을 완료하였습니다");
            } else {
                System.out.println("해당 ID의 할 일이 없습니다");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 할 일 삭제
    public static void remove(Connection conn) {
        Scanner sc = new Scanner(System.in);

        System.out.print("삭제할 할 일의 ID를 입력하세요 : ");
        String uuid = sc.nextLine();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT done FROM todos WHERE id = '" + uuid + "'");

            if(rs.next()){
                boolean done = rs.getBoolean("done");

                if(!done){
                    System.out.println("아직 할 일이 끝나지 않아 삭제가 불가합니다");
                } else {
                    PreparedStatement pstmt = conn.prepareStatement("DELETE FROM todos WHERE id = ?");
                    pstmt.setString(1, uuid);
                    pstmt.executeUpdate();
                    pstmt.close();

                    System.out.println("해당 ID의 할 일을 삭제 하였습니다");
                }
            } else {
                System.out.println("해당 ID의 할 일이 없습니다");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

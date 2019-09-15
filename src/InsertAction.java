import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class InsertAction {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "c##ckf";
    private static final String PASSWORD = "123456";
    private static final String STUDENT = "student.txt";
    private static final String SC = "sc.txt";
    private static final String CLASS = "class.txt";
    private static final String COURSE = "course.txt";
    private static final String TEACHER = "teacher.txt";
    private static final String TEACHING = "teaching.txt";

    public static void main(String[] args) throws Exception {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println(connection);

        //InsertClass(connection);
        //InsertStudent(connection);
        //InsertCourse(connection);
        //InsertTeacher(connection);
        //InsertTeaching(connection);
        //InsertSc(connection);

        connection.close();
    }

    static void InsertStudent(Connection connection) throws Exception {
        File file = new File(STUDENT);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String sql = "insert into STUDENT values (?,?,?,?,?,null)";
        PreparedStatement statement = connection.prepareStatement(sql);
        String[] values;
        String data;
        while ((data = reader.readLine()) != null) {
            values = data.toString().split("\\s+");
            statement.setString(1, values[0]);
            statement.setString(2, values[1]);
            statement.setString(3, values[2]);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(format.parse(values[3]).getTime());
            statement.setDate(4, date);
            statement.setString(5, values[4]);
            statement.executeUpdate();


        }
        reader.close();
    }

    static void InsertCourse(Connection connection) throws Exception {
        File file = new File(COURSE);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String sql = "insert into COURSE values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        String[] values;
        String data;

        while ((data = reader.readLine()) != null) {
            values = data.toString().split("\\s+");
            for (int i = 0; i < values.length; i++)
                statement.setString(i + 1, values[i]);
            statement.executeUpdate();
        }
        reader.close();
    }

    static void InsertSc(Connection connection) throws Exception {
        File file = new File(SC);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String sql = "insert into SC values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        String[] values;
        String data;

        while ((data = reader.readLine()) != null) {
            values = data.toString().split("\\s+");
            for (int i = 0; i < values.length; i++)
                statement.setString(i + 1, values[i]);
            statement.executeUpdate();
        }
        reader.close();
    }

    static void InsertClass(Connection connection) throws Exception {
        File file = new File(CLASS);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String sql = "insert into CLASS values(?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        String[] values;
        String data;

        while ((data = reader.readLine()) != null) {
            values = data.toString().split("\\s+");
            for (int i = 0; i < values.length; i++)
                statement.setString(i + 1, values[i]);
            statement.executeUpdate();
        }
        reader.close();

    }

    static void InsertTeacher(Connection connection) throws Exception {
        File file = new File(TEACHER);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String sql = "insert into TEACHER values (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        String[] values;
        String data;
        while ((data = reader.readLine()) != null) {
            values = data.toString().split("\\s+");
            statement.setString(1, values[0]);
            statement.setString(2, values[1]);
            statement.setString(3, values[2]);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(format.parse(values[3]).getTime());
            statement.setDate(4, date);
            statement.setString(5, values[4]);
            statement.executeUpdate();


        }
        reader.close();
    }

    static void InsertTeaching(Connection connection) throws Exception {
        File file = new File(TEACHING);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String sql = "insert into TEACHING (CNO,TNO,LANGUAGE) values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        String[] values;
        String data;

        while ((data = reader.readLine()) != null) {
            values = data.toString().split("\\s+");
            for (int i = 0; i < values.length; i++)
                statement.setString(i + 1, values[i]);
            statement.executeUpdate();
        }
        reader.close();
    }
}

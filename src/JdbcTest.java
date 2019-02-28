
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

    /**
     * @param args
     */

    //数据库连接地址
    private final static String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    //用户名
    public final static String USERNAME = "root";
    //密码
    public final static String PASSWORD = "123456";
    //加载的驱动程序类
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        insert();
        //update();
        //delete();
        //insert2();
    }   
    
    
    //方法：插入数据
    public static void insert(){
        try {
            //1、加载数据库驱动程序
            Class.forName(DRIVER);
            
            //2、获取数据库连接
            Connection connection  = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            //3、构造SQL语句（插入具体的数据）
            String sql = "insert into person(name,age,description)values('生命壹号',22,'学到哪里，我的博客就写到哪里')";
            
            //4、构造一个Statement实例(用来发送SQL语句的载体)
            Statement state = connection.createStatement();
            
            //5、执行SQL语句（其实是向数据库中发送sql语句）
            state.executeUpdate(sql);
            
            //6、关闭连接(释放资源)
            state.close();
            connection.close();
            
            System.out.println("insert success");
            
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    

    //方法：插入数据(代码优化)
    public static void insert2(){
        String name = "生命贰号";
        int age  = 22;
        String description = "哈哈，我是优化之后的代码哦";
        try {
            Class.forName(DRIVER);
            Connection connection  = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //拼接SQL语句
            String sql = "insert into person(name,age,description)values('"+name+"',"+age+",'"+description+"')";  //注意拼接的格式
            Statement state = connection.createStatement();
            state.executeUpdate(sql);
            state.close();
            connection.close();
            System.out.println("success.");
            
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    

  //方法：更新数据
    public static void update(){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "update person set age=24 where id=1";
            Statement state = connection.createStatement();
            state.executeUpdate(sql);
            state.close();
            connection.close();
            System.out.println("update success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    //方法：删除操作
    public static void delete(){
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "delete from person where id=1";
            Statement state = connection.createStatement();
            state.executeUpdate(sql);
            state.close();
            connection.close();
            System.out.println("delete success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    

}
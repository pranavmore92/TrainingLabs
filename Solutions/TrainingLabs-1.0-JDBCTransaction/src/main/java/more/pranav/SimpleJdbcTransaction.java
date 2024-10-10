package more.pranav;

import more.pranav.entity.Constants;
import more.pranav.entity.User;

import java.sql.*;

public class SimpleJdbcTransaction {


    public static void main(String[] args) {
        SimpleJdbcTransaction transaction = new SimpleJdbcTransaction();

        transaction.createUsersTable();

        transaction.displayUsers();

        User u1 = new User(1, "pranav", "Pranav", "More", "pranavmore@test.com", "Active", "System");
        User u2 = new User(2, "pranav", "Pranav", "More", "pranavmore@test.com", "Active", "System");

        transaction.insertUser(u1);
        transaction.insertUser(u2);

        transaction.displayUsers();

    }

    private void createUsersTable() {
        try {
            Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
            String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS public.user_master" +
                    "(id integer NOT NULL," +
                    "    username character varying(100) NOT NULL," +
                    "    first_name character varying(150) NOT NULL," +
                    "    last_name character varying(150) NOT NULL," +
                    "    email_id character varying(250) NOT NULL," +
                    "    status character varying(50) NOT NULL," +
                    "    created_by character varying(100)," +
                    "    created_at date," +
                    "    CONSTRAINT user_master_pkey PRIMARY KEY (id))";
            Statement stmt = conn.createStatement();
            stmt.execute(CREATE_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertUser(User user) {
        try {
            Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
            String INSERT_QUERY = "INSERT INTO user_master VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            conn.setAutoCommit(false);
            PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY);
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getFirstName());
            stmt.setString(4, user.getLastName());
            stmt.setString(5, user.getEmailId());
            stmt.setString(6, user.getStatus());
            stmt.setString(7, user.getCreatedBy());
            stmt.setDate(8, new java.sql.Date(System.currentTimeMillis()));
            stmt.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayUsers() {
        try {
            Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
            Statement stmt = conn.createStatement();

            String QUERY = "SELECT * FROM user_master";
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Username: " + rs.getString("username"));
                System.out.print(", First: " + rs.getString("first_name"));
                System.out.println(", Last: " + rs.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
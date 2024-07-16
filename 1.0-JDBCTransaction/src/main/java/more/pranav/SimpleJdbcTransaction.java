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

            System.out.println("Successfully created users table");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertUser(User user) {

        // Insert your code here to add new user in database.

    }

    private void displayUsers() {

        // Insert your code here to fetch all users from database.

    }
}
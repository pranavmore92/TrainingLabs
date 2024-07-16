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

    }

    private void insertUser(User user) {

    }

    private void displayUsers() {

    }
}
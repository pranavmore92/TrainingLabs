package more.pranav.isolationlevels.service;

import more.pranav.isolationlevels.common.Constants;
import more.pranav.isolationlevels.entity.User;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public void createUser(User user) {
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
            Thread.sleep(20000);
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers(){
        try {
            Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
            //conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            Statement stmt = conn.createStatement();
            String QUERY = "SELECT * FROM user_master";
            ResultSet rs = stmt.executeQuery(QUERY);

            List<User> users = new ArrayList<>();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmailId(rs.getString("email_id"));
                user.setStatus(rs.getString("status"));
                user.setCreatedBy(rs.getString("created_by"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

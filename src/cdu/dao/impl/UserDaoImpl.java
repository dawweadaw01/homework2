package cdu.dao.impl;

import cdu.dao.UserDao;
import cdu.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User findById(int id) {
        User user = null;
        String sql = "SELECT *FROM mydb.user_table WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(id);
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setHobby(rs.getString("hobby"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll(int pageNum, int pageSize) {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user_table LIMIT ?,?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (pageNum - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setHobby(rs.getString("hobby"));
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public int insert(User user) {
        int result = 0;
        String sql = "INSERT INTO mydb.user_table(username,password,sex,hobby) VALUES (?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getSex());
            pstmt.setString(4, user.getHobby());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(User user) {

        int result = 0;
        String sql = "UPDATE mydb.user_table SET username=?,password=?,sex=?,hobby=? WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getSex());
            pstmt.setString(4, user.getHobby());
            pstmt.setInt(5, user.getId());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(int id) {

        int result = 0;
        String sql = "DELETE FROM mydb.user_table  WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int count() {
        int result = 0;
        String sql = "SELECT COUNT(*) FROM mydb.user_table";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

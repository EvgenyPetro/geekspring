package ru.petrov.lesson2.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.petrov.lesson2.model.User;

import java.util.List;

@Repository
public class UserRepo {

    private final JdbcTemplate jdbc;

    public UserRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable(firstName, lastName) VALUES (?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    public User getUserById(int id) {
        String sql = "SELECT * FROM userTable WHERE id=?";
        RowMapper<User> rowMapper = (rs, rowNum) -> {
            int id1 = rs.getInt("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            return new User(id1, firstName, lastName);
        };
        return jdbc.queryForObject(sql, rowMapper, (long) id);
    }

    public User updateUser(User user) {
        String sql = "UPDATE userTable SET firstName=?, lastName=? WHERE id=?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), (long) user.getId());
        return user;
    }


}

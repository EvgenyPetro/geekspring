package ru.petrov.lesson2.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.petrov.lesson2.model.User;
import ru.petrov.lesson2.utils.SqlQwery;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepo {

    private final JdbcTemplate jdbc;
    private final SqlQwery sqlqery;


    public List<User> findAll() {

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sqlqery.getFindall(), userRowMapper);
    }

    public User save(User user) {
        jdbc.update(sqlqery.getSave(), user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
        jdbc.update(sqlqery.getDelete(), id);
    }

    public User getUserById(int id) {
        RowMapper<User> rowMapper = (rs, rowNum) -> {
            int id1 = rs.getInt("id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            return new User(id1, firstName, lastName);
        };
        return jdbc.queryForObject(sqlqery.getGetbyid(), rowMapper, (long) id);
    }

    public User updateUser(User user) {
        jdbc.update(sqlqery.getUpdate(), user.getFirstName(), user.getLastName(), (long) user.getId());
        return user;
    }


}

package dao.interfaces;

import entities.User;
import java.sql.ResultSet;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;

public interface UserRepository {

    RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> new User(
        resultSet.getLong("id"), resultSet.getString("email"));

    List<User> findAll();

    User findOne(Long id);

    User save(User user);

    int delete(Long id);
}

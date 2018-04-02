package dao;

import dao.interfaces.UserRepository;
import entities.User;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class UserDAO implements UserRepository {

    private static final Logger logger = LogManager.getLogger(DBConnector.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from user", ROW_MAPPER);
    }

    @Override
    public User findOne(Long id) {
        User user = null;
        try {
            user = jdbcTemplate
                .queryForObject("select * from user where id = ?", new Object[]{id}, ROW_MAPPER);
        } catch (DataAccessException e) {
            logger.warn("User with id:" + id + " not found");
        }
        return user;
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement("insert into user values", new String[]{"ID"});
                ps.setString(1, user.getEmail());
                return ps;
            }, keyHolder);
        } else {
            jdbcTemplate.update("update user set email = ?2 where id = ?1", user.getId(), user.getEmail());
        }
        return findOne(user.getId());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from user where id = ?", id);
    }
}

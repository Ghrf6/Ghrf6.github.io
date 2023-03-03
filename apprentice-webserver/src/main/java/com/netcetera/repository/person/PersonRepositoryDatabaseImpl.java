package com.netcetera.repository.person;

import com.netcetera.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Storage that could be use with a database connection for further expansion.
 */
@Repository
@AllArgsConstructor
@ConditionalOnProperty(prefix = "app", name = "storageType", havingValue = "DATABASE")
public class PersonRepositoryDatabaseImpl implements PersonRepository {

    private final JdbcTemplate jdbcTemplate;

    /**
     * Get all people from the database.
     */
    @Override
    public List<Person> getAll() {
        // TODO: When going to the "personList" page, why are there entries displayed without adding them?
        return jdbcTemplate.query("SELECT * FROM person", (rs, rowNum) -> {
            Person person = new Person();
            person.setId(rs.getLong("id"));
            person.setName(rs.getString("name"));
            person.setSurname(rs.getString("surname"));
            person.setCity(rs.getString("city"));
            person.setAddress(rs.getString("address"));
            person.setPostalCode(rs.getInt("postalCode"));
            return person;
        });
    }

    @Override
    public Person findPersonById(Long id) {
//        TODO: Implement database query
        // Hint: Use jdbcTemplate.queryForObject(statement, class type, var);
        return null;
    }

    @Override
    public Person storePerson(Person person) {
        // TODO: Implement database query
        jdbcTemplate.update("INSERT INTO person(name,surname,city,address,postalCode) VALUES (?, ?, ?, ?, ?)", person.getName(), person.getSurname(), person.getCity(), person.getAddress(), person.getPostalCode());
        // Hint: Use jdbcTemplate.update()
        // jdbcTemplate.update() uses a prepared statement, please research in the web what this is and ask Béla/Davide about advice.
        return person;
    }
}

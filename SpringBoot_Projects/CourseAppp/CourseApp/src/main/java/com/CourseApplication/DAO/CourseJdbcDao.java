package com.CourseApplication.DAO;

import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.CourseApplication.model.Course;
import lombok.extern.slf4j.Slf4j;

//implementing slf4j for logging functionality
@Slf4j
@Component
public class CourseJdbcDao implements Dao<Course> {
	
	//creating a jdbc template
	private JdbcTemplate jdbcTemplate;
	//creating an instance of rowMapper to avoid duplicate code 
	private final RowMapper<Course> rowMapper = (rs, rowNum) -> {
	    Course course = new Course();
	    course.setCourseId(rs.getInt("courseId"));
	    course.setTitle(rs.getString("title"));
	    course.setDescription(rs.getString("description"));
	    course.setLink(rs.getString("link"));
	    return course;
	};

	//dependency injection on jdbctemplate
	public CourseJdbcDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Course> list() {
		String sql = "SELECT courseId, title, description, link from course";
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public void create(Course course) {
		//SQL statement for inserting 
		String sql = "INSERT INTO course (title, description, link) VALUES (?, ?, ?)";

		int insert = jdbcTemplate.update(sql, course.getTitle(), course.getDescription(), course.getLink());
		
		//logging the created course using the logger
		if(insert == 1)
			log.info("New Course Created: " + course.getTitle());	
	}

	@Override
	public Optional<Course> get(int id) {
	    String sql = "SELECT courseId, title, description, link FROM course WHERE courseId = ?";
	    
	    Course course = null; 
	    
	    try {
	    	course = jdbcTemplate.queryForObject(sql, rowMapper, id);
	    } catch (DataAccessException data) {
	        log.info("Course not found: " + id);
	        return Optional.empty(); // Return empty if not found
	    }
	    
	    //returns empty if null
	    return Optional.ofNullable(course); 
	}



	@Override
	public void update(Course course, int id) {
	    String sql = "UPDATE course SET title = ?, description = ?, link = ? WHERE courseId = ?";
	    int update = jdbcTemplate.update(sql, course.getTitle(), course.getDescription(), course.getLink(), id);
	    
	    if (update == 1)
	        log.info("Course updated: " + course.getTitle());
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from course where courseId = ?", id);
	}


}

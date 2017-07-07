//this repository was copied from the PersonRepository.java class

package com.lmig.moviedb;

import com.lmig.moviedb.User;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findById(Integer id);
	
	@Query("SELECT u FROM User u WHERE u.name LIKE CONCAT('%', :name, '%') "
			+ " AND ('' = :location OR u.location = :location) "
//			+ " AND ('' = :dateJoined OR u.dateJoined = :dateJoined) "
			)
	List<User> search(@Param("name") String Name, @Param("location") String Location
//			, @Param("dateJoined") Date DateJoined
			);
}
package com.MovieApp.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.MovieApp.Entity.Book;

public interface BookRepo extends CrudRepository<Book, Integer>{

	@Query(value="select * from Book where loginID =:loginID",nativeQuery = true)
	public List<Book> findByLoginID(int loginID);
}

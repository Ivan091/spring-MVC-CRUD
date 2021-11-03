package edu.titles.repo;

import edu.titles.model.Title;
import org.springframework.data.repository.CrudRepository;


public interface TitleRepo extends CrudRepository<Title, Integer> {

}

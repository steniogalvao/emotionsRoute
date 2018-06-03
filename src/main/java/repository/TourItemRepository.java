package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.TourItem;

@Repository
public interface TourItemRepository extends CrudRepository<TourItem, Long> {

}

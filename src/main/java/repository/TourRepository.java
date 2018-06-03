package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Tour;

@Repository
public interface TourRepository extends CrudRepository<Tour, Long> {

}

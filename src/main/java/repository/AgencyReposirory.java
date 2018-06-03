package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.Agency;

@Repository
public interface AgencyReposirory extends CrudRepository<Agency, Long>{

}

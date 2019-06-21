package br.com.vsgdev.emotionsRoute.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vsgdev.emotionsRoute.model.Transfer;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Integer> {

}

package br.com.vsgdev.emotionsRoute.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.vsgdev.emotionsRoute.model.TransferItem;

@Repository
public interface TransferItemRepository extends CrudRepository<TransferItem, Long> {

}

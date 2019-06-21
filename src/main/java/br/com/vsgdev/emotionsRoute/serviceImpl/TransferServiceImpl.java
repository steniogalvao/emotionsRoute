package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Transfer;
import br.com.vsgdev.emotionsRoute.repository.TransferRepository;
import br.com.vsgdev.emotionsRoute.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private TransferRepository transferRep;

	@Override
	public Transfer get(Long id) throws NotFoundEntity {
		Optional<Transfer> result = transferRep.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundEntity("id", String.valueOf(id));
		}
	}

	@Override
	public void delete(Long id) throws NotFoundEntity {
		transferRep.delete(get(id));

	}

	@Override
	public Transfer put(Transfer transfer) throws NotFoundEntity {
		get(transfer.getId());
		return transferRep.save(transfer);
	}

	@Override
	public Transfer save(Transfer transfer) {
		if (transfer.getId() == 0) {
			return transferRep.save(transfer);
		} else {
			// may throw an exception
			return null;
		}
	}

}

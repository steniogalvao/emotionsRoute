package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Purchase;
import br.com.vsgdev.emotionsRoute.repository.PurchaseRepository;
import br.com.vsgdev.emotionsRoute.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository puRep;

	@Override
	public Purchase get(Long id) throws NotFoundEntity {
		Optional<Purchase> result = puRep.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundEntity("id", String.valueOf(id));
		}
	}

	@Override
	public void delete(Long id) throws NotFoundEntity {
		puRep.delete(get(id));

	}

	@Override
	public Purchase put(Purchase purchase) throws NotFoundEntity {
		get(purchase.getId());
		return puRep.save(purchase);
	}

	@Override
	public Purchase save(Purchase purchase) {
		if (purchase.getId() == 0) {
			return puRep.save(purchase);
		} else {
			// may throw an exception
			return null;
		}
	}

}

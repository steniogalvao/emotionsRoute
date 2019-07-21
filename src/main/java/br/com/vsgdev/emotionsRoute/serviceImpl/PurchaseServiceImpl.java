package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import javax.ws.rs.BadRequestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.model.Purchase;
import br.com.vsgdev.emotionsRoute.repository.PurchaseRepository;
import br.com.vsgdev.emotionsRoute.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository puRep;

	@Override
	public Optional<Purchase> get(Long id) {
		return puRep.findById(id);
	}

	@Override
	public Purchase cancel(Long id) throws BadRequestException {
		Optional<Purchase> result = get(id);
		if (result.isPresent()) {
			result.get().setCanceled(true);
			return puRep.save(result.get());
		} else {
			throw new BadRequestException();
		}

	}

	@Override
	public Purchase put(Purchase purchase) throws BadRequestException {
		if (purchase.getId() != null && puRep.existsById(purchase.getId())) {
			return puRep.save(purchase);
		} else {
			throw new BadRequestException();
		}

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

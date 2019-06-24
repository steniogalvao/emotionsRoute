package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Invoice;
import br.com.vsgdev.emotionsRoute.repository.InvoiceRepository;
import br.com.vsgdev.emotionsRoute.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invRep;

	@Override
	public Invoice get(int id) throws NotFoundEntity {
		Optional<Invoice> result = invRep.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundEntity("id", String.valueOf(id));
		}
	}

	@Override
	public void delete(int id) throws NotFoundEntity {
		invRep.delete(get(id));

	}

	@Override
	public Invoice put(Invoice invoice) throws NotFoundEntity {
		get(invoice.getId());
		return invRep.save(invoice);
	}

	@Override
	public Invoice save(Invoice invoice) {
		if (invoice.getId() == 0) {
			return invRep.save(invoice);
		} else {
			// may throw an exception
			return null;
		}
	}

}

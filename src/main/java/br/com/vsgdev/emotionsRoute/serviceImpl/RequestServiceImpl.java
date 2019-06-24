package br.com.vsgdev.emotionsRoute.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vsgdev.emotionsRoute.exception.NotFoundEntity;
import br.com.vsgdev.emotionsRoute.model.Request;
import br.com.vsgdev.emotionsRoute.repository.RequestRepository;
import br.com.vsgdev.emotionsRoute.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestRepository reqRep;

	@Override
	public Request get(Long id) throws NotFoundEntity {
		Optional<Request> result = reqRep.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new NotFoundEntity("id", String.valueOf(id));
		}
	}

	@Override
	public void delete(Long id) throws NotFoundEntity {
		reqRep.delete(get(id));

	}

	@Override
	public Request put(Request request) throws NotFoundEntity {
		get(request.getId());
		return reqRep.save(request);
	}

	@Override
	public Request save(Request request) {
		if (request.getId() == 0) {
			return reqRep.save(request);
		} else {
			// may throw an exception
			return null;
		}
	}

}

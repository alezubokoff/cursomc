package com.zubokoff.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.zubokoff.cursomc.domain.Cliente;
import com.zubokoff.cursomc.dto.ClienteDTO;
import com.zubokoff.cursomc.repositories.ClienteRepository;
import com.zubokoff.cursomc.services.exceptions.DataIntegrityException;
import com.zubokoff.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> cliente = repo.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Cliente.class.getName()));
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}

	public Cliente update(Cliente cliente) {
		this.find(cliente.getId());
		return repo.save(cliente);
	}

	public void delete(Integer id) {
		try {
			this.find(id);
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma cliente que possui produtos");
		}
	}
	
	public Page<Cliente> findPage(Integer page, Integer size, String direction, String properties) {
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), properties);
		return repo.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO clienteDTO) {
		throw new UnsupportedOperationException();
	}
}

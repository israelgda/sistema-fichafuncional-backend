package com.sefaz.sistemaficha.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sefaz.sistemaficha.entities.FichaFuncional;
import com.sefaz.sistemaficha.repositories.FichaFuncionalRepository;
import com.sefaz.sistemaficha.services.exceptions.ResourceNotFoundException;


@Service
public class FichaFuncionalService {

	@Autowired
	private FichaFuncionalRepository repository;

	public List<FichaFuncional> findAll() {
		List<FichaFuncional> list = repository.findAll();
		return list;
	}

	public FichaFuncional findById(Integer id) {
		Optional<FichaFuncional> ficha = repository.findById(id);
		return ficha.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public FichaFuncional create(FichaFuncional ficha) {
		return repository.save(ficha);
	}

	public FichaFuncional update(Integer id, FichaFuncional ficha) {
		try {
			FichaFuncional fichaAtualizada = findById(id);

			/* Atualizando Ficha através do método local 'updateFicha' */
			fichaAtualizada = updateFicha(ficha, fichaAtualizada);
			return repository.save(fichaAtualizada);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private FichaFuncional updateFicha(FichaFuncional ficha, FichaFuncional fichaAtualizada) {

		fichaAtualizada.setCargo(ficha.getCargo());
		fichaAtualizada.setCep(ficha.getCep());
		fichaAtualizada.setCurso(ficha.getCurso());
		fichaAtualizada.setDataNascimento(ficha.getDataNascimento());
		fichaAtualizada.setDataNomeacao(ficha.getDataNomeacao());
		fichaAtualizada.setDataPosse(ficha.getDataPosse());
		fichaAtualizada.setEndereco(ficha.getEndereco());
		fichaAtualizada.setGrauInstrucao(ficha.getGrauInstrucao());
		fichaAtualizada.setLotacao(ficha.getLotacao());
		fichaAtualizada.setMunicipio(ficha.getMunicipio());
		fichaAtualizada.setNome(ficha.getNome());
		fichaAtualizada.setNomeConjuge(ficha.getNomeConjuge());
		fichaAtualizada.setNomeMae(ficha.getNomeMae());
		fichaAtualizada.setNomePai(ficha.getNomePai());
		fichaAtualizada.setNumCpf(ficha.getNumCpf());
		fichaAtualizada.setNumIdentidade(ficha.getNumIdentidade());
		fichaAtualizada.setNumMatricula(ficha.getNumMatricula());
		fichaAtualizada.setNumOrdem(ficha.getNumOrdem());
		fichaAtualizada.setNumPisPasep(ficha.getNumPisPasep());
		fichaAtualizada.setNumTituloEleitor(ficha.getNumTituloEleitor());
		fichaAtualizada.setTelefone(ficha.getTelefone());
		return fichaAtualizada;
	}
}

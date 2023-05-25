package com.eai.BatchJobCDL.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.eai.BatchJobCDL.model.ImpayesCdlRejetModel;


@Repository
public class ImpayesCDLRejetRepositoryImpl implements ImpayesCDLRejetRepository {

	@Override
	public List<ImpayesCdlRejetModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImpayesCdlRejetModel> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImpayesCdlRejetModel> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ImpayesCdlRejetModel> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends ImpayesCdlRejetModel> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<ImpayesCdlRejetModel> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ImpayesCdlRejetModel getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ImpayesCdlRejetModel> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ImpayesCdlRejetModel> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ImpayesCdlRejetModel> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ImpayesCdlRejetModel> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ImpayesCdlRejetModel> findById(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ImpayesCdlRejetModel entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends ImpayesCdlRejetModel> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends ImpayesCdlRejetModel> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends ImpayesCdlRejetModel> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ImpayesCdlRejetModel> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends ImpayesCdlRejetModel> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(ImpayesCdlRejetModel imp) {
		// TODO Auto-generated method stub
		
	}

}

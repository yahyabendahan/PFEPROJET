package com.eai.BatchJobCDL.implRepository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;

import com.eai.BatchJobCDL.model.TypeDossierModel;
import com.eai.BatchJobCDL.repository.TypeDossierRepository;

@Repository
@Component
public class TypeDossierRepositoryImpl implements TypeDossierRepository {

	@PersistenceContext
    private EntityManager entityManager;// probleme içi entityManager= null ??

    @Override
    public List<String> findAllLibelleCourt() {
        return entityManager.createQuery("SELECT t.LIBELLE_COURT FROM TypeDossierModel t", String.class)
                .getResultList();
    }

    @Override
    public List<String> findallCODE() {
        return entityManager.createQuery("SELECT t.CODE FROM TypeDossierModel t", String.class)
                .getResultList();
    }

	@Override
	public List<TypeDossierModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeDossierModel> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeDossierModel> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TypeDossierModel> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends TypeDossierModel> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<TypeDossierModel> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TypeDossierModel getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TypeDossierModel> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TypeDossierModel> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TypeDossierModel> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TypeDossierModel> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<TypeDossierModel> findById(String id) {
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
	public void delete(TypeDossierModel entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends TypeDossierModel> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends TypeDossierModel> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends TypeDossierModel> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends TypeDossierModel> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends TypeDossierModel> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	
/*est ce que  ce ligne de code va marcher sachant que le model TypeDossierModel et vide :


entityManager.createQuery("SELECT t.CODE FROM TypeDossierModel t", String.class)
                .getResultList();
ChatGPT
Oui, la ligne de code devrait fonctionner correctement même si la classe TypeDossierModel est vide. La requête utilisée "SELECT t.CODE FROM TypeDossierModel t" récupère uniquement la valeur de la colonne CODE de la table représentée par la classe TypeDossierModel.

La méthode entityManager.createQuery() crée une requête JPQL (Java Persistence Query Language) qui est utilisée pour interroger des entités persistantes dans une base de données à l'aide d'EntityManager. Dans ce cas, la requête sélectionne la colonne CODE de la table représentée par TypeDossierModel. Le résultat de la requête est une liste de String qui contient les valeurs de la colonne CODE.

Même si la classe TypeDossierModel est vide, tant que la table correspondante dans la base de données contient des enregistrements et que la colonne CODE existe, la requête devrait retourner les valeurs de la colonne CODE sous forme de liste de chaînes de caractères (List<String>).*/



}

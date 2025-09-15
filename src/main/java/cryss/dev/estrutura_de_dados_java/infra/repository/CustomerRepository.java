package cryss.dev.estrutura_de_dados_java.infra.repository;

import cryss.dev.estrutura_de_dados_java.infra.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findById(Long id);
}

package cryss.dev.estrutura_de_dados_java.cursor.repository;

import cryss.dev.estrutura_de_dados_java.cursor.domain.UserCursor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserCursor, Long> {

    // Busca os próximos registros cujo o valor do id seja maior do que o id informado pelo cursor
    @Query("SELECT u FROM UserCursor u WHERE u.id > :baseId ORDER BY u.id ASC")
    List<UserCursor> findNextPage(Long baseId, Pageable pageable);
}

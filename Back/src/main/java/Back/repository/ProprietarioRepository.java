package Back.repository;

import Back.domain.entity.Carro;
import Back.domain.entity.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {
}

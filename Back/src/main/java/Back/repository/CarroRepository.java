package Back.repository;

import Back.domain.entity.Carro;
import Back.domain.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

    // http://localhost:8080/carros/findByNome //params nome: nome ,  value: nome do carro
    public List<Carro> findByNome(String nome);

    // http://localhost:8080/carros/findByMarca   //params nome: idmarca ,  value: 1
    public List<Carro> findByMarca(Marca marca);

    // http://localhost:8080/carros/findByAcimaAno   //params nome: ano ,  value: ano do carro
    @Query("from Carro c WHERE c.ano > :ano")
    public List<Carro> findByAcimaAno(Integer ano);





}

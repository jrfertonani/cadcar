package Back.service;

import Back.domain.DTO.carroDTO;
import Back.domain.entity.Carro;
import Back.domain.entity.Marca;
import Back.domain.entity.Proprietario;
import Back.repository.CarroRepository;
import Back.service.exceptions.DataIntegrityViolationException;
import Back.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    public CarroRepository repository;


    public Carro create(carroDTO DTO) {
        return repository.save(
                mapper.map(DTO, Carro.class));
    }

    public List<Carro> findAll() {
        return repository.findAll();
    }

    public carroDTO findById(Integer id) {
        return mapper.map(
                repository.findById(id).orElseThrow(
       () -> new ObjectNotFoundException("Carro não encontrado! ID:  " +id)
                ), carroDTO.class);
    }

    public Carro update(Integer id, carroDTO dto) {
        findById(id);
        return repository.save(
                mapper.map(dto, Carro.class)
        );
    }


    public void delete(Integer id) {
        try{
            findById(id);
            repository.deleteById(id);
        }catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException("Não é possivel excluir carro.");
        }
    }


    public List<Carro> findByNome(String nome){
        return this.repository.findByNome(nome);
    }

    public List<Carro> findByMarca(Integer idMarca){
        Marca marca =  new Marca();
        marca.setId(idMarca);
        return this.repository.findByMarca(marca);
    }

    public List<Carro> findByProprietario(Integer idProprietario){
        Proprietario proprietario =  new Proprietario();
        proprietario.setId(idProprietario);
        return this.repository.findByProprietarios(proprietario);
    }

    public List<Carro> findByAcimaAno(Integer ano){
        return this.repository.findByAcimaAno(ano);
    }

}

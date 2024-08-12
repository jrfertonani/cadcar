package Back.service;

import Back.domain.DTO.marcaDTO;
import Back.domain.entity.Marca;
import Back.repository.MarcaRepository;
import Back.service.exceptions.DataIntegrityViolationException;
import Back.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    public MarcaRepository repository;


    public Marca create(marcaDTO DTO) {
        return repository.save(
                mapper.map(DTO, Marca.class));
    }

    public List<Marca> findAll() {
        return repository.findAll();
    }

    public marcaDTO findById(Integer id) {
        return mapper.map(
                repository.findById(id).orElseThrow(
       () -> new ObjectNotFoundException("Marca não encontrado! ID:  " +id)
                ), marcaDTO.class);
    }

    public Marca update(Integer id, marcaDTO dto) {
        findById(id);
        return repository.save(
                mapper.map(dto, Marca.class)
        );
    }


    public void delete(Integer id) {
        try{
            findById(id);
            repository.deleteById(id);
        }catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException("Não é possivel excluir marca.");
        }
    }


}

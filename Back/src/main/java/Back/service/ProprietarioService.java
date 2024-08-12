package Back.service;

import Back.domain.DTO.proprietarioDTO;
import Back.domain.entity.Proprietario;
import Back.repository.ProprietarioRepository;
import Back.service.exceptions.DataIntegrityViolationException;
import Back.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprietarioService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    public ProprietarioRepository repository;


    public Proprietario create(proprietarioDTO DTO) {
        return repository.save(
                mapper.map(DTO, Proprietario.class));
    }

    public List<Proprietario> findAll() {
        return repository.findAll();
    }

    public proprietarioDTO findById(Integer id) {
        return mapper.map(
                repository.findById(id).orElseThrow(
       () -> new ObjectNotFoundException("Proprietario não encontrado! ID:  " +id)
                ), proprietarioDTO.class);
    }

    public Proprietario update(Integer id, proprietarioDTO dto) {
        findById(id);
        return repository.save(
                mapper.map(dto, Proprietario.class)
        );
    }


    public void delete(Integer id) {
        try{
            findById(id);
            repository.deleteById(id);
        }catch (DataIntegrityViolationException ex){
            throw new DataIntegrityViolationException("Não é possivel excluir proprietario.");
        }
    }


}

package Back.resource;

import Back.domain.DTO.proprietarioDTO;
import Back.domain.entity.Proprietario;
import Back.service.ProprietarioService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    @Autowired
    public ModelMapper mapper;

    @Autowired
    public ProprietarioService service;

    @PostMapping
    public ResponseEntity<proprietarioDTO> create(@Valid @RequestBody proprietarioDTO DTO){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        service.create(DTO).getId()
                ).toUri();
        return ResponseEntity.created(uri).body(DTO);
    }

    @GetMapping
    public ResponseEntity<List<Proprietario>> findAll(){
        return ResponseEntity.ok().body(
                service.findAll()
                        .stream().map(x -> mapper.map(x, Proprietario.class))
                .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<proprietarioDTO> findById(@PathVariable Integer id){
          return ResponseEntity.ok().body(
                  mapper.map(service.findById(id), proprietarioDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<proprietarioDTO> update(@PathVariable Integer id,
                                             @RequestBody proprietarioDTO DTO) {
        DTO.setId(id);
        Proprietario obj = service.update(id, DTO);
        return ResponseEntity.ok().body(DTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}

package Back.resource;

import Back.domain.DTO.marcaDTO;
import Back.domain.entity.Marca;
import Back.service.MarcaService;
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
@RequestMapping("/marcas")
public class MarcaController {

    @Autowired
    public ModelMapper mapper;

    @Autowired
    public MarcaService service;

    @PostMapping
    public ResponseEntity<marcaDTO> create(@Valid @RequestBody marcaDTO DTO){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        service.create(DTO).getId()
                ).toUri();
        return ResponseEntity.created(uri).body(DTO);
    }

    @GetMapping
    public ResponseEntity<List<Marca>> findAll(){
        return ResponseEntity.ok().body(
                service.findAll()
                        .stream().map(x -> mapper.map(x, Marca.class))
                .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<marcaDTO> findById(@PathVariable Integer id){
          return ResponseEntity.ok().body(
                  mapper.map(service.findById(id), marcaDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<marcaDTO> update(@PathVariable Integer id,
                                             @RequestBody marcaDTO DTO) {
        DTO.setId(id);
        Marca obj = service.update(id, DTO);
        return ResponseEntity.ok().body(DTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}

package Back.resource;

import Back.domain.DTO.carroDTO;
import Back.domain.entity.Carro;
import Back.service.CarroService;
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
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    public ModelMapper mapper;

    @Autowired
    public CarroService service;


    @PostMapping
    public ResponseEntity<carroDTO> create(@Valid @RequestBody carroDTO DTO){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        service.create(DTO).getId()
                ).toUri();
        return ResponseEntity.created(uri).body(DTO);
    }

    @GetMapping
    public ResponseEntity<List<Carro>> findAll(){
        return ResponseEntity.ok().body(
                service.findAll()
                        .stream().map(x -> mapper.map(x, Carro.class))
                .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<carroDTO> findById(@PathVariable Integer id){
          return ResponseEntity.ok().body(
                  mapper.map(service.findById(id), carroDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<carroDTO> update(@PathVariable Integer id,
                                             @RequestBody carroDTO DTO) {
        DTO.setId(id);
        Carro obj = service.update(id, DTO);
        return ResponseEntity.ok().body(DTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("findByNome")
    public ResponseEntity<List<Carro>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok().body(
                service.findByNome(nome)
                        .stream().map(x -> mapper.map(x, Carro.class))
                        .toList()
        );
    }

    @GetMapping("/findByMarca")
    public ResponseEntity<List<Carro>> findByMarca(@RequestParam Integer idMarca){
        return ResponseEntity.ok().body(
                service.findByMarca(idMarca)
                        .stream().map(x -> mapper.map(x, Carro.class))
                        .toList()
        );
    }

    @GetMapping("findByProprietarios")
    public ResponseEntity<List<Carro>> findByProprietario(@RequestParam Integer idProprietario){
        return ResponseEntity.ok().body(
                service.findByProprietario(Integer.valueOf(idProprietario))
                        .stream().map(x -> mapper.map(x, Carro.class))
                        .toList()
        );
    }



    @GetMapping("findByAcimaAno")
    public ResponseEntity<List<Carro>> findByAcimaAno(@RequestParam Integer ano){
        return ResponseEntity.ok().body(
                service.findByAcimaAno(ano)
                        .stream().map(x -> mapper.map(x, Carro.class))
                        .toList()
        );
    }

}

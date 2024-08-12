package Back.domain.DTO;

import Back.domain.entity.Carro;
import Back.domain.entity.Marca;
import Back.domain.entity.Proprietario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class carroDTO {

    private Integer id;
    @NotBlank(message = "Cannot be empty")
    private String nome;
    @NotNull(message = "Cannot be empty")
    private Integer ano;

    private marcaDTO marca;

    private List<proprietarioDTO> proprietarios;





}

package Back.domain.DTO;

import Back.domain.entity.Proprietario;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class proprietarioDTO {

    private Integer id;

    private String nome;
    private Integer idade;

    private List<carroDTO> carros;


}

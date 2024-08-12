package Back.domain.DTO;

import Back.domain.entity.Carro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class marcaDTO {

    private Integer id;
    @NotBlank(message = "Cannot be empty")
    private String nome;


}

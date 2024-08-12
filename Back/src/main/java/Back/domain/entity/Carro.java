package Back.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.LifecycleState;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data       @Entity
public class Carro implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer ano;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marca_id")
    private Marca marca;


    @ManyToMany(mappedBy = "carros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Proprietario> proprietarios;


}

package Back.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data       @Entity
@AllArgsConstructor
@NoArgsConstructor
public class Proprietario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer idade;

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "carro_proprietario",
           joinColumns = @JoinColumn(name = "proprietario_id"),
           inverseJoinColumns = @JoinColumn(name = "carro_id"))
   private List<Carro> carros;

}

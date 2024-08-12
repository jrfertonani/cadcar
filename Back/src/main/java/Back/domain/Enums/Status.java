package Back.domain.Enums;

import lombok.Getter;

@Getter
public enum Status {
    // aqui são os enums
    ANDAMENTO(0,"ANDAMENTO"),
    ENCERRADO(1,"ENCERRADO");

    //aqui as instancias
    private final Integer codigo;
    private final String descricao;

    //aqui construtor
    Status(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    //aqui um codigo para verificar se existe ou não de enum
    //se existir retorna ele se não retorna uma exceção (não necessario)
    public static Status toEnum(Integer cod){
        if( cod == null){
            return null;
        }
        for(Status x : Status.values()){
            if(cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + cod);
    }

}

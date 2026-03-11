package org.example.DTO;

public record MaquinaDTO(
  String nome,
  String setor
){

    @Override
    public String toString() {
        return "MaquinaDTO{" +
                "nome='" + nome + '\'' +
                '}';
    }
}

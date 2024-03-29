package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {
    private String nome;

    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String foneCelular;

    private String foneFixo;

    private int qtdEntregasRealizadas;

    private Double valorFrete;

    private String enderecoRua;

    private String enderecoNumero;

    private String enderecoBairro;

    private String enderecoCidade;

    private String enderecoCep;

    private String enderecoUf;

    private String enderecoCompleto;

    private Boolean ativo; 

    public Entregador build() {
        return Entregador.builder()
            .nome(nome)
            .cpf(cpf)
            .dataNascimento(dataNascimento)
            .foneCelular(foneCelular)
            .foneFixo(foneFixo)
            .qtdEntregasRealizadas(qtdEntregasRealizadas)
            .valorFrete(valorFrete)
            .enderecoRua(enderecoRua)
            .enderecoNumero(enderecoNumero)
            .enderecoBairro(enderecoBairro)
            .enderecoCidade(enderecoCidade)
            .enderecoCep(enderecoCep)
            .enderecoUf(enderecoUf)
            .enderecoCompleto(enderecoCompleto)
            .ativo(ativo)
            .build();
    }
}

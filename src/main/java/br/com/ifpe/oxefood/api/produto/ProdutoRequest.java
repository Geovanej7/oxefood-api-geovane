package br.com.ifpe.oxefood.api.produto;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

  @NotBlank(message = "O id de categoria é de preenchimento obrigatório")
  private Long idCategoria;

  @NotBlank(message = "O codigo é de preenchimento obrigatório")
  private String codigo;

  @NotBlank(message = "O titulo é de preenchimento obrigatório")
  private String titulo;

  @NotNull(message = "A descrição não pode ser nula")
  private String descricao;

  @NotBlank(message = "O valor é de preenchimento obrigatório")
  private Double valorUnitario;

  @Max(value = 30, message = "O valor de entrega mínimo é entre 1 e 30 minutos")
  private Integer tempoEntregaMinimo;

  @Length(min = 30, max = 100, message = "O valor de entrega maximo é entre 30 e 100 minutos")
  private Integer tempoEntregaMaximo;

  public Produto build() {

    return Produto.builder()
        .codigo(codigo)
        .titulo(titulo)
        .descricao(descricao)
        .valorUnitario(valorUnitario)
        .tempoEntregaMinimo(tempoEntregaMinimo)
        .tempoEntregaMaximo(tempoEntregaMaximo)
        .build();
  }
}

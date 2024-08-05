package br.com.ifpe.oxefood.modelo.entregador;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;



@Entity
@Table(name = "Entregador")
@SQLRestriction("habilitado = true")
@Builder        
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Entregador extends EntidadeAuditavel {
    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String foneCelular;

    @Column
    private String foneFixo;

    @Column
    private int qtdEntregasRealizadas;

    @Column(nullable = false)
    private Double valorFrete;

    @Column(nullable = false, length = 30)
    private String enderecoRua;

    @Column(nullable = false)
    private String enderecoNumero;

    @Column(nullable = false, length = 30)
    private String enderecoBairro;

    @Column(nullable = false, length = 30)
    private String enderecoCidade;

    @Column(nullable = false)
    private String enderecoCep;

    @Column(nullable = false, length = 5)
    private String enderecoUf;

    @Column(nullable = false, length = 30)
    private String enderecoCompleto;

    @Column(nullable = false)
    private Boolean ativo; 

}

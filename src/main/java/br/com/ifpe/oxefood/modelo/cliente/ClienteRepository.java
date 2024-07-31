package br.com.ifpe.oxefood.modelo.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
  List<Cliente> findByCpf(String cpf);

  List<Cliente> findByNome(String nome);

  @Query(value = "SELECT c FROM Cliente c WHERE c.nome like %:nome% AND c.cpf LIKE %:cpf%")
  List<Cliente> consultarNomeeCpf(String nome, String cpf);
}

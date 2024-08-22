package br.com.ifpe.oxefood.api.empresa;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.empresa.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequest {

    private String email;
    private String password;
    private String perfil;

    private String site;
    private String cnpj;
    private String inscricaoEstadual;
    private String nomeEmpresarial;
    private String nomeFantasia;
    private String fone;
    private String foneAlternativo;

    public Empresa build() {

        Empresa empresa = Empresa.builder()
                .usuario(buildUsuario())
                .site(site)
                .cnpj(cnpj)
                .inscricaoEstadual(inscricaoEstadual)
                .nomeEmpresarial(nomeEmpresarial)
                .nomeFantasia(nomeFantasia)
                .fone(fone)
                .foneAlternativo(foneAlternativo)
                .build();

        return empresa;
    }

    public Usuario buildUsuario() {

        return Usuario.builder()
                .username(email)
                .password(password)
                .build();
    }

}

/*{ exemplo de requisição
  "email": "usuario@exemplo.com",
  "password": "123",
  "perfil": "EMPRESA_USER",
  "site": "https://www.exemplo.com",
  "cnpj": "12345678000190",
  "inscricaoEstadual": "123.456.789.123",
  "nomeEmpresarial": "Nome Empresarial Exemplo S.A.",
  "nomeFantasia": "Nome Fantasia Exemplo",
  "fone": "8191234-5678",
  "foneAlternativo": "8198765-4321"
} */

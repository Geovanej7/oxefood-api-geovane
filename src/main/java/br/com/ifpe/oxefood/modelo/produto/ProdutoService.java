package br.com.ifpe.oxefood.modelo.produto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.exception.ProdutoException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
   @Autowired
   private ProdutoRepository repository;

   @Transactional
   public Produto save(Produto produto) {

      if (produto.getValorUnitario() < 100) {
         throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
      }

      if(produto.getTitulo() == null || produto.getTitulo().isEmpty()) {
         throw new ProdutoException(ProdutoException.MSG_TITULO_INEXISTENTE_PRODUTO);
      }
         produto.setHabilitado(Boolean.TRUE);
         produto.setVersao(1L);
         produto.setDataCriacao(LocalDate.now());
         return repository.save(produto);
    
   }

   public List<Produto> listarTodos() {

      return repository.findAll();
   }

   public Produto obterPorID(Long id) {

      return repository.findById(id).get();
   }

   @Transactional
   public void update(Long id, Produto produtoAlterado) {

      Produto produto = repository.findById(id).get();
      produto.setCategoria(produtoAlterado.getCategoria());
      produto.setCodigo(produtoAlterado.getCodigo());
      produto.setTitulo(produtoAlterado.getTitulo());
      produto.setDescricao(produtoAlterado.getDescricao());
      produto.setValorUnitario(produtoAlterado.getValorUnitario());
      produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
      produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());

      produto.setVersao(produto.getVersao() + 1);
      repository.save(produto);
   }

   @Transactional
   public void delete(Long id) {
      Produto produto = repository.findById(id).get();
      produto.setHabilitado(Boolean.FALSE);
      produto.setVersao(produto.getVersao() + 1);

      repository.save(produto);
   }

   public List<Produto> filtrar(String codigo, String titulo, Long idCategoria) {

      List<Produto> listaProdutos = repository.findAll();

      if ((codigo != null && !"".equals(codigo)) &&
            (titulo == null || "".equals(titulo)) &&
            (idCategoria == null)) {
         listaProdutos = repository.findByCodigo(codigo);
      } else if ((codigo == null || "".equals(codigo)) &&
            (titulo != null && !"".equals(titulo)) &&
            (idCategoria == null)) {
         listaProdutos = repository.findByTituloContainingIgnoreCaseOrderByTituloAsc(titulo);
      } else if ((codigo == null || "".equals(codigo)) &&
            (titulo == null || "".equals(titulo)) &&
            (idCategoria != null)) {
         listaProdutos = repository.consultarPorCategoria(idCategoria);
      } else if ((codigo == null || "".equals(codigo)) &&
            (titulo != null && !"".equals(titulo)) &&
            (idCategoria != null)) {
         listaProdutos = repository.consultarPorTituloECategoria(titulo, idCategoria);
      }

      return listaProdutos;
   }

}

package br.com.monktec.resource;

import br.com.monktec.entity.CadastrarProdutoDTO;
import br.com.monktec.entity.Produto;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> listAll(){
       return Produto.listAll();
    }

    @POST
    @Transactional
    public void novoProduto(CadastrarProdutoDTO produtoDTO){
        Produto produto = new Produto();

        produto.setNome(produtoDTO.getNome());
        produto.setValor(produtoDTO.getValor());

        produto.persist();
    }
}

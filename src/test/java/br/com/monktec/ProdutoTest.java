package br.com.monktec;

import br.com.monktec.entity.Produto;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


@QuarkusTest
@QuarkusTestResource(DataBaseLifeCycle.class)
public class ProdutoTest {

    @Test
    public void testUm(){
        assertEquals(1, Produto.count());
    }
}

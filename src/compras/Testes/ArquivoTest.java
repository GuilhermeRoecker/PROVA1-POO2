package compras.Testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import compras.Arquivo;
import compras.Compra;
import compras.Produto;

public class ArquivoTest {

    private Arquivo compras = new Arquivo();

    @Test
    public void testLerArquivoProdutos() {
        compras.lerArquivoProdutos();
        Produto terceiro = compras.getProdutos().get(2);
        assertEquals("Cebola, 8, R$ 5.0", terceiro.toString());
    }

    @Test
    public void testLerArquivocCompras() {
        compras.lerArquivocCompras();
        Compra quarto = compras.getCompras().get(3);
        assertEquals("Tomate,2", quarto.toString());

    }

    @Test
    public void testRealizaCompraOk() {
        compras.getProdutos().add(new Produto("Tomate", 2.0, 10));
        compras.getCompras().add(new Compra("Tomate", 3));
        compras.realizaCompra();
        Produto produto = compras.getProdutos().get(0);
        assertEquals(7, produto.getQtdEstoque());
    }
    
    @Test
    public void testRealizaCompraFail(){
        compras.getProdutos().add(new Produto("Tomate", 2.0, 10));
        compras.getCompras().add(new Compra("Tomate", 20));
        compras.realizaCompra();
        Produto produto = compras.getProdutos().get(0);
        assertEquals(10, produto.getQtdEstoque());
    }

    @Test
    public void testGravaCompra() {

        String compraTeste = "Maça,5,1.50,7.50\n";

        compras.gravaCompra(compraTeste);
        compras.lerArquivocCompras();

        Compra compra = compras.getCompras().get(0);
        assertEquals("Maçã", compra.getNomeProduto());
        assertEquals(5, compra.getQtdCompra());
    }
}

package compras;

public class Compra {
    
    private String nomeProduto;
    private int qtdCompra;

    
    public Compra(String nomeProduto, int qtdCompra) {
        this.nomeProduto = nomeProduto;
        this.qtdCompra = qtdCompra;
    }

    public String getNomeProduto() {
        return this.nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQtdCompra() {
        return this.qtdCompra;
    }

    public void setQtdCompra(int qtdCompra) {
        this.qtdCompra = qtdCompra;
    }

    @Override
    public String toString() {
        return   nomeProduto + "," + qtdCompra;
    }


}

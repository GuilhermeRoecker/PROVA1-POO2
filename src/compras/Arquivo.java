package compras;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {

    private ArrayList<Compra> compras = new ArrayList<>();
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void lerArquivocCompras() {
        try {
            FileReader fr = new FileReader("lista_compras.txt");
            BufferedReader br = new BufferedReader(fr);
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                String nomeProduto = partes[0];
                int qtd = Integer.parseInt(partes[1]);
                compras.add(new Compra(nomeProduto, qtd));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void lerArquivoProdutos() {
        try {
            FileReader fr = new FileReader("lista_produtos.txt");
            BufferedReader br = new BufferedReader(fr);
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] parts = linha.split(",");
                String nome = parts[0];
                int qtd = Integer.parseInt(parts[1]);
                double preco = Double.parseDouble(parts[2].replace("R$", "").trim() + parts[3].replace(",", ".").trim());
                produtos.add(new Produto(nome, preco, qtd));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void realizaCompra() {
        for (Compra compra : compras) {
            for (Produto produto : produtos) {
                if (produto.getNome().equals(compra.getNomeProduto())) {
                    if (produto.getQtdEstoque() >= compra.getQtdCompra()) {
                        produto.setQtdEstoque(produto.getQtdEstoque() - compra.getQtdCompra());
                        double subtotal = produto.getPreco() * compra.getQtdCompra();
                        String arquivoCompra = compra.getNomeProduto() + "," +
                                compra.getQtdCompra() + "," +
                                produto.getPreco() + "," +
                                subtotal + "\n";
    
                        gravaCompra(arquivoCompra);
    
                        System.out.println("O valor total da compra foi de: R$" + subtotal);
                    }
                    break;
                }
            }
        } 
    }

    public void gravaCompra(String arquivoCompra) {
        try {
            FileWriter fw = new FileWriter("compras.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
    
            bw.write(arquivoCompra);
    
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}

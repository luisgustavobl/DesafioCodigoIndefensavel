public class Processador {
    int qntEstoque;


    public void venderIngresso(int idadeCliente, double precoBase, String tipoFilme) {
        if (idadeCliente < 0){
            throw new IllegalArgumentException("IDADE NÃO PODE SER NEGATIVA."+ idadeCliente);
        } else if (idadeCliente < 18 && tipoFilme.toLowerCase().equals("terror")) {
            throw new IllegalArgumentException("ERRO: IDADE INAPROPRIADA PARA TIPO DE FILME");
        }
        if (precoBase < 0) {
            throw new IllegalArgumentException("PREÇO NÃO PODE SER NEGATIVO." + precoBase);
        }
    }

    public void calcularDesconto(int idadeCliente, double precoBase){
        double desconto;
        if (idadeCliente < 12) {
            desconto = precoBase * 0.5; // Desconto criança
        } else if (idadeCliente > 60) {
            desconto = precoBase * 0.3; // Desconto idoso
        } else {
            desconto = precoBase;
        }
        // Simula atualização de banco de dados sem try-catch
        System.out.println("Vendido: " + desconto);
        // Imagine que aqui o estoque diminui sem checar se há assentos

    }
    public void validarClassificacaoEtica(int idadeCliente, String tipoFilme){
        if (idadeCliente < 0){
            throw new IllegalArgumentException("IDADE NÃO PODE SER NEGATIVA."+ idadeCliente);
        } else if (idadeCliente < 18 && tipoFilme.toLowerCase().equals("terror")) {
            throw new IllegalArgumentException("ERRO: IDADE INAPROPRIADA PARA TIPO DE FILME");
        }
    }
}

//Adicionei um .toLowerCase() em tipoFilme para garantir que simples erros de digitação não estraguem o código.
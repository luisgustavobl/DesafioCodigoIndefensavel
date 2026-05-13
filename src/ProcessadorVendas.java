public class ProcessadorVendas {
    private int assentosDisponiveis;

    public ProcessadorVendas(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public void venderIngresso(int idadeCliente, double precoBase, String generoFilme) {//Refatoração (02.04): Aplicar Extração de Metodo para separar o cálculo de desconto da atualização de estoque. Renomear variáveis para nomes semânticos.
        validarEntradas(idadeCliente, precoBase, generoFilme);
        validarEstoque();
        validarClassificacaoEtica(idadeCliente, generoFilme);
        double precoFinal = calcularPrecoFinal(idadeCliente, precoBase);

        atualizarEstoque();

        System.out.println("Ingresso vendido com sucesso. Valor: R$ " + precoFinal);
    }

    private void validarEntradas(int idadeCliente, double precoBase, String generoFilme) {//Programação Defensiva (02.03): Implementar cláusulas de guarda (Guard Clauses). Se o estoque for insuficiente ou o preço for negativo, o código deve lançar exceções claras em vez de falhar silenciosamente.
        if (idadeCliente < 0) {
            throw new IllegalArgumentException("A idade do cliente não pode ser negativa.");
        }
        if (precoBase < 0) {
            throw new IllegalArgumentException("O preço base do ingresso não pode ser negativo.");
        }
        if (generoFilme == null || generoFilme.trim().isEmpty()) {
            throw new IllegalArgumentException("O gênero do filme deve ser informado.");
        }
    }

    private void validarEstoque() {
        if (this.assentosDisponiveis <= 0) {
            throw new IllegalArgumentException("Venda bloqueada: Sessão esgotada.");
        }
    }

    private void validarClassificacaoEtica(int idadeCliente, String generoFilme) {
        if (idadeCliente < 18 && generoFilme.equalsIgnoreCase("TERROR")) {
            throw new IllegalArgumentException("Venda proibida: Filmes de TERROR são restritos para menores de 18 anos.");
        }
    }

    private double calcularPrecoFinal(int idadeCliente, double precoBase) {
        if (idadeCliente < 12) {
            return precoBase * 0.5;
        } else if (idadeCliente > 60) {
            return precoBase * 0.3;
        }
        return precoBase;
    }

    public void atualizarEstoque() {
        this.assentosDisponiveis = assentosDisponiveis - 1;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }
}
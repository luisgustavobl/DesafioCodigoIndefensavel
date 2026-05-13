public class ProcessadorVendas {
    private int assentosDisponiveis;

    public ProcessadorVendas(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public double venderIngresso(int idadeCliente, double precoBase, String generoFilme) {
        validarEntradasBasicas(idadeCliente, precoBase, generoFilme);
        validarEstoque();
        validarClassificacaoEtica(idadeCliente, generoFilme);
        double precoFinal = calcularPrecoFinal(idadeCliente, precoBase);

        atualizarEstoque();

        System.out.println("Ingresso vendido com sucesso. Valor: R$ " + precoFinal);
        return precoFinal;
    }

    private void validarEntradasBasicas(int idadeCliente, double precoBase, String generoFilme) {
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

    private void atualizarEstoque() {
        this.assentosDisponiveis--;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }
}
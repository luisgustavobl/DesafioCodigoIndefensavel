public class Principal {
     static void main(String[] args) {
        /*
        Processador processo = new Processador();
        processo.venderIngresso(20,15,"TERROR");
        processo.venderIngresso(18,15,"TERROR");
        processo.venderIngresso(100,15,"TERROR");
        processo.calcularDesconto(100,15);

        System.out.println("Hello world!");
        */

        ProcessadorVendas novoProcesso = new ProcessadorVendas(10);
        novoProcesso.venderIngresso(18, 30, "Terror"); // ingresso vendido
        novoProcesso.venderIngresso(61, 30, "Ação"); // ingresso vendido com desconto IDOSO
        novoProcesso.venderIngresso(11, 30, "Animação"); // ingresso vendido com desconto CRIANÇA

        //testando metodo getAssentosDisponiveis
        System.out.println("Assentos disóníveis:" + novoProcesso.getAssentosDisponiveis());
        ProcessadorVendas cinema = new ProcessadorVendas(50);
        System.out.println("Assentos disponíveis:" + cinema.getAssentosDisponiveis());

        //testando erros
        /*novoProcesso.venderIngresso(15, 30, "Terror"); // erro por filme restrito
        novoProcesso.venderIngresso(11, -1, "Animação"); // ERRO por preço negativo
        novoProcesso.venderIngresso(18, 20, ""); // ERRO por falta de classificação do filme
        novoProcesso.venderIngresso(-1, 20, "Comédia"); // ERRO por idade negativa*/

    }
}

public class Principal {
    public static void main(String[] args) {
        Processador processo = new Processador();
        processo.venderIngresso(20,15,"TERROR");
        processo.venderIngresso(18,15,"TERROR");
        processo.venderIngresso(100,15,"TERROR");
        processo.calcularDesconto(100,15);

        System.out.println("Hello world!");
    }
}

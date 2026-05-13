Contexto:
Você recebeu um módulo de um sistema de e-commerce responsável pelo cálculo de descontos e atualização de estoque. O código atual funciona, mas é um "Código Espaguete": não trata erros, é difícil de ler, não possui testes e qualquer entrada inválida quebra o sistema.
O Problema (Código Inicial):
Um único método gigante (ex: processarPedido) que:
Recebe parâmetros genéricos (como Object ou strings não validadas).
Tem nomes de variáveis como a, b, temp.
Faz cálculos matemáticos sem checar se os valores são negativos.
Não trata exceções (se o banco falhar, o sistema trava).
A Missão:
Aplicar os quatro pilares da unidade para transformar esse código:
Refatoração (02.04): Aplicar Extração de Método para separar o cálculo de desconto da atualização de estoque. Renomear variáveis para nomes semânticos.
Programação Defensiva (02.03): Implementar cláusulas de guarda (Guard Clauses). Se o estoque for insuficiente ou o preço for negativo, o código deve lançar exceções claras em vez de falhar silenciosamente.
Testabilidade (02.02): Escrever pelo menos três testes unitários (Caminho feliz, Valor inválido e Estoque zerado). O código refatorado deve permitir que o teste isole a lógica de cálculo.
Ética Profissional: Adicionar um breve comentário (2 parágrafos) justificando por que entregar um código sem tratamento de erros fere a ética profissional (ex: prejuízo financeiro ao cliente ou risco de segurança).
Critérios de Avaliação (Checklist):
O método original foi quebrado em métodos menores e especialistas?
As entradas são validadas antes do processamento principal?
Os testes unitários cobrem casos de erro (exceções)?
O código final é compreensível sem a necessidade de manuais extensos?
Para tornar o desafio mais interessante, foi disponibilizado um cenário de um sistema de Gestão de Cinema.
Abaixo, você vai encontrar o "Código Sujo" (o problema) para ser trabalhado. Note que ele viola todos os princípios desta unidade: não tem tratamento de erros, os nomes são péssimos, o método faz tudo ao mesmo tempo e é impossível de testar sem "quebrar" o código.
1. Versão em Java (O Código "Indefensável")
java
public class Processador {
    // Código cheio de problemas: sem tratamento de erro, nomes ruins e difícil de testar
    public void p(int a, double b, String c) {
        // a = idade, b = preco, c = tipo de filme
        if (a < 18 && c.equals("TERROR")) {
            System.out.println("Erro"); // Não lança exceção, apenas printa
        } else {
            double d = 0;
            if (a < 12) {
                d = b * 0.5; // Desconto criança
            } else if (a > 60) {
                d = b * 0.3; // Desconto idoso
            } else {
                d = b;
            }
            
            // Simula atualização de banco de dados sem try-catch
            System.out.println("Vendido: " + d);
            // Imagine que aqui o estoque diminui sem checar se há assentos
        }
    }
}



🎯 Os alunos devem entregar (Sugestão de Resolução):
Para ambos os casos, seguir este roteiro de refatoração:
Renomeação: Mudar p ou proc para venderIngresso, a/x para idadeCliente, etc.
Extração de Método: Criar um método específico calcularDesconto(idade, precoBase) e outro validarClassificacaoEtica(idade, tipoFilme).
Programação Defensiva (Manipulação de Erros):
Em Java: Lançar IllegalArgumentException se a idade for negativa ou AcessoNegadoException para menores em filmes de terror.
Em Python: Usar raise ValueError e blocos try/except para garantir que o preço seja um número.
Testabilidade: Criar uma classe de teste (JUnit para Java ou unittest/pytest para Python) que verifique se o desconto de 50% é aplicado corretamente e se o sistema impede a venda para menores de idade.
Dica Pedagógica: Comentem no código qual técnica de refatoração (do item 02.04) usaram em cada parte.

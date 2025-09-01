import java.util.*;

public class Menu {

    public static void main(String[] args) {
        // Criar objeto SistemaInvestimentos
        // Criar Scanner
        // Loop do menu com opções:
        // 1 - Cadastrar cliente
        // 2 - Adicionar investimento
        // 3 - Listar investimentos de um cliente
        // 4 - Relatório geral
        // 0 - Sair

        SistemaInvestimentos sistemaInvestimentos = new SistemaInvestimentos();
        Scanner sc = new Scanner(System.in);

        boolean rodando = true;

        while (rodando){

            System.out.println("Bem-vindo ao sistema de investimentos!\nSelecione uma opção: ");
            System.out.println("1 - Cadastrar cliente\n" +
                    "2 - Adicionar investimento\n" +
                    "3 - Listar investimentos de um cliente\n" +
                    "4 - Relatório geral\n" +
                    "0 - Sair");
            int opcao = Entradas.validarInt(sc, (byte) 4);
            sc.nextLine();

            switch (opcao){
                case 1:
                    try {
                        System.out.println("Digite seu nome: ");
                        String nome = sc.nextLine();
                        boolean cpfValido = false;
                        String cpf = null;
                        while(!cpfValido) {
                            System.out.println("Digite seu CPF: ");
                            cpf = sc.nextLine();
                            cpfValido = Entradas.validarCpf(cpf);
                        }
                        System.out.println("Digite seu e-mail: ");
                        String email = sc.nextLine();

                        Cliente cliente = new Cliente(nome, cpf, email);
                        sistemaInvestimentos.cadastrarCliente(cliente);
                        break;

                    } catch (Exception e) {
                            throw new RuntimeException(e);
                    }

                case 2:

                    try {
                        System.out.println("Digite seu CPF: ");
                        String cpf = sc.nextLine();
                        if(sistemaInvestimentos.buscarCliente(cpf) == null){
                            System.out.println("Cliente não encontrado!");
                            break;
                        }
                        System.out.println("Escolha o tipo de investimento ");
                        System.out.println("1 - TESOURO SELIC\n2 - CDB\n3 - ACOES");
                        int opcao2 = Entradas.validarInt(sc, (byte) 3);
                        String tipo = null;
                        switch (opcao2){
                            case 1 -> tipo = "TESOURO SELIC";
                            case 2 -> tipo = "CDB";
                            case 3 -> tipo = "ACOES";

                        }

                        System.out.println("Digite o valor que deseja investir: ");
                        double valor = Entradas.validarDouble(sc);
                        sc.nextLine();
                        if(valor == 0){
                            System.out.println("Valor deve ser maior que 0!");
                            break;
                        }
                        if(valor == -1){
                            System.out.println("Entrada inválida!");
                            break;
                        }
                        Investimento investimento = new Investimento(tipo, valor);
                        sistemaInvestimentos.adicionarInvestimento(cpf,investimento);
                        System.out.println("Investimento " + investimento + " adicionado!");
                        break;
                    }catch (Exception e){
                        System.out.println(" "+e.getMessage());
                    }

                case 3:
                    try {
                        //Listar investimentos de um cliente
                        boolean cpfValido=false;
                        String cpf = null;
                        while (!cpfValido) {
                            System.out.println("Digite seu CPF (Digite 0 para cancelar): ");
                            cpf = sc.nextLine();
                            if(cpf.equals("0")) break;
                            cpfValido = Entradas.validarCpf(cpf);
                        }

                        sistemaInvestimentos.listarInvestimentos(cpf);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                case 4:
                    sistemaInvestimentos.relatorioGeral();
                    break;

                case 0: rodando = false;
                break;

                default:
                    System.out.println("Entrada inválida!");
                    break;








        }
    }
}



}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Registro registro = new Registro();

        String opcao = "";
        List<String> opcoesValidas = Arrays.asList("1", "2", "3", "4");

        while (!opcao.equals("4")) {
            System.out.println("\nSelecione uma das opções abaixo: ");
            System.out.println("1 - Cadastrar um novo cliente. ");
            System.out.println("2 - Listar clientes cadastrados. ");
            System.out.println("3 - Excluir clientes cadastrados. ");
            System.out.println("4 - Sair do programa. ");
            opcao = sc.nextLine();

            while (!opcoesValidas.contains(opcao)) {
                System.out.println("Selecione apenas as opções válidas: 1, 2, 3 ou 4 ");
                opcao = sc.nextLine();
            }

            if (opcao.equals("1")) {
                
                try {
                    cadastrarCliente(registro);
                } catch (Exception exception) {
                    System.out.println("Ops! Ocorreu um erro, tente novamente! ");
                }

            } else if (opcao.equals("2")) {
                System.out.println(registro.listarClientes());
            } else if (opcao.equals("3")) {
                System.out.println("Insira o CPF do cliente para excluir a conta: ");
                String cpf = sc.nextLine();

                if (registro.deletarCliente(cpf)) {
                    System.out.println("O cliente com o cpf " + cpf + " foi excluido com sucesso ");
                } else {
                    System.out.println("Nenhum cliente com este CPF foi encontrado na nossa base de dados, tente novamente. ");
                }
            }
        }
        System.out.println("Saindo do programa! ");
    }

    private static void cadastrarCliente(Registro registro) {
        String cpf;
        String nome;
        String cep;
        String logradouro;
        String numeroEndereco;
        int qtdContas;
        int qtdTelefones;
        System.out.print("Cadastro: ");

        System.out.print("Insira o CPF do cliente: ");
        cpf = sc.nextLine();

        if (registro.getClienteBanco(cpf) != null) {
            System.out.println("Já existe um cliente com este CPF. Tente novamente! ");
            return;
        }

        System.out.print("Insira o nome completo do cliente: ");
        nome = sc.nextLine();

        System.out.print("Insira o CEP do cliente: ");
        cep = sc.nextLine();

        System.out.print("Insira o endereço/logradouro do cliente: ");
        logradouro = sc.nextLine();

        System.out.print("Insira o número do endereço do cliente (Insira também o complemento, se necessário): ");
        numeroEndereco = sc.nextLine();

        System.out.print("Insira quantas contas o cliente possui:");
        qtdContas = sc.nextInt();
        sc.nextLine();

        List<ContaBancaria> contas = new ArrayList<>();

        for (int i = 1; i <= qtdContas; i++) {
            String numero;
            String agencia;
            System.out.print("Insira o número da conta " + i + ":");
            numero = sc.nextLine();
            System.out.print("Insira a agência da conta " + i + ":");
            agencia = sc.nextLine();
            contas.add(new ContaBancaria(numero, agencia));
        }

        System.out.print("Insira quantos telefones o cliente possui:");
        qtdTelefones = sc.nextInt();
        sc.nextLine();
        
        List<Telefone> telefones = new ArrayList<>();

        for (int i = 1; i <= qtdTelefones; i++) {
            String ddd;
            String numero;
            System.out.print("Insira o ddd do telefone " + i + ":");
            ddd = sc.nextLine();
            System.out.print("Insira o numero do telefone " + i + ":");
            numero = sc.nextLine();
            telefones.add(new Telefone(ddd, numero));
        }

        EnderecoCliente endereco = new EnderecoCliente(cep, logradouro, numeroEndereco);

        try {
            registro.cadastrarCliente(cpf, nome, contas, endereco, telefones);
            System.out.println("Cliente cadastrado com sucesso.");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }
}
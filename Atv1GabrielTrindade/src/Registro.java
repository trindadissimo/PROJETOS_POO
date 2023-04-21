import java.util.ArrayList;
import java.util.List;

public class Registro {

    private List<ClienteBanco> clientes;

    public Registro() {
        clientes = new ArrayList<>();
    }

    public Registro(List<ClienteBanco> clientes) {
        this.clientes = clientes;
    }

    public void cadastrarCliente(String cpf, String nome, List<ContaBancaria> contas, EnderecoCliente endereco, List<Telefone> telefones) {
        ClienteBanco clienteExistente = getClienteBanco(cpf);
        if (clienteExistente != null) {
            throw new RuntimeException("Já existe um cliente com este cpf");
        }
        ClienteBanco cliente = new ClienteBanco(cpf, nome, contas, endereco, telefones);
        clientes.add(cliente);
    }

    public String listarClientes() {
        String listagem = "Total de clientes: " + clientes.size();
        int sequenciaCliente = 1;
        for (ClienteBanco c : clientes) {
            listagem += "\n";
            listagem += "\nCliente " + sequenciaCliente + ":\n";
            listagem += "CPF: " + c.getCpf() + "\n";
            listagem += "Nome: " + c.getNome() + "\n";

            listagem += "Endereco:\n";
            listagem += "CEP: " + c.getEndereco().getCep() + "\n";
            listagem += "Logradouro: " + c.getEndereco().getLogradouro() + "\n";
            listagem += "Numero: " + c.getEndereco().getNumero() + "\n";

            int sequenciaConta = 1;
            for (ContaBancaria conta : c.getContas()) {
                listagem += "Conta " + sequenciaConta + ":\n";
                listagem += "Numero: " + conta.getNumero() + "\n";
                listagem += "Agencia: " + conta.getAgencia() + "\n";
                listagem += "Saldo: " + conta.getSaldo() + "\n";
                sequenciaConta++;
            }

            int sequenciaTelefone = 1;
            for (Telefone telefone : c.getTelefones()) {
                listagem += "Telefone " + sequenciaTelefone + ":\n";
                listagem += "DDD: " + telefone.getDdd() + "\n";
                listagem += "Numero: " + telefone.getNumero() + "\n";
                sequenciaTelefone++;
            }
            sequenciaCliente++;
        }
        return listagem;
    }

    public Boolean deletarCliente(String cpf) {
        ClienteBanco clienteParaDeletar = getClienteBanco(cpf);
        if (clienteParaDeletar == null) {
            return false;
        }

        clienteParaDeletar.setContas(new ArrayList<>());
        clienteParaDeletar.setEndereco(null);
        clienteParaDeletar.setTelefones(new ArrayList<>());
        return clientes.remove(clienteParaDeletar);
    }

    public ClienteBanco getClienteBanco(String cpf) {
        for (ClienteBanco c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }
}

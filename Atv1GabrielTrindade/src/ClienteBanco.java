import java.util.List;

public class ClienteBanco {

    private String cpf;
    private String nome;
    private List<ContaBancaria> contas;
    private EnderecoCliente endereco;
    private List<Telefone> telefones;

    public ClienteBanco(String cpf, String nome, List<ContaBancaria> contas, EnderecoCliente endereco, List<Telefone> telefones) {
        this.cpf = cpf;
        this.nome = nome;
        this.contas = contas;
        this.endereco = endereco;
        this.telefones = telefones;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(List<ContaBancaria> contas) {
        this.contas = contas;
    }

    public EnderecoCliente getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoCliente endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}

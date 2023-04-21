public class ContaBancaria {

    private String numero;
    private String agencia;
    private Double saldo;

    public ContaBancaria(String numero, String agencia) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = 0.0;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String extrato() {
        return "O saldo atual deste cliente é de: " + saldo + " reais. Ele está liso.";
    }

    public void deposito(Double valor) {
        this.saldo += valor;
    }

    public Double sacar(Double valor) {
        if (this.saldo <= valor) {
            this.saldo -= valor;
            return valor;
        } else {
            return 0.0;
        }
    }
}

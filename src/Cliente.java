import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome, cpf, email;
    private List<Investimento> investimentos = new ArrayList<>();

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.investimentos = new ArrayList<>();
    }

    public void adicionarInvestimento(Investimento investimento) {
        investimentos.add(investimento);
    }

    public double getTotalInvestido() {
        return investimentos.stream().mapToDouble(Investimento::getValor).sum();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail(){
        return email;
    }

    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void setNome(String nome) throws Exception{
        if(nome == null || nome.isEmpty()){
            throw new Exception("Nome do cliente não pode ser vazio.");
        }
        this.nome = nome;
    }

    public void setCpf(String cpf) throws Exception{
        if(cpf == null || cpf.isEmpty()){
            throw new Exception("CPF do cliente não pode ser vazio.");
        }
        this.cpf = cpf;
    }

    public void setEmail(String email) throws Exception{
        if(email == null || email.isEmpty()){
            throw new Exception("Email do cliente não pode ser vazio.");
        }
        this.email = email;
    }

}




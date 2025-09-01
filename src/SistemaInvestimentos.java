

import java.util.HashMap;
import java.util.Map;

public class SistemaInvestimentos {

    private Map<String, Cliente> clientes;

    public SistemaInvestimentos(){
        clientes = new HashMap<>();
    }

    public void cadastrarCliente(Cliente cliente){
        if(clientes.containsKey(cliente.getCpf())) System.out.println("Cliente já cadastrado!");
        else {
            System.out.println("Cliente cadastrado com sucesso! ");
            clientes.put(cliente.getCpf(), cliente);
        }
    }

    public Cliente buscarCliente(String cpf){
        return clientes.getOrDefault(cpf, null);
    }

    public void adicionarInvestimento(String cpf, Investimento investimento){
        Cliente cliente = buscarCliente(cpf);
        if(cliente == null){
            System.out.println("Cliente não encontrado!");
            return;
        }else cliente.adicionarInvestimento(investimento);
    }

    public double calcularTotalInvestido(String cpf) throws Exception{
        Cliente cliente = buscarCliente(cpf);
        if(cliente == null){
            throw new Exception("Cliente não encontrado!");
        }
        return cliente.getTotalInvestido();
    }

    public void listarInvestimentos(String cpf) throws Exception{
        Cliente cliente = buscarCliente(cpf);
        if(cliente == null){
            throw new Exception("Cliente não encontrado!");
        }
        // listar todos os tipos de um investimento
        for(Investimento investimento : cliente.getInvestimentos()){
            System.out.println("Tipo: " + investimento.getTipo() + " - Valor: " + investimento.getValor());
        }
    }

    public void relatorioGeral(){
        for(Cliente cliente : clientes.values()){
            System.out.println("Cliente: " + cliente.getNome() + " - CPF: " + cliente.getCpf() + " - Total Investido: " + cliente.getTotalInvestido());
        }
    }
}


public class Investimento {

    // Atributos
    private String tipo;   // Ex.: Tesouro Selic, CDB, Ações
    private double valor;

    // Construtor
    public Investimento(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.tipo;
    }
    //SETTERS


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // Getters
    public String getTipo() { return tipo; }
    public double getValor() { return valor; }
}




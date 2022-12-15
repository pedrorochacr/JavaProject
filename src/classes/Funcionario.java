package classes;

public abstract class Funcionario {
    private String nome;
    private String dataContratacao;

    public Funcionario(String nome, String dataContracao){
        this.nome = nome;
        this.dataContratacao = dataContracao;
    }
    public abstract double salario(); // salario que todos funcionarios deverao ter com base nos dias trabalhados e beneficios
    public  abstract double beneficio();

    public String getNome() {
        return nome;
    }
    public  void setNome(String nome){
        this.nome = nome;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
}

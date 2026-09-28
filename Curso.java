public class Curso
{
    private int codigo;
    private String nome;
    private int duracao;

    public Curso(int codigo, String nome, int duracao)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.duracao = duracao;
    }

    public int getcodigo(){
        return codigo;
    }
    
    public void setcodigo(int codigo){
        this.codigo = codigo;
    }
    
    public String getnome(){
        return nome;
    }
    
    public void setnome(String nome){
        this.nome = nome;
    }
    
    public int getduracao(){
        return duracao;
    }
    
    public void setduracao(int duracao){
        this.duracao = duracao;
    }
    
    public void exibeDados(){
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Duração: " + duracao);
    } 
    
}
public class Aluno
{
    private int codigo;
    private String nome;
    private String dataNascimento;
    private String email;
    private String senha;
    
    public Aluno(int codigo, String nome, String dataNascimento, String email, String senha)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
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
    
    public String getdataNascimento(){
        return dataNascimento;
    }
    
    public void setdataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public String getemail(){
        return email;
    }
    
    public void setemail(String email){
        this.email = email;
    }
    
    public String getsenha(){
        return senha;
    }
    
    public void setsenha(String senha){
        this.senha = senha;
    }
    
    public void exibeDados(){
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("E-mail: " + email);
        System.out.println("Senha: " + senha);
    }
}
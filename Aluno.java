public class Aluno
{
    private int codigo;
    private String nome;
    private String dataNascimento;
    private String email;
    private String senha;
    
    private double[] notas = new double[3];
    private boolean[] lancada = new boolean[3];
    
    private Mensalidade[] mensalidades;
    private int numParcelas;
    
    public Aluno(int codigo, String nome, String dataNascimento, String email, String senha)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.senha = senha;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getDataNascimento(){
        return dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public void lancarNotas(double n1, double n2, double n3){
        this.notas[0] = n1;
        this.notas[1] = n2;
        this.notas[2] = n3;
        
        this.lancada[0] = true;
        this.lancada[1] = true;
        this.lancada[2] = true;
    }
    
    public double calcularMedia(){
        double soma =0;
        for (int i = 0; i < 3; i++){
            soma += notas[i];
        }
        return soma / 3.0;
    }
    
    public void exibirNotas(){
        System.out.println("\nNotas do Aluno: " + nome + "código " + codigo);
        for (int i = 0; i < 3; i++){
            if (lancada[i]){
                System.out.println("Nota " + (i + 1) + ": " + notas[i]);
            } else {
                System.out.println("Nota " + (i + 1) + ": Não lançada");
            }
        }
        System.out.printf("Média: %.2f\n", calcularMedia());
    }
    
    public void adicionarMensalidades(double[] valores) {
        this.numParcelas = valores.length;
        this.mensalidades = new Mensalidade[this.numParcelas];
        for (int i = 0; i < this.numParcelas; i++) {
            this.mensalidades[i] = new Mensalidade(valores[i]);
        }
    }

    public void exibirMensalidades() {
        if (mensalidades == null || numParcelas == 0) {
            System.out.println("\nNenhuma mensalidade cadastrada para este aluno.");
            return;
        }

        System.out.println("Situação Financeira " + nome.toUpperCase());

        for (int i = 0; i < numParcelas; i++) {
            String status = mensalidades[i].isPago() ? "PAGO" : "EM ABERTO";
            System.out.printf("Parcela %02d: R$ %.2f | Status: %s\n", (i + 1), mensalidades[i].getValor(), status);
        }
    }

    public void pagarMensalidade(int indice) {
        if (mensalidades == null || indice < 0 || indice >= numParcelas) {
            System.out.println("-> Erro: Número de parcela inválido!");
            return;
        }

        if (mensalidades[indice].isPago()) {
            System.out.println("-> Esta parcela já se encontra PAGA.");
        } else {
            mensalidades[indice].darBaixa();
            System.out.println("-> Baixa efetuada com sucesso na parcela " + (indice + 1) + "!");
        }
    }

    public Mensalidade[] getMensalidades() {
        return mensalidades;
    }
    
    public void exibeDados(){
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("E-mail: " + email);
        System.out.println("Senha: " + senha);
    }
}
public class ListadeAlunos
{
    private Aluno[] alunos;
    private int totalAlunos; 
    
    public ListadeAlunos (int capacidade){
        this.alunos = new Aluno[capacidade];
        this.totalAlunos = 0;
    }
    
    public boolean adicionarAluno(Aluno A){
        for (int i = 0; i < totalAlunos; i++){
            System.out.println(" ERRO: Já existe um aluno com o código " + A.getCodigo());
            return false;
        }
        
        if (totalAlunos >= alunos.length){
            System.out.println(" ERRO: A capacidade máxima da lista foi atingida.");
            return false;
        }
        
        alunos[totalAlunos] = A;
        totalAlunos++;
        return true;
    }
    
    public Aluno buscarPorCodigo(int codigo){
        for (int i = 0; i < totalAlunos; i++){
            if (alunos [i].getCodigo() == codigo){
                return alunos[i];
            }
        }
        return null;
    }
    public void exibirLista(){
        if (totalAlunos ==0){
            System.out.println("\nNenhum aluno cadastrado na lista.");
            return;
        }
        
        System.out.println(" - Lista de Alunos - ");
        
        for (int i = 0; i < totalAlunos; i++){
            System.out.println("\n[Aluno " + (i+1) + "]");
            alunos[i].exibeDados();
        }
    }
}

    
    

package hiberjpaaven.Entrada;

import hiberjpaaven.Dao.AlunoDAO;
import hiberjpaaven.Model.AlunoModel;
import java.util.List;
import javax.swing.JOptionPane;

public class EntradaAluno 
{
    public AlunoDAO alunoDao = new AlunoDAO();
    public void salvar()
    {
        AlunoModel aluno = new AlunoModel();
        aluno.setNome(JOptionPane.showInputDialog("Nome: "));
        aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
        aluno.setSexo(JOptionPane.showInputDialog("Sexo: "));
        aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));
        alunoDao.salvar(aluno);
    }
    
    public void editar( )
    {
        AlunoModel aluno = new AlunoModel();
        aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        aluno = alunoDao.buscarCpf(aluno);
        
        aluno.setNome(JOptionPane.showInputDialog("Nome: "));
        aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
        aluno.setSexo(JOptionPane.showInputDialog("Sexo: "));
        aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));
        alunoDao.editar(aluno);
    }
    
    public void remover()
    {
        AlunoModel aluno = new AlunoModel();
        aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        aluno = alunoDao.buscarCpf(aluno);
        alunoDao.remover(aluno);
    }
    
    public void cpf()
    {
        AlunoModel aluno = new AlunoModel();
        aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        aluno = alunoDao.buscarCpf(aluno);
        String exibir = "Nome: " + aluno.getNome() +
                        " -- Idade: " + aluno.getIdade() + 
                        " -- CPF: " + aluno.getCpf() +
                        " -- Sexo: " + aluno.getSexo() +
                        " -- RA: " + aluno.getRa();
        JOptionPane.showMessageDialog(null, exibir);
    }
    
    public void buscarTodos()
    {
        String geral = "\t\tLista de Alunos";
        List<AlunoModel> alunos = alunoDao.buscarTodos();
        for(AlunoModel aluno : alunos)
        {
            String exibir = "\nID: " + aluno.getIdpessoa() +
                        " -- Nome: " + aluno.getNome() +
                        " -- Idade: " + aluno.getIdade() + 
                        " -- CPF: " + aluno.getCpf() +
                        " -- Sexo: " + aluno.getSexo() +
                        " -- RA: " + aluno.getRa();
            geral = geral + exibir;
        }
        JOptionPane.showMessageDialog(null, geral);
    }
}

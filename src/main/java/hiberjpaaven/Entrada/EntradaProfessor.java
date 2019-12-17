package hiberjpaaven.Entrada;

import hiberjpaaven.Dao.ProfessorDAO;
import hiberjpaaven.Model.ProfessorModel;
import java.util.List;
import javax.swing.JOptionPane;

public class EntradaProfessor 
{
    public ProfessorDAO professorDao = new ProfessorDAO();
    public void salvar()
    {
        ProfessorModel professor = new ProfessorModel();
        professor.setNome(JOptionPane.showInputDialog("Nome: "));
        professor.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
        professor.setSexo(JOptionPane.showInputDialog("Sexo: "));
        professor.setSiape(Integer.parseInt(JOptionPane.showInputDialog("Siape: ")));
        professorDao.salvar(professor);
    }
    
    public void editar()
    {
        ProfessorModel professor = new ProfessorModel();
        professor.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        professor = professorDao.buscarCpf(professor);
        
        professor.setNome(JOptionPane.showInputDialog("Nome: "));
        professor.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
        professor.setSexo(JOptionPane.showInputDialog("Sexo: "));
        professor.setSiape(Integer.parseInt(JOptionPane.showInputDialog("Siape: ")));
        professorDao.editar(professor);
    }
    
    public void remover()
    {
        ProfessorModel professor = new ProfessorModel();
        professor.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        professor = professorDao.buscarCpf(professor);
        professorDao.remover(professor);
    }
    
    public void cpf()
    {
        ProfessorModel professor = new ProfessorModel();
        professor.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        professor = professorDao.buscarCpf(professor);
        String exibir = "Nome: " + professor.getNome() +
                        " -- Idade: " + professor.getIdade() + 
                        " -- CPF: " + professor.getCpf() +
                        " -- Sexo: " + professor.getSexo() +
                        " -- Siape: " + professor.getSiape();
        JOptionPane.showMessageDialog(null, exibir);
    }
    
     public void buscarTodos()
    {
        String geral = "\t\tLista de Professores";
        List<ProfessorModel> professores = professorDao.buscarTodos();
        for(ProfessorModel professor : professores)
        {
            String exibir = "\nID: " + professor.getIdpessoa() +
                            " -- Nome: " + professor.getNome() +
                            " -- Idade: " + professor.getIdade() + 
                            " -- CPF: " + professor.getCpf() +
                            " -- Sexo: " + professor.getSexo() +
                            " -- Siape: " + professor.getSiape();
            geral = geral + exibir;
        }
        JOptionPane.showMessageDialog(null, geral);
    }
}

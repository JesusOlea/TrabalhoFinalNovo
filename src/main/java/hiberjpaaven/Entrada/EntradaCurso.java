package hiberjpaaven.Entrada;

import java.util.List;
import javax.swing.JOptionPane;
import hiberjpaaven.Dao.AlunoDAO;
import hiberjpaaven.Dao.CursoDAO;
import hiberjpaaven.Dao.ProfessorDAO;
import hiberjpaaven.Model.AlunoModel;
import hiberjpaaven.Model.CursoModel;
import hiberjpaaven.Model.ProfessorModel;

public class EntradaCurso 
{
    public ProfessorDAO professorDao = new ProfessorDAO();
    public AlunoDAO alunoDao = new AlunoDAO();
    public EntradaProfessor entradaProfessor = new EntradaProfessor();
    public CursoDAO cursoDao = new CursoDAO();

    public void salvar()
    {
        CursoModel curso = new CursoModel();
        curso.setDescricao(JOptionPane.showInputDialog("Descrição: "));
        curso.setTitulo(JOptionPane.showInputDialog("Titulo: "));
        curso.setLocal(JOptionPane.showInputDialog("Local: "));
        curso.setQuantidadeDeVagas(Integer.parseInt(JOptionPane.showInputDialog("Vagas: ")));

        cursoDao.salvar(curso);
    }
    public void editar()
    {
    	CursoModel curso = new CursoModel();
    	int id = Integer.parseInt(JOptionPane.showInputDialog("ID: "));
    	curso = cursoDao.buscarPorId(id);
    	
        curso.setDescricao(JOptionPane.showInputDialog("Descrição: "));
        curso.setTitulo(JOptionPane.showInputDialog("Titulo: "));
        curso.setLocal(JOptionPane.showInputDialog("Local: "));
        curso.setQuantidadeDeVagas(Integer.parseInt(JOptionPane.showInputDialog("Vagas: ")));
        
        cursoDao.editar(curso);
    }
    public void remover()
    {
    	CursoModel curso = new CursoModel();
    	curso = cursoDao.buscarPorId(Integer.parseInt(JOptionPane.showInputDialog("ID do curso: ")));
    	cursoDao.remover(curso);    	
    }
	
    public void professor()
    {
        CursoModel curso = new CursoModel();
        curso = cursoDao.buscarPorId(Integer.parseInt(JOptionPane.showInputDialog("ID do Curso: ")));
        ProfessorModel professor = new ProfessorModel();
        professor.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        professor = professorDao.buscarCpf(professor);
        curso.setProfessor(professor);
        cursoDao.editar(curso);
    }

    public void aluno()
    {
        CursoModel curso = new CursoModel();
        curso = cursoDao.buscarPorId(Integer.parseInt(JOptionPane.showInputDialog("ID do Curso: ")));
        List<AlunoModel> alunos = curso.getListaDeAlunos();
        if(alunos.isEmpty() || !(alunos.size() >= curso.getQuantidadeDeVagas()))
        {
            AlunoModel aluno = new AlunoModel();
            aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
            aluno = alunoDao.buscarCpf(aluno);
            alunos.add(aluno);
            curso.setListaDeAlunos(alunos);
            cursoDao.editar(curso);
        }
        else { JOptionPane.showMessageDialog(null, "Todas vagas preenchidas"); }
    }

    @SuppressWarnings("unused")
	public void buscar()
    {
        CursoModel curso = cursoDao.titulo(JOptionPane.showInputDialog("Curso: "));
		ProfessorModel professor = curso.getProfessor();
        String titulo ="\nTitulo: " + curso.getTitulo() +  " -- Descrição: " + curso.getDescricao() + " -- Local: " + curso.getLocal();//+  " -- Professor: " + professor.getNome();

        String lista = titulo;
        int i = 1;
        List<AlunoModel> alunos = curso.getListaDeAlunos();
        for(AlunoModel aluno : alunos) 
        {
            String exibir =  i + "\n: " + " -- Nome: " + aluno.getNome() + " -- Idade: " + aluno.getIdade() + " -- CPF: " + aluno.getCpf() + " -- Sexo: " + aluno.getSexo() +  " -- Ra: " + aluno.getRa() + "\n";
            lista = lista + exibir;
            i++;
        }
        JOptionPane.showMessageDialog(null, lista);
    }

    @SuppressWarnings("unused")
	public void buscarTodos()
    {
    	String lista = " ";
        List<CursoModel> cursos = cursoDao.buscarTodos();       
        for(CursoModel curso : cursos) 
        {
            ProfessorModel professor = curso.getProfessor();
            String exibir = "\nTitulo: " + curso.getTitulo() + " -- Descrição: " + curso.getDescricao() + " -- Local: " + curso.getLocal() + " -- Vagas: " + curso.getQuantidadeDeVagas() /*+ "\nProfessor: " + professor.getNome() + "\n"*/;
            lista = lista + exibir;
        }
        JOptionPane.showMessageDialog(null, lista);
    }      
}

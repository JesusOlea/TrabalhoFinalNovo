package hiberjpaaven.Dao;

import hiberjpaaven.Model.ProfessorModel;
import java.util.List;
import javax.swing.JOptionPane;

public class ProfessorDAO extends Conexao
{	
    public void salvar(ProfessorModel professor) 
    {
        try
        {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(professor);
            getEntityManager().getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Professor salvo com sucesso!");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao salvar" + e.getMessage());
        }
    }

    public void editar(ProfessorModel professor)
    {
        try
        {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(professor);
            getEntityManager().getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Professor salvo com sucesso!");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao salvar" + e.getMessage());
        }
    }

    public void remover(ProfessorModel professor)
    {
        try
        {
            getEntityManager().getTransaction().begin();
            professor = entityManager.find(ProfessorModel.class, professor.getIdpessoa());
            getEntityManager().remove(professor);
            getEntityManager().getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Professor removido com sucesso!");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao remover" + e.getMessage());
        }
    }

    public ProfessorModel buscarId(long id)
    {
        try
        {
            return entityManager.find(ProfessorModel.class, id);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"ID não encontrado" + e.getMessage());
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<ProfessorModel> buscarTodos()
    {
             return entityManager.createQuery("FROM " + ProfessorModel.class.getName()).getResultList();
    }

    public ProfessorModel buscarCpf(ProfessorModel professor)
    {
        try
        {
            return (ProfessorModel) entityManager.createQuery("FROM " + ProfessorModel.class.getName() + " WHERE cpf = :cpf")
                    .setParameter("cpf", professor.getCpf()).getSingleResult();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "CPF não encontrado" + e.getMessage());
        }
        return null;
    }
}

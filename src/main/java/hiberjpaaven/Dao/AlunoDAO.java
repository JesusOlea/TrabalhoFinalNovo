package hiberjpaaven.Dao;

import hiberjpaaven.Model.AlunoModel;
import java.util.List;
import javax.swing.JOptionPane;

public class AlunoDAO extends Conexao
{
    public void salvar(AlunoModel aluno) 
    {
        try
        {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(aluno);
            getEntityManager().getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao salvar" + e.getMessage());
        }
    }

    public void editar(AlunoModel aluno)
    {
        try
        {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(aluno);
            getEntityManager().getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Aluno editado com sucesso!");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Erro ao editar" + e.getMessage());
        }
    }

    public void remover(AlunoModel aluno)
    {
        try
        {
        getEntityManager().getTransaction().begin();
        aluno = entityManager.find(AlunoModel.class, aluno.getIdpessoa());
        getEntityManager().remove(aluno);
        getEntityManager().getTransaction().commit();
        JOptionPane.showMessageDialog(null,"Aluno removido com sucesso!");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Aluno removido com sucesso!" + e.getMessage());
        }
    }

    public AlunoModel buscarId(long id)
    {
        try
        {
        return entityManager.find(AlunoModel.class, id);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"ID não encontrado" + e.getMessage());
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<AlunoModel> buscarTodos()
    {
        return entityManager.createQuery("FROM " + AlunoModel.class.getName()).getResultList();
    }

    public AlunoModel buscarCpf(AlunoModel aluno)
    {
        try
        {
            return (AlunoModel) entityManager.createQuery("FROM " + AlunoModel.class.getName() + " WHERE cpf = :cpf")
                    .setParameter("cpf", aluno.getCpf()).getSingleResult();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"CPF não encontrado" + e.getMessage());
        }
        return null;
    }
}

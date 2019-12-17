package hiberjpaaven.Dao;

import java.util.List;
import javax.swing.JOptionPane;
import hiberjpaaven.Model.AreaModel;

public class AreaDAO extends Conexao
{
    public void salvar(AreaModel area) 
    {
        try 
        {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(area);
            getEntityManager().getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }
    }
    public void editar(AreaModel area)
    {
        try
        {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(area);
            getEntityManager().getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + e.getMessage());
        }
    }

    public void remover(AreaModel area)
    {
        try
        {
            getEntityManager().getTransaction().begin();
            area = entityManager.find(AreaModel.class, area.getId());
            getEntityManager().remove(area);
            getEntityManager().getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Removido com sucesso!");
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao Remover: " + e.getMessage());
        }
    }

    public AreaModel buscarId(int id)
    {
        return entityManager.find(AreaModel.class, id);
    }
    @SuppressWarnings("unchecked")
    public List<AreaModel> buscarTodos()
    {
        return entityManager.createQuery("FROM " + AreaModel.class.getName()).getResultList();
    }
}

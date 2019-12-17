package hiberjpaaven.Dao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import hiberjpaaven.Model.CursoModel;


public class CursoDAO extends Conexao{
    public void salvar(CursoModel curso) 
    {
        try 
        {
                getEntityManager().getTransaction().begin();
                getEntityManager().persist(curso);
                getEntityManager().getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Curso salvo com sucesso!");
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o curso: " + e.getMessage());
        }
   }
   
    public void editar(CursoModel curso) 
    {
        try 
        {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(curso);
            getEntityManager().getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar o curso: " + e.getMessage());
        }
    } 
    
   public CursoModel buscarPorId(int id) 
   {
       try 
       {
            return entityManager.find(CursoModel.class, id);
       } 
       catch (Exception e) 
       {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o curso: " + e.getMessage());
       }
       return null;
   }
   
   @SuppressWarnings("unchecked")
   public List<CursoModel> buscarTodos() 
   {
       List<CursoModel> listaDeCurso = new ArrayList<>();
       try 
       {
            listaDeCurso = entityManager.createQuery("FROM " + CursoModel.class.getName()).getResultList();
       } 
       catch (Exception e) 
       {
           JOptionPane.showMessageDialog(null, "Erro ao buscar o curso: " + e.getMessage());
       }
       return listaDeCurso;
   }
   
   public void remover(CursoModel curso) 
   {
       try 
       {
            getEntityManager().getTransaction().begin();
            curso = entityManager.find(CursoModel.class, curso.getId());
            getEntityManager().remove(curso);
            getEntityManager().getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Removido com sucesso !");
       } 
       catch (Exception e) 
       {
           JOptionPane.showMessageDialog(null, "Erro ao remover o curso: " + e.getMessage());
       }
   }
   
   public CursoModel titulo(String titulo) 
   {
        CursoModel curso = new CursoModel();
        try 
        {
            curso = (CursoModel) entityManager.createQuery("FROM " + CursoModel.class.getName() + " WHERE titulo LIKE :titulo").setParameter("titulo", "%" + titulo + "%").getSingleResult();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o curso: " + e.getMessage());
        }
    return curso;
   }
   
   @SuppressWarnings("unchecked")
   public List<CursoModel> buscar(String titulo)
   {
        List<CursoModel> cursos = (List<CursoModel>) entityManager.createQuery("FROM " + CursoModel.class.getName() + " WHERE titulo LIKE :titulo").setParameter("titulo", "%" + titulo + "%").getResultList();
        return cursos;
   }
}
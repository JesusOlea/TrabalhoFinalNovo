package hiberjpaaven.Entrada;

import java.util.List;
import javax.swing.JOptionPane;
import hiberjpaaven.Dao.AreaDAO;
import hiberjpaaven.Model.AreaModel;
import hiberjpaaven.Model.ProfessorModel;

public class EntradaArea 
{
    public AreaDAO areaDao = new AreaDAO();

    public void salvar()
    {
        AreaModel area = new AreaModel();
        area.setDescricao(JOptionPane.showInputDialog("Descrição: "));
        areaDao.salvar(area);
    }

    public void editar()
    {
        AreaModel area = new AreaModel();
        area = areaDao.buscarId(Integer.parseInt(JOptionPane.showInputDialog("ID: ")));
        area.setDescricao(JOptionPane.showInputDialog("Descrição: "));
        areaDao.editar(area);
    }

    public void remover()
    {
        AreaModel area = new AreaModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID: "));
        area = areaDao.buscarId(id);
        areaDao.remover(area);
    }

    public void buscar()
    {
            AreaModel area = new AreaModel();
            area = areaDao.buscarId(Integer.parseInt(JOptionPane.showInputDialog("ID: ")));

            String lista = "ID: " + area.getId() + " Area: " + area.getDescricao() + "\n";
            List<ProfessorModel> professores = area.getProfessores();
            for(ProfessorModel professor : professores)
            {
                    String exibir1 = "ID: " + professor.getIdpessoa() + 
                                    " Nome: " + professor.getNome() + 
                                    " Idade: " + professor.getIdade() + 
                                    " CPF: " + professor.getCpf() + 
                                    " Sexo: " + professor.getSexo() + 
                                    " Siape: " + professor.getSiape() + "\n";
                    lista = lista + exibir1;
            }

            JOptionPane.showMessageDialog(null, lista);
    }

    public void exibirTodos()
    {
            String lista = "";
            List<AreaModel> areas = areaDao.buscarTodos();
            for(AreaModel area : areas) 
            {
        		String exibir = "\n ID: " + area.getId() + "-- Area: " + area.getDescricao();

                lista = lista + exibir;
            }

            JOptionPane.showMessageDialog(null, lista);
    }
}

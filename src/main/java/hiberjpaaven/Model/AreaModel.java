package hiberjpaaven.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "area")
public class AreaModel implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 40, nullable = false)
    private String descricao;

    @OneToMany(mappedBy="area", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<ProfessorModel> professores;

    public List<ProfessorModel> getProfessores()
    {
        return professores;
    }

    public void setProfessores(List<ProfessorModel> professores)
    {
        this.professores = professores;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    public String getDescricao()
    {
        return descricao;
    }
}
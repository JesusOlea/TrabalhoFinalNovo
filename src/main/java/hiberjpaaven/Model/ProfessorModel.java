
package hiberjpaaven.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@SuppressWarnings("serial")
@Entity
@Table(name = "professor")
@PrimaryKeyJoinColumn(name = "idpessoa")

public class ProfessorModel extends PessoaModel implements Serializable
{
    private int siape;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idArea", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private AreaModel area;
	
	@OneToMany(mappedBy="professor", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<CursoModel> cursos;

	public List<CursoModel> getCursos() {
		return cursos;
	}

	public void setCursos(List<CursoModel> cursos) {
		this.cursos = cursos;
	}

	public AreaModel getArea() {
		return area;
	}

	public void setArea(AreaModel area) {
		this.area = area;
	}
    
    public int getSiape()
    {
        return siape;
    }

    public void setSiape(int siape) 
    {
        this.siape = siape;
    }       
}

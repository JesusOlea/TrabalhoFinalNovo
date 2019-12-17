package hiberjpaaven.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
@Table(name = "curso")
public class CursoModel implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40, nullable = false)
    private String titulo;

    @Column(length = 40, nullable = false)
    private String descricao;

    @Column(length = 40, nullable = false)
    private String local;

    @Column(length = 40, nullable = false)
    private int quantidadeDeVagas;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idpessoa", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private ProfessorModel professor;

    @ManyToMany
    @JoinTable(name = "aluno_curso",
    joinColumns = @JoinColumn(name = "idcurso"),
    inverseJoinColumns = @JoinColumn(name = "idpessoa"))
    @Cascade(CascadeType.SAVE_UPDATE)
    private List<AlunoModel> listaDeAlunos;

    public ProfessorModel getProfessor() 
    {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) 
    {
       this.professor = professor;
    }

    public List<AlunoModel> getListaDeAlunos() 
    {
       return listaDeAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) 
    {
       this.listaDeAlunos = listaDeAlunos;
    }

    public int getId() 
    {
       return id;
    }

    public void setId(int id) 
    {
       this.id = id;
    }

    public String getTitulo() 
    {
       return titulo;
    }

    public void setTitulo(String titulo) 
    {
       this.titulo = titulo;
    }

    public String getDescricao() 
    {
       return descricao;
    }

    public void setDescricao(String descricao) 
    {
       this.descricao = descricao;
    }

    public String getLocal() 
    {
       return local;
    }

    public void setLocal(String local)
    {
       this.local = local;
    }

    public int getQuantidadeDeVagas() 
    {
       return quantidadeDeVagas;
    }

    public void setQuantidadeDeVagas(int quantidadeDeVagas) 
    {
       this.quantidadeDeVagas = quantidadeDeVagas;
    }

}
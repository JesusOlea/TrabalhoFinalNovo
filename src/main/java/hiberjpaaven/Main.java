package hiberjpaaven;

import javax.swing.JOptionPane;

import hiberjpaaven.Entrada.EntradaAluno;
import hiberjpaaven.Entrada.EntradaArea;
import hiberjpaaven.Entrada.EntradaCurso;
import hiberjpaaven.Entrada.EntradaProfessor;



public class Main 
{
    public static EntradaAluno entradaAluno = new EntradaAluno();
    public static EntradaProfessor entradaProfessor = new EntradaProfessor();
    public static EntradaArea entradaArea = new EntradaArea();
    public static EntradaCurso entradaCurso = new EntradaCurso();

    public static void main(String[] args)
    {
        int op1 = -1;
        while(op1 !=0)
        {
            String opcao = JOptionPane.showInputDialog("1 - Professor \n 2 - Aluno \n 3 - Area \n 4 - Curso \n 0 - Voltar ");
                    
            switch (opcao)
            {
                case "1":
                {
                 Professor();
                }
                break;
                case "2":
                {
                    Aluno();
                }
                break;
                case "3":
                {
                    Area();
                }
                break;
                case "4":
                {
                    Curso();
                }
                break;
                case "0":
                {
                    JOptionPane.showMessageDialog(null, "Saindo");
                   op1 = 0;
                }
                break;
                default:
                JOptionPane.showMessageDialog(null, "opção in");
            }
        }
    }
    public static void Professor()
    {
        boolean sw = true;		
        while(sw)
        {
            String opcao = JOptionPane.showInputDialog(null, "1 - Salvar\n" + "2 - Editar\n" + "3 - Remover\n" + "4 - Exibir\n" + "5 - Exibir Todos\n" + "0 - Voltar", "Professor", JOptionPane.INFORMATION_MESSAGE);
            switch(opcao)
            {
                case "1":
                {
                    entradaProfessor.salvar();
                }
                break;
                case "2":
                {
                	entradaProfessor.editar();
                }
                break;
                case "3":
                {      
                    entradaProfessor.remover();
                }
                break;
                case "4":
                {
                    entradaProfessor.cpf();
                }
                break;
                case "5":
                {
                    entradaProfessor.buscarTodos();
                }
                break;
                case "0":
                {
                    sw = false;
                }
                break;
                default: JOptionPane.showMessageDialog(null, "Opção invalida!");
            }
        }
    }
    public static void Aluno()
    {
        boolean sw = true;

        while(sw)
        {
            String opcao = JOptionPane.showInputDialog(null, "1 - Salvar\n" + "2 - Editar\n" + "3 - Remover\n" + "4 - Exibir\n" + "5 - Exibir Todos\n" + "0 - Voltar", "Professor", JOptionPane.INFORMATION_MESSAGE);
            switch(opcao)
            {
                case "1":
                {
                    entradaAluno.salvar();
                }
                break;
                case "2":
                {
                    entradaAluno.editar();
                }
                break;
                case "3":
                {
                    entradaAluno.remover();
                }
                break;
                case "4":
                {
                    entradaAluno.cpf();
                }
                break;
                case "5":
                {
                    entradaAluno.buscarTodos();
                }
                break;
                case "0":
                {
                    sw = false;
                }
                break;
                default: JOptionPane.showMessageDialog(null, "Opção invalida!");
            }
        }
    }

    public static void Area()
    {
        boolean sw = true;		
        while(sw)
        {
            String opcao = JOptionPane.showInputDialog(null, "1 - Salvar\n" + "2 - Editar\n" + "3 - Remover\n" + "4 - Exibir\n" + "5 - Exibir Todos\n" + "0 - Voltar", "Area", JOptionPane.INFORMATION_MESSAGE);
            switch(opcao)
            {
                case "1":
                {
                    entradaArea.salvar();
                }
                break;
                case "2":
                {
                    entradaArea.editar();
                }
                break;
                case "3":
                {
                    entradaArea.remover();
                }
                break;
                case "4":
                {
                    entradaArea.buscar();
                }
                break;
                case "5":
                {
                    entradaArea.exibirTodos();
                }
                break;
                case "0":
                {
                    sw = false;
                }
                break;
                default: JOptionPane.showMessageDialog(null, "Opção invalida!");
            }
        }
    }

    public static void Curso()
    {
        boolean sw = true;
        while(sw)
        {
            String opcao = JOptionPane.showInputDialog(null, "1 - Salvar\n" + "2 - Editar\n" + "3 - Remover\n" + "4 - Exibir\n" + "5 - Exibir Todos\n" + "6 - Cadastro Professor em curso\n" + "7 - Cadastro Aluno em curso\n" + "0 - Voltar", "Curso", JOptionPane.INFORMATION_MESSAGE);
            switch(opcao)
            {
                case "1":
                {
                    entradaCurso.salvar();
                }
                break;
                case "2":
                {
                    entradaCurso.editar();
                }
                break;
                case "3":
                {
                    entradaCurso.remover();
                }
                break;
                case "4":
                {
                    entradaCurso.buscar();
                }
                break;
                case "5":
                {
                    entradaCurso.buscarTodos();
                }
                break;
                case "6":
                {
                    entradaCurso.professor();
                }
                break;
                case "7":
                {
                    entradaCurso.aluno();
                }
                break;
                case "0":
                {
                        sw = false;
                }
                break;
                default: JOptionPane.showMessageDialog(null, "Opção invalida!");
            }
        }
    }
}
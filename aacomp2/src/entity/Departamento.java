package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Departamento  implements Serializable
{
	private String nomeDepartamento;
	private String siglaDepartamento;

	private ArrayList <Funcionario> funcionario;
	private ArrayList <Curso> curso;


	public Departamento(String nomeDepartamento)
	{
		setNomeDepartamento(nomeDepartamento);
		funcionario = new ArrayList <Funcionario>();
		curso = new ArrayList <Curso>();

	}

	
	/****esse é o método compararSiglas  recebendo uma única  sigla como parâmetro*/

	public boolean compararSiglas(String sigla)
	{
		boolean ehIgual = false;

		/*passando sigla para uppercase, pois se uma letra for minúscula mas a sigla for igual,
		 * irá retornar ehIgual = false */
		sigla.toUpperCase();

		if(getSiglaDepartamento() == sigla)
		{
			//System.out.println("Sigla inválida. Já exite!!!");
			ehIgual = true;

		}

		return ehIgual;
	}

/**************************************Métodos Getters and Setters*******************************************/

	public void adicionarFuncionario(Funcionario novoFuncionario)
	{
		funcionario.add(novoFuncionario);
	}  



	public ArrayList<Funcionario> getFuncionario() 
	{
		return funcionario;
	}


	public void setFuncionario(ArrayList<Funcionario> funcionario) 
	{
		this.funcionario = funcionario;
	}


	public void adicionarCurso(Curso curso)
	{
		this.curso.add(curso);
	}

	public ArrayList<Curso> getCurso() 
	{
		return curso;
	}


	public void setCurso(ArrayList<Curso> curso) 
	{
		this.curso = curso;
	}


	public String getNomeDepartamento() 
	{
		return nomeDepartamento;
	}


	public void setNomeDepartamento(String nomeDepartamento) 
	{
		this.nomeDepartamento = nomeDepartamento;
	}


	public String getSiglaDepartamento() 
	{
		return siglaDepartamento;
	}


	public void setSiglaDepartamento(String siglaDepartamento) 
	{
		siglaDepartamento.toUpperCase();

		this.siglaDepartamento = siglaDepartamento;
	}
	
/*******************************************Metódo temporário de teste***************************************/

	public String toString()
	{
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append("Nome departamento:  ");
		stringBuffer.append(getNomeDepartamento());
		stringBuffer.append(", Sigla: ");
		stringBuffer.append(getSiglaDepartamento());

		return stringBuffer.toString();
	}



}

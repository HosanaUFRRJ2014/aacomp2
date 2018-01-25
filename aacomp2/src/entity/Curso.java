package entity;

import java.io.Serializable;
import java.util.ArrayList;


public class Curso  implements Serializable
{
	private String nomeCurso;
	private String siglaCurso;
	
	private ArrayList <Aluno> aluno;
	private Departamento departamento;
	
	
	public Curso(Departamento departamento,String nome)
	{
		setNomeCurso(nome);
		aluno = new ArrayList <Aluno> ();
		
		departamento.adicionarCurso(this);
		setDepartamento(departamento);
	}
	
	public boolean compararSiglas(ArrayList <Curso> cursosJaExistentes)
	{
		boolean ehIgual = false;
		
		for(int i = 0; cursosJaExistentes.get(i) != null; i++)
		{
			//comparando a sigla setada com a sigla de cada curso do array
			if(getSiglaCurso() == cursosJaExistentes.get(i).getSiglaCurso())
			{
				//System.out.println("Sigla inválida. Já exite!!!");
				this.siglaCurso = null;
				ehIgual = true;
			}
				
		}
		
		return ehIgual;
	}
	 
	
	public boolean compararSiglas(String sigla)
	{
		boolean ehIgual = false;
		
		/*passando sigla para uppercase, pois se uma letra for minúscula mas a sigla for igual,
		 * irá retornar ehIgual = false */
		
		sigla.toUpperCase();
		
			if(getSiglaCurso() == sigla)
			{
				//System.out.println("Sigla inválida. Já exite!!!");
				ehIgual = true;
			}
					
		return ehIgual;
	}
	
	/**************************************Métodos Getters and Setters*******************************************/
	
	
	public void adicionarAluno(Aluno novoAluno)
	{
		aluno.add(novoAluno);
	}
	

	public ArrayList<Aluno> getAluno() 
	{
		return aluno;
	}

	public void setAluno(ArrayList<Aluno> aluno)
	{
		this.aluno = aluno;
	}

	public String getNomeCurso() 
	{
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) 
	{
		this.nomeCurso = nomeCurso;
	}

	public String getSiglaCurso() 
	{
		return siglaCurso;
	}

	public void setSiglaCurso(String siglaCurso) 
	{
		siglaCurso.toUpperCase();
		this.siglaCurso = siglaCurso;
	}

	
	
	public Departamento getDepartamento() 
	{
		return departamento;
	}

	public void setDepartamento(Departamento departamento) 
	{
		this.departamento = departamento;
	}
	
/*******************************************Metódo temporário de teste***************************************/
	
	public String toString()
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append("Nome: Curso: ");
		stringBuffer.append(getNomeCurso());
		stringBuffer.append(", Sigla: ");
		stringBuffer.append(getSiglaCurso());

		
		return stringBuffer.toString();
	}
	

}

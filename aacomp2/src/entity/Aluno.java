package entity;

import java.io.Serializable;


public class Aluno extends Consumidor 
{
    private Curso curso;


	public Aluno(String nome, String matrícula, int anoIngresso,Curso curso) 
	{
		super(nome, matrícula, anoIngresso);
		setCurso(curso);
		
	}
	
/***************************************Métodos Getters and Setters*******************************************/	
	public Curso getCurso() 
	{
		return curso;
	}

	public void setCurso(Curso curso) 
	{
		curso.adicionarAluno(this);
		this.curso = curso;
	}


/*******************************************Metódo temporário de teste***************************************/	

	public String toStringAluno()
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append("Sigla Curso: ");
		stringBuffer.append(getCurso().getSiglaCurso());
		
		return  toString() + stringBuffer; 
	}
}

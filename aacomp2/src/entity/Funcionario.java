package entity;

import java.io.Serializable;



public class Funcionario extends Consumidor 
{

	private Departamento departamento;
	
	public Funcionario(String nome, String matrícula, int anoIngresso, Departamento departamento) 
	{
		super(nome, matrícula, anoIngresso);
		setDepartamento(departamento);
		
	}
	
/***************************************Métodos Getters and Setters*******************************************/
	
	public Departamento getDepartamento() 
	{
		return departamento;
	}

	public void setDepartamento(Departamento departamento) 
	{
		departamento.adicionarFuncionario(this);
		this.departamento = departamento;
	}
	
/*******************************************Metódo temporário de teste***************************************/	
	public String toStringFuncionario()
	{
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append("Sigla Departamento: ");
		stringBuffer.append(getDepartamento().getSiglaDepartamento());
		
		return  toString() + stringBuffer; 
	}

}

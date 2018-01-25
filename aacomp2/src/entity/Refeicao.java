package entity;

import java.io.Serializable;

public abstract class Refeicao implements  Serializable
{
	
	private String descricao;
	private String opcaoVegetariana;



	public Refeicao(String descricao, String opcaoVegetariana)
	{
		setDescricao(descricao);
		setOpcaoVegetariana(opcaoVegetariana); 
	}

/********************************************Métodos abstratos***********************************************/
	
	public abstract double valor(Consumidor consumidor); 

	public abstract String getTurno();

	/*Há uma ambiguidade no texto que define a Atividade Acadêmica:
	 * Primeiro está escrito: "Aṕos a criação da refeição o seu turno não pode ser alterado!"
	 * Depois, um pouco abaixo está escrito: "O sistema permitirá alterar o turno,[...] de qualquer refeição."
	 * Se for seguido que não será possível alterar o turno, não será necessário o método "setTurno" ser público
	 * */

	/*public void setTurno(Turno turno) 
	{
		this.turno = turno;
	}*/


/**************************************Métodos Getters and Setters*******************************************/
	
	public String getDescricao() 
	{
		return descricao;
	}



	public void setDescricao(String descricao) 
	{
		this.descricao = descricao;
	}



	public String getOpcaoVegetariana() 
	{
		return opcaoVegetariana;
	}



	public void setOpcaoVegetariana(String opcaoVegetariana) 
	{
		this.opcaoVegetariana = opcaoVegetariana;
	}

/*******************************************Metódo temporário de teste***************************************/
	
	public String toString()
	{
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append("Turno: ");
		stringBuffer.append(getTurno());
		stringBuffer.append(" Descrição:  ");
		stringBuffer.append(getDescricao());
		stringBuffer.append(" Opção Vegetariana:  ");
		stringBuffer.append(getOpcaoVegetariana());

		return  stringBuffer.toString(); 
	}

}

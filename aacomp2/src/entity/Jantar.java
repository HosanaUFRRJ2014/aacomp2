package entity;

import java.io.Serializable;


public class Jantar extends Refeicao 
{
	
	
	public Jantar(String descricao, String opcaoVegetariana) 
	{
		super(descricao, opcaoVegetariana);
		
		
	}
	
	public String getTurno()
	{
		return EnumTurno.NOITE.name();
	}
	

	public double valor(Consumidor consumidor)
	{
		double valor = 0;
		
		if(consumidor instanceof Aluno)
			valor = 1.0;
		
		if(consumidor instanceof Funcionario)
			valor = 6.0;
		
		
		return valor;
	}

}

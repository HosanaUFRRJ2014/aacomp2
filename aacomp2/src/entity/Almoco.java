package entity;

import java.io.Serializable;



public class Almoco extends Refeicao
{
	

	public Almoco(String descricao, String opcaoVegetariana) 
	{
		super(descricao, opcaoVegetariana);
		
		//setTurno(new TurnoTarde());
	
	}
	
	public String getTurno()
	{
		return EnumTurno.TARDE.name();
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

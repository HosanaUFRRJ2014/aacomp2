package entity;

import java.io.Serializable;



public class Dejejum extends Refeicao 
{
	
	public Dejejum(String descricao, String opcaoVegetariana) 
	{
		
		super(descricao, opcaoVegetariana);
		//setTurno(new TurnoManha());
		
	}
	

	
	public String getTurno()
	{
		return EnumTurno.MANHA.name();
	}
	
	public double valor(Consumidor consumidor)
	{
		double valor = 0;
		
		if(consumidor instanceof Aluno)
			valor = 0.5;
		
		if(consumidor instanceof Funcionario)
			valor = 3.0;
		
		
		return valor;
	}

}

package entity;

import java.io.Serializable;

public class Ticket  implements Serializable
{
	private double valor;
	private boolean pago;
	private Refeicao refeicaoConsumida;
	private Consumidor consumidor;

	public Ticket(Consumidor consumidor,Refeicao refeicao,boolean pago)
	{
		setRefeicaoConsumida(refeicao);
		setConsumidor(consumidor);
		
		setValor(consumidor,refeicao);
		
		/*adicionando esse ticket ao array de tickets do Consumidor*/
		getConsumidor().getTicket().add(this);
		
		
		//	setValor(valor);
		setPago(pago);

	}

	/* Não será permitido alterar valor após a criação do Ticket*/
	/**/
	public void setValor(double valor) 
	{
		this.valor = valor;
	}

	/**Fazendo o método que recebe Consumidor e um consumidor e uma refeição e retorna o valor do ticket**/

	/*Seria melhor que esse fosse void para setar logo no construtor e depois fizesse um outro que retornasse
	 * o valor*/
	public void setValor(Consumidor consumidor,Refeicao refeicao)
	{
		valor = refeicao.valor(consumidor);
	}
	
/**************************************Métodos Getters and Setters normais*******************************************/

	/**/
	public double getValor() 
	{
		return valor;
	}
	
	public boolean isPago() 
	{
		return pago;
	}

	public void setPago(boolean pago) 
	{
		this.pago = pago;
	}

	public Refeicao getRefeicaoConsumida() 
	{
		return refeicaoConsumida;
	}

	/* Não será permitido alterar refeicão após a criação do Ticket*/
	private void setRefeicaoConsumida(Refeicao refeicaoConsumida) 
	{
		this.refeicaoConsumida = refeicaoConsumida;
	}

	public Consumidor getConsumidor() 
	{
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) 
	{
		this.consumidor = consumidor;
	}


/*******************************************Metódo temporário de teste***************************************/
	public String toString()
	{
		/*O sistema listará todos os tickets apresentando o a matrícula do consumidor, o valor, se foi pago,
        O turno e a descrição da refeição.*/

		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append("Matrícula do Consumidor: ");
		stringBuffer.append(getConsumidor().getMatricula());
		stringBuffer.append("  Valor:  ");
		stringBuffer.append(getValor());
		stringBuffer.append(" Pago:  ");
		stringBuffer.append(isPago());
		stringBuffer.append(" Turno: ");
		stringBuffer.append(getRefeicaoConsumida().getTurno());
		stringBuffer.append(" Descrição da refeição: ");
		stringBuffer.append(getRefeicaoConsumida().getDescricao());

		return  stringBuffer.toString(); 
	}


}

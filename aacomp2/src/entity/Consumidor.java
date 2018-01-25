package entity;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Consumidor implements Serializable
{

	private String nomeConsumidor;
	private String matricula;
	private int anoIngresso;
	private Sexo sexo;
	private Titulo titulo;
	private String CPF;
	private ArrayList <Ticket> ticket;
	private ValidarCPF valida;

	private int contadorAlteracaoCPF = 0;


	public Consumidor(String nome,String matrícula, int anoIngresso)
	{
		setNomeConsumidor(nome);
		setMatricula(matrícula);
		setAnoIngresso(anoIngresso); 

		ticket = new ArrayList <Ticket> ();

	}

/**************************************Métodos Getters and Setters*******************************************/
	
	public String getNomeConsumidor() 
	{
		return nomeConsumidor;
	}


	public void setNomeConsumidor(String nomeConsumidor) 
	{
		// O sistema permite alterar
		this.nomeConsumidor = nomeConsumidor;
	}


	public String getMatricula() 
	{
		return matricula;
	}


	public void setMatricula(String matricula2) 
	{
		// O sistema permite alterar
		this.matricula = matricula2;
	}


	public Sexo getSexo() 
	{
		return sexo;
	}


	public void setSexo(Sexo sexo)
	{
		// O sistema permite alterar
		this.sexo = sexo;
	}


	public int getAnoIngresso() 
	{
		return anoIngresso;
	}


	private void setAnoIngresso(int anoIngresso) 
	{// o sistema não permite alterar
		this.anoIngresso = anoIngresso;
	}


	public Titulo getTitulo() 
	{
		return titulo;
	}

    /**idem a contadorAlteracaoCPF*/
	/*private void setTitulo(Titulo titulo)
      { o sistema não permite alterar
		this.titulo = titulo;
	}*/


	public String getCPF() 
	{
		return CPF;
	}


	/*   ****falta implementar:  não permitir CPFs iguais ***********/

	public boolean setCPF(String CPF) 
	{   
		
	
		// o sistema só permite setar uma única vez o valor

		if(contadorAlteracaoCPF == 0)
		{
			valida = new ValidarCPF();
			
			if(valida.meuValidarCPF(CPF) == true)
			{
				this.CPF = CPF;
				contadorAlteracaoCPF++;
				return true;
			}
			
			else
			{
				//System.out.println("CPF inválido");
				return false;
			}
				
		}
		else
			return false;
			
		
		
	}


	public ArrayList <Ticket> getTicket() 
	{
		return ticket;
	}


	public void setTicket(ArrayList <Ticket> ticket) 
	{
		this.ticket = ticket;
	}

	/***vou fazer isso como agregacao apenas na classe Sistema. O
	 * Sistema cria o ticket que pertencerá ao consumidor*/
	/*	public void criarNovoTicket(Refeicao refeicao, boolean pago)
	{
		/*** Isso é uma Composição***/
	/* pega a refeicao em si e o seu valor com o próprio consumidor como parâmetro

		Ticket ticket = new Ticket(this,refeicao);
		ticket.setConsumidor(this);

		this.ticket.add(ticket);


	}*/

/*******************************************Metódo temporário de teste***************************************/

	public String toString()
	{

		/*o nome, a
        matricula, o ano de ingresso, o sexo, o código do departamento (caso seja funcionário), o código
        do curso(caso seja aluno) e o CPF.*/

		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append("Nome: ");
		stringBuffer.append(getNomeConsumidor());
		stringBuffer.append("  ano de Ingresso: ");
		stringBuffer.append(getAnoIngresso());
		stringBuffer.append("  Sexo: ");
		stringBuffer.append(getSexo());
		stringBuffer.append("  CPF: ");
		stringBuffer.append(getCPF());

		return stringBuffer.toString();
	}



	/*	public void adicionarTicket(Ticket ticket)
	{
		this.ticket.add(ticket);
		ticket.setConsumidor(this);
	}
	 */	




}

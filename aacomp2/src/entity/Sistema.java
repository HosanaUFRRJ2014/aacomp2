package entity;

import java.io.Serializable;
import java.util.ArrayList;
/** 
 * @author hosana
 *  Essa classe permirá retornar e salvar as listas de consumidores, refeições,cursos e tickets
 *  Podemos fazê-la de dois modos: ou com agregação ou por composição
 *  Estou fazendo como agregação, pois ficou muito confuso pelo outro modo.
 */
public class Sistema implements Serializable
{

	private ArrayList <Consumidor> listaConsumidores;
	private ArrayList <Refeicao> listaRefeicoes;
	private ArrayList <Curso> listaCursos;
	private ArrayList <Ticket> listaTickets;

	/*não está especificado em: "funções necessárias para a AA de comp2"*/
	private ArrayList <Departamento>listaDepartamento;

	/**/

	public Sistema()
	{
		listaConsumidores = new ArrayList <Consumidor> ();
		listaRefeicoes = new ArrayList <Refeicao> ();
		listaCursos = new ArrayList  <Curso> ();
		listaTickets = new ArrayList  <Ticket> ();


		listaDepartamento = new ArrayList <Departamento> ();
	}
	
	
/**###########################################################################################################**
	
                    	*******Métodos que adicionam um novo objeto aos arrays do sistema**********

**###########################################################################################################**/
	
	public void adicionarNovoConsumidor(Consumidor consumidor)
	{
		listaConsumidores.add(consumidor);
	}



	public void adicionarNovoCurso(Curso curso)
	{
		listaCursos.add(curso);
	}

	public void adicionarNovoTicket(Ticket ticket)
	{

		listaTickets.add(ticket);

	}

	

	public void adicionarNovaRefeicao(Refeicao refeicao)
	{
		listaRefeicoes.add(refeicao);
	}

	public void adicionarNovoDepartamento(Departamento departamento)
	{
		listaDepartamento.add(departamento);
	}
	
/**###########################################################################################################**
	
	         ********Métodos que retornam e setam um arrayList dos objetos do problema***********

**###########################################################################################################**/


	public ArrayList<Consumidor> getListaConsumidores() 
	{
		return listaConsumidores;
	}

	public void setListaConsumidores(ArrayList<Consumidor> listaConsumidores) 
	{

		this.listaConsumidores = listaConsumidores;
	}

	public ArrayList<Refeicao> getListaRefeicoes() 
	{
		return listaRefeicoes;
	}

	public void setListaRefeicoes(ArrayList<Refeicao> listaRefeicoes) 
	{
		this.listaRefeicoes = listaRefeicoes;
	}

	public ArrayList<Curso> getListaCursos() 
	{
		return listaCursos;
	}

	public void setListaCursos(ArrayList<Curso> listaCursos) 
	{
		this.listaCursos = listaCursos;
	}

	public ArrayList<Ticket> getListaTickets() 
	{

		return listaTickets;
	}

	public void setListaTickets(ArrayList<Ticket> listaTickets) 
	{
		this.listaTickets = listaTickets;
	}

	public ArrayList<Departamento> getListaDepartamento() 
	{
		return listaDepartamento;
	}

	public void setListaDepartamento(ArrayList<Departamento> listaDepartamento) 
	{
		this.listaDepartamento = listaDepartamento;
	}

	
	/****esse é o método compararSiglas  recebendo um array de departamentos como parâmetro*/
	public boolean compararSiglasDepartamentos(String siglaPretendida ,ArrayList <Departamento> departamentosJaExistentes)
	{
		boolean ehIgual = false;

		for(int i = 0; i <  departamentosJaExistentes.size(); i++)
		{
			//comparando a sigla setada com a sigla de cada departamento do array
			if(siglaPretendida.equalsIgnoreCase(departamentosJaExistentes.get(i).getSiglaDepartamento()))
			{
				
				/*Colocando a sigla do obleto atual como null para não ficar armazenada um asigla já exstente*/
			//	this.siglaDepartamento = null;
				
				ehIgual = true;
				break;
			}

		}

		return ehIgual;
	}
	
	/****esse é o método compararSiglas  recebendo um array de Cursos como parâmetro*/
	public boolean compararSiglaCursos(String siglaPretendida ,ArrayList <Curso> CursosJaExistentes)
	{
		boolean ehIgual = false;

		for(int i = 0; i <  CursosJaExistentes.size(); i++)
		{
			//comparando a sigla setada com a sigla de cada Curso do array
			if(siglaPretendida.equalsIgnoreCase(CursosJaExistentes.get(i).getSiglaCurso()))
			{
				
				/*Colocando a sigla do obleto atual como null para não ficar armazenada um asigla já exstente*/
			//	this.siglaCurso = null;
				
				ehIgual = true;
				break;
			}

		}

		return ehIgual;
	}
	
	public boolean compararCPFIguais(String cpfPretendido ,ArrayList <Consumidor> consumidoresJaExistentes)
	{
		boolean ehIgual = false;

		for(int i = 0; i <  consumidoresJaExistentes.size(); i++)
		{
			//comparando a sigla setada com a sigla de cada Curso do array
			if(cpfPretendido.equalsIgnoreCase(consumidoresJaExistentes.get(i).getCPF()))
			{
				
				/*Colocando a sigla do obleto atual como null para não ficar armazenada um asigla já exstente*/
			//	this.siglaCurso = null;
				
				ehIgual = true;
				break;
			}

		}

		return ehIgual;
	}

/**###########################################################################################################**
	
                            *********Os próximos métodos são temporários***********

**###########################################################################################################**/
	
	
	/***
	 *       Os próximos métodos não são permanentes
	 **/

	/**"O sistema listará todos consumidores disponíveis até o momento apresentando o nome, a
      matricula, o ano de ingresso, o sexo, o código do departamento (caso seja funcionário), o código
     do curso(caso seja aluno) e o CPF."**/
	public void imprimirConsumidores()
	{
		for(int i = 0; i < listaConsumidores.size(); i++)
		{
			System.out.println(listaConsumidores.get(i).toString());
		}
	}

	/**"O sistema listará todas as refeições disponíveis até o momento apresentando o turno, a descrição
    e a opção vegetariana."*/
	public void imprimirRefeicoes()
	{
		for(int i = 0; i < listaRefeicoes.size(); i++)
		{
			System.out.println(listaRefeicoes.get(i).toString());
		}
	}

	/**"O sistema listará todos os tickets apresentando o a matrícula do consumidor, o valor, se foi pago,
    O turno e a descrição da refeição."*/
	public void imprimirTickets()
	{
		for(int i = 0; i < listaTickets.size(); i++)
		{
			System.out.println(listaTickets.get(i).toString());
		}
	}


}

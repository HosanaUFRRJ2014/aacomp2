package entity;

import java.io.Serializable;

public class ValidarCPF  implements Serializable
{
	private int digitoControle1;
	private int digitoControle2;
	private boolean valido;
	private char [] arrayCPF;
	private int [] CPF = {0,0,0,0,0,0,0,0,0,0,0};

	public char [] converteStringToCharArray(String stringCPF)
	{
		arrayCPF = stringCPF.toCharArray();

		return arrayCPF;
	}

	public int [] converteIntToArrayInt(int intCPF)
	{
		String stringCPF = Integer.toString(intCPF);

		char [] arrayCharCPF = converteStringToCharArray(stringCPF);

		int [] CPF = {};

		for(int i = 0 ; i < arrayCharCPF.length; i++)
		{
			CPF[i] = (int) arrayCharCPF[i];
		}

		return CPF;
	}


	/**Métodos de "Funções necessárias para a AA de comp2"**/


	public int converteStringToInteiro(String stringCPF)
	{
		/*Tirando pontos, traços e espacos*/
		stringCPF = stringCPF.replace(".","");
		stringCPF = stringCPF.replace("-","");
		stringCPF = stringCPF.replace(" ","");

		converteStringToCharArray(stringCPF);

		/*Transformando em int*/
		int intCPF = Integer.parseInt(stringCPF);

		return intCPF;
	}



	public boolean validarCPF(int intCPF)
	{

		int [] CPF = converteIntToArrayInt(intCPF);


		int soma = 0;
		int multiplicador = 2;

		for(int i = 8; i > -1; i--)
		{
			soma  = soma + CPF[i] * multiplicador;
			multiplicador ++;
		}

		digitoControle1  = 11 - (soma % 11);


		soma = 0;
		multiplicador = 2;


		for(int i = 9; i > -1; i--)
		{
			soma  = soma + CPF[i] * multiplicador;
			multiplicador ++;
		}

		digitoControle2  = 11 - (soma % 11) ;

		if(CPF[10] == digitoControle2 && CPF[9] == digitoControle1)
		{
			System.out.println("CPF é válido");
			valido = true;
		}

		else
		{
			valido = false;
			System.out.println("CPF inválido");
		}



		return valido;
	}

	/*Não seria mais fácil um  método que converta de string para char array, de char array para int array?*/

	public boolean meuValidarCPF(String stringCPF)
	{
		/*Tirando pontos, traços e espacos*/

		stringCPF = stringCPF.replace(".","");
		stringCPF = stringCPF.replace("-","");
		stringCPF = stringCPF.replace(" ","");

		// considera-se erro CPF's formados por uma sequencia de numeros iguais 
		if (stringCPF.equals("00000000000") || stringCPF.equals("11111111111") || stringCPF.equals("22222222222") || stringCPF.equals("33333333333") || stringCPF.equals("44444444444") || stringCPF.equals("55555555555") || stringCPF.equals("66666666666") || stringCPF.equals("77777777777") || stringCPF.equals("88888888888") || stringCPF.equals("99999999999") || stringCPF.length() != 11) 
			return(false);

		else
		{


			/*Convertendo para um array de Char*/

			char [] arrayCharCPF = converteStringToCharArray(stringCPF);

			// CPF = {0,0,0,0,0,0,0,0,0,0,0};


			/* Convertendo para um array de int */

			for(int i = 0 ; i < arrayCharCPF.length; i++)
			{

				switch(arrayCharCPF[i])
				{
				case '0':
					CPF[i] = 0;
					break;
				case '1':
					CPF[i] = 1;
					break;
				case '2':
					CPF[i] = 2;
					break;
				case '3':
					CPF[i] = 3;
					break;
				case '4':
					CPF[i] = 4;
					break;
				case '5':
					CPF[i] = 5;
					break;
				case '6':
					CPF[i] = 6;
					break;
				case '7':
					CPF[i] = 7;
					break;
				case '8':
					CPF[i] = 8;
					break;
				case '9':
					CPF[i] = 9;
					break;


				}
			}

			/*Algorítimo de validação de CPF*/



			int soma = 0;
			int multiplicador = 2;

			for(int i = 8; i > -1; i--)
			{
				soma  = soma + CPF[i] * multiplicador;
				multiplicador ++;
			}

			digitoControle1  = 11 - (soma % 11);


			soma = 0;
			multiplicador = 2;


			for(int i = 9; i > -1; i--)
			{
				soma  = soma + CPF[i] * multiplicador;
				multiplicador ++;
			}

			digitoControle2  = 11 - (soma % 11) ;

			if(CPF[10] == digitoControle2 && CPF[9] == digitoControle1)
				valido = true;

			else
				valido = false;




			return valido;

		}

	}






}

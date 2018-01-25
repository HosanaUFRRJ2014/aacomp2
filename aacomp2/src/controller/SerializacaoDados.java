package controller;

import java.io.*;

import javax.swing.JOptionPane;

import entity.*;

public class SerializacaoDados {
		
		//M�todo que serve para salvar qualquer uma das listas, sendo diferenciadas pelo nome do arquivo.
		public static void salvarLista(Serializable listaParaSalvar, String arquivoNome) {
			try
			{
				String NomeArquivo = "./" + arquivoNome;	
				FileOutputStream fileOut = new FileOutputStream(NomeArquivo);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(listaParaSalvar);
				out.close();
				fileOut.close();
				//System.out.println("Dados de serialização salvos em: " + NomeArquivo);
						
			}catch(IOException i)
			{
				i.printStackTrace();
			}
		}
		
		//Ir� retornar a lFile f1 = new File(NomeListaConsumidor);ista mais atualizada atrav�s do nome do arquivo(que servir� para identificar o tipo de lista que queremos obter).
		public static Serializable carregarLista(String NomeArquivoLista){
			Serializable listaDesSerializada = null;
			
			try
			{
				FileInputStream fileIn = new FileInputStream(NomeArquivoLista);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				listaDesSerializada = (Serializable)in.readObject();
				in.close();
				fileIn.close();
				
				return listaDesSerializada;
				
			}catch(IOException i)
			{
				i.printStackTrace();
			}catch(ClassNotFoundException c)
			{
				JOptionPane.showMessageDialog(null,"Classe não encontrada!");
				c.printStackTrace();
			}

			return listaDesSerializada;
		}
			
		//M�todo que salvar� um elemento refei��o ou ticket na lista de refei��es ou tickts, respectivamente.
		public static void adicionarElementoListaRefeicao(Refeicao elemento, Sistema sistema, String nomeArquivoRefeicao){
			
			sistema.getListaRefeicoes().add(elemento);
			salvarLista(sistema.getListaRefeicoes(), nomeArquivoRefeicao);
		}
		
		public static void adicionarElementoListaTicket(Ticket elemento, Sistema sistema, String nomeArquivoTicket){
			
			sistema.getListaTickets().add(elemento);
			salvarLista(sistema.getListaTickets(), nomeArquivoTicket);
		}
		
		//----------------------------------Caso serializar o objeto do Sistema-----------------------------------------
		
		//Criar� o nome do arquivo para serializa��o(servir� apenas se vc quiser serializar o Sistema como todo)
		public static String criarNomeDeArquivoParaSerializacao(Serializable objetoParaSerializar){
			String NomeArquivo = objetoParaSerializar.getClass().getName()+".ser";
			return NomeArquivo;

		}
		
		//M�todo que serve para salvar o Sistema.
		public static void salvarSistema(Serializable sistema) {
			try
			{
				String NomeArquivo = "./" + criarNomeDeArquivoParaSerializacao(sistema);	
				FileOutputStream fileOut = new FileOutputStream(NomeArquivo);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(sistema);
				out.close();
				fileOut.close();
				//System.out.println("Dados de serialização salvos em: " + NomeArquivo);

			}catch(IOException i)
			{
				i.printStackTrace();
			}
		}
		
		//M�todo que serve para dar load nos dados do Sistema.
		public static Serializable carregarSistema(String NomeArquivoSistema){
			Serializable sistemaDesSerializado = null;
			
			try
			{
				FileInputStream fileIn = new FileInputStream(NomeArquivoSistema);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				sistemaDesSerializado = (Serializable)in.readObject();
				in.close();
				fileIn.close();
				
				return sistemaDesSerializado;
				
			}catch(IOException i)
			{
				i.printStackTrace();
			}catch(ClassNotFoundException c)
			{
				JOptionPane.showMessageDialog(null,"Classe não encontrada!");
				c.printStackTrace();
			}

			return sistemaDesSerializado;
		}		
}

package entity;

public enum EnumTurno 
{

	MANHA(0.5,3.0),	
	TARDE(1,6),
	NOITE(1,6);
	
	private double valorAluno;
	private double valorFuncionario;
	
	public double getValorAluno() {
		return valorAluno;
	}
	
	public double getValorFuncionario() {
		return valorFuncionario;
	}
	
	EnumTurno(double valorAluno,double valorFuncionario){
		this.valorAluno = valorAluno;
		this.valorFuncionario = valorFuncionario;
		
	}
	
	
}

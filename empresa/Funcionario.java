package br.com.aurelio.empresa;

public abstract class Funcionario implements Comparable<Funcionario> {
	
	protected String nome;
	
	protected double salario;
	
	protected double bonificacao;
	
	private String departamento;
	
	private Data dataEntrada = new Data();
	
	private String rg;
	
	private boolean estaNaEmpresa = true;
	
	static int identificador = 0;
	
	public Funcionario(){
		identificador++;
	}
	
	public Funcionario(String nome ){
		identificador++;
		this.nome = nome;
	}
	
	public void setBonificacao(double aumento){
		this.bonificacao = this.salario * 1.4;	
	}
	
	public double getBonificacao(){
		return this.bonificacao;
	}
	
	void demite(){
		this.estaNaEmpresa = false;
	}
	
	double getGanhoAnual(){
		return this.salario * 12;
	}
	
	
	
	public static int getIdentificador(){
		return identificador;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDataEntrada() {
		return dataEntrada.formatadata();
	}

	public void setDataEntrada(Data dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public boolean isEstaNaEmpresa() {
		return estaNaEmpresa;
	}

	public void setEstaNaEmpresa(boolean estaNaEmpresa) {
		this.estaNaEmpresa = estaNaEmpresa;
	}
	

	@Override
	public int compareTo(Funcionario o) {
		return this.nome.compareTo(o.getNome());
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
        if(!(obj instanceof Funcionario)) return false; 

        if(obj == this) return true;

        Funcionario empregado = (Funcionario) obj; 

        return this.rg == empregado.getRg();
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", salario=" + salario + ", bonificacao=" + bonificacao + ", departamento="
				+ departamento + ", dataEntrada=" + getDataEntrada() + ", rg=" + rg + ", estaNaEmpresa=" + estaNaEmpresa
				+ "]";
	}

	
	
}




	



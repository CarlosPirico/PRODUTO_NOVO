package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Produto {
	
	// criando atributos.
	private String nome;
	private double custo;
	private double venda;
	private LocalDate fabricacao;
	private LocalDate validade;
	
	// criando construtor e usando metodos privados para data.
	public Produto(String nome, double custo, String fabricacao) throws Exception {
		this.nome = nome;
		this.custo = custo;
		this.venda = custo *= 1.10;
		LocalDate fabri = getValidateDate(fabricacao);
		this.fabricacao = fabri;
		this.validade = fabri.plusMonths(1);
	}
	
	// metodo privado para validar a data validas até hoje e formatando string para localdate.
	private LocalDate getValidateDate(String fabriString) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fabriFormat = LocalDate.parse(fabriString, formatter);
		if (fabriFormat.minusDays(1).isBefore(LocalDate.now())) {
			return fabriFormat;			
		} else {
			throw new Exception("Data de fabricação deve ser até hoje");
		}
	}
	
	// retornando todos os dados do objeto e formatando valores numericos para apenas 2 casa apos a ","
	// e convertendo as datas em formato de calendario.
	public String toString() {
		return "Nome: " + nome +
			   "\nCusto: R$" + String.format("%.2f", custo) + 
			   "\nVenda: R$" + String.format("%.2f", venda) + 
			   "\nFabricacao: " + fabricacao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + 
			   "\nValidade: " + validade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}

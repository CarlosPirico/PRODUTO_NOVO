package app;
import models.Produto;

public class Main {

	public static void main(String[] args) {
		try {
			
			// criando produto novo
			Produto produto1 = new Produto("Carne", 25.30,"23/09/2024");
			
			// exibindo resultado de produto.
			System.out.println(produto1.toString());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

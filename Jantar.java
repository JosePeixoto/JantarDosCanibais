
public class Jantar {

	public static void main(String[] args) {
		Caldeirao caldeirao = new Caldeirao(5);

		Cozinheiro cozinheiro = new Cozinheiro(caldeirao);

		Canibal canibal1 = new Canibal("#1", caldeirao, cozinheiro);
		Canibal canibal2 = new Canibal("#2", caldeirao, cozinheiro);
		Canibal canibal3 = new Canibal("#3", caldeirao, cozinheiro);

		cozinheiro.start();

		canibal1.start();
		canibal2.start();
		canibal3.start();

		long inicial = System.currentTimeMillis();

		while ((System.currentTimeMillis() - inicial) <= 120000) {
		}

		cozinheiro.stop();

		canibal1.stop();
		canibal2.stop();
		canibal3.stop();

		System.out.println("O cozinheiro encheu o caldeirao " + cozinheiro.getQtdCaldeiraoComplete());

		System.out.println("O canibal " + canibal1.getNome() + " comeu " + canibal1.getQtdComidas() + " vezes");
		System.out.println("O canibal " + canibal2.getNome() + " comeu " + canibal2.getQtdComidas() + " vezes");
		System.out.println("O canibal " + canibal3.getNome() + " comeu " + canibal3.getQtdComidas() + " vezes");

	}

}

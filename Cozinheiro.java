
public class Cozinheiro extends Thread {
	private Caldeirao caldeirao;
	private int qtdCaldeiraoComplete = 0;

	public Cozinheiro(Caldeirao caldeirao) {
		this.caldeirao = caldeirao;
	}

	@Override
	public void run() {
		while (true) {
			try {
				preparaJantar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private synchronized void preparaJantar() throws InterruptedException {

		setQtdCaldeiraoComplete(this.getQtdCaldeiraoComplete() + 1);

		while (this.caldeirao.getM() > 0)
			wait();

		System.out.println("Cozinheiro preparando!");

		sleep(5000);

		this.caldeirao.setM(5);
		notify();
	}

	public synchronized void Servir(Canibal canibal) throws InterruptedException {

		if (this.caldeirao.getM() > 0) {

			sleep(300);
			System.out.println("O canibal " + canibal.getNome() + " est� se servindo!");
			sleep(700);

			this.caldeirao.setM(this.caldeirao.getM() - 1);
			canibal.setQtdServidas(canibal.getQtdServidas() + 1);
			canibal.prato = true;

		} else {
			canibal.setQtdDormidas(canibal.getQtdDormidas() + 1);
			notify();
		}

	}

	public void Comer(Canibal canibal) throws InterruptedException {
		System.out.println("O canibal " + canibal.getNome() + " est� comendo!");
		canibal.setQtdComidas(canibal.getQtdComidas() + 1);

		if ((this.caldeirao.getM() - 1) == 0) {
			System.out.println("Canibal " + canibal.getNome() + " foi acordar cozinheiro e dorme!");
			canibal.qtdDormidas++;
		}

		canibal.prato = false;
		sleep(3000);
	}

	public int getQtdCaldeiraoComplete() {
		return qtdCaldeiraoComplete;
	}

	public void setQtdCaldeiraoComplete(int qtdCaldeiraoComplete) {
		this.qtdCaldeiraoComplete = qtdCaldeiraoComplete;
	}

}

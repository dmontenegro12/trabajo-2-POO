package banco.utpl.edu;

public class BancoLoja {

	public static void main(String[] args) {
		
		System.out.println("Bienvenido Banco de Loja");
		System.out.println("Informacion del cuenta ahorrista");
		clienteAhorros Cliente1 = new clienteAhorros("David Montenegro", "222-22-2222", 850, 0.35);
		cuentaDeAhorros cli1 = new cuentaDeAhorros(25);
		cuenta cl1= new cuenta(158);
		System.out.printf("%n%s %s%n", "El primer nombre es", Cliente1.obtenerNombre());
		System.out.printf("%s %s%n", "El apellido paterno es", Cliente1.obtenerNumeroCuenta());
		System.out.printf("%s %.2f%n", "Las ventas brutas son", Cliente1.obtenertransaccion());
		System.out.printf("%s %.2f%n", "La tarifa de comisi n es", Cliente1.obtenertarifaComision());
		System.out.println("Informacion de la cuenta de ahorros");
		System.out.printf("%n%s %s%n", "El primer nombre es", cli1.obtenerSobregiro());
		System.out.printf("%s %s%n", "El apellido paterno es", cl1.obtenerSaldo());
	}
	
	class cliente {
		private String nomCliente;
		private String numCuenta;

		public cliente(String nomCliente, String numCuenta) {
			this.nomCliente = nomCliente;
			this.numCuenta = numCuenta;
		}

		public void establecerNombre(String nomCliente) {
			this.nomCliente = nomCliente;
		}

		public void establecerNumeroCuenta(String numCuenta) {
			this.numCuenta = numCuenta;
		}

		public String obtenerNombre() {
			return nomCliente;
		}

		public String obtenerNumeroCuenta() {
			return numCuenta;
		}

		@Override
		public String toString() {
			return String.format("%s: %s %s%n%s: %s%n", "Nombres", obtenerNombre(), "Numero de Cuenta",
					obtenerNumeroCuenta());
		}
	}
	class clienteAhorros extends cliente{
		private double transaccion;
		private double tarifaComision;
		public clienteAhorros(String nomCliente, String numCuenta, double transaccion, double tarifaComision) {
			super(nomCliente, numCuenta);
		}
		public void establecertransaccion(double transaccion) {
			if(transaccion == 0)
				throw new IllegalArgumentException("La tarifa de transacción no puede ser cobrada");
				this.transaccion=transaccion;
		}
		public double obtenertransaccion() {
			return transaccion;
		}
		public void establecertarifaComision(double tarifaComision) {
			if(tarifaComision == 0)
				throw new IllegalArgumentException("La transacción no puede ser cobrada");
				this.tarifaComision=tarifaComision;
		}
		public double obtenertarifaComision() {
			return tarifaComision;
		}
		public double tarifaComision() {
			return tarifaComision;
		}
		public double descuentos() {
			return obtenertarifaComision()*obtenertransaccion();
		}
		@Override
		public String toString() {
			return String.format("%s%n%s%s: %.2f%n%s: %.2f%n%s: %.2f", "Cliente", super.toString(),
					"transacción", obtenertransaccion(), "tarifa de comisión", obtenertarifaComision(), "Ingresos: ",
					descuentos());
		}
	}
	class cuenta {
		protected double saldo;
	
		public cuenta(double saldoInicial) {
			saldo = saldoInicial;
		}
	
		public void depositar(double monto) {
			saldo += monto;
		}
	
		public void retirar(double monto) {
			saldo -= monto;
		}
	
		public double obtenerSaldo() {
			return saldo;
		}
	}
	
	class cuentaDeAhorros extends cuenta {
		  private double sobregiro;
		
		  public cuentaDeAhorros(double saldoInicial) {
		    super(saldoInicial);
		    sobregiro = saldoInicial;
		  }

		@Override
		  public void retirar(double monto) {
		    if (monto > saldo + sobregiro) {
		      System.out.println("No hay suficiente saldo en la cuenta de cheques para realizar esta operación.");
		    } else {
		      saldo -= monto;
		    }
		  }

		  public void establecerSobregiro(double sobregiro) {
		    this.sobregiro = sobregiro;
		  }
		  public double obtenerSobregiro() {
			  return sobregiro;
		  }
		}
	}


		



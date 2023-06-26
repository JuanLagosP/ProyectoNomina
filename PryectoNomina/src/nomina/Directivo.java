package nomina;

public class Directivo extends Persona{
    private final double salarioMensual;

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public Directivo() {
        super();
        this.salarioMensual = 0;
    }

    public Directivo(int id, String nombre, String apellido, String domicilio, int edad, double salarioMensual) {
        super(id, nombre, apellido, domicilio, edad);
        this.salarioMensual = salarioMensual;
    }
}

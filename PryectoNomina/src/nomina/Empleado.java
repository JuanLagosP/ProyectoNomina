package nomina;

public class Empleado extends Persona {

    private int diasTrabajados;
    private int horasExtra;
    private Puesto puesto;

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Empleado() {
        super();
        this.diasTrabajados = 0;
        this.horasExtra = 0;
        this.puesto = null;
    }

    public Empleado(int id, String nombre, String apellido, String domicilio, int edad,
                    int diasTrabajados, int horasExtra, Puesto puesto) {
        super(id, nombre, apellido, domicilio, edad);
        this.diasTrabajados = diasTrabajados;
        this.horasExtra = horasExtra;
        this.puesto = puesto;
    }
}

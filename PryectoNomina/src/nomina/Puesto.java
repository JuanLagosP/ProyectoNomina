package nomina;

public class Puesto {
    private int idPuesto;
    private String nombrePuesto;
    private double salarioPorDia;
    private double pagoHoraExtra;

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public double getSalarioPorDia() {
        return salarioPorDia;
    }

    public void setSalarioPorDia(double salarioPorDia) {
        this.salarioPorDia = salarioPorDia;
    }

    public double getPagoHoraExtra() {
        return pagoHoraExtra;
    }

    public void setPagoHoraExtra(double pagoHoraExtra) {
        this.pagoHoraExtra = pagoHoraExtra;
    }

    public Puesto() {
        this.idPuesto = 0;
        this.nombrePuesto = null;
        this.salarioPorDia = 0;
        this.pagoHoraExtra = 0;
    }

    public Puesto(int idPuesto, String nombrePuesto, double salarioPorDia, double pagoHoraExtra) {
        this.idPuesto = idPuesto;
        this.nombrePuesto = nombrePuesto;
        this.salarioPorDia = salarioPorDia;
        this.pagoHoraExtra = pagoHoraExtra;
    }
}

package nomina;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements Nomina, RegistroDeEmpleados, RegistroDePuestos {
    // Variables
    private List<Empleado> listaDeEmpleados;
    private List<Puesto> listaDePuestos;
    private static double[] nominaEmpleado;
    private static double[] nominaCompleta;
    private static Map<String, double[]> historialDeNomina;

    // Getters y Setters
    public List<Empleado> getListaDeEmpleados() {
        return listaDeEmpleados;
    }

    public void setListaDeEmpleados(List<Empleado> listaDeEmpleados) {
        this.listaDeEmpleados = listaDeEmpleados;
    }

    public List<Puesto> getListaDePuestos() {
        return listaDePuestos;
    }

    public void setListaDePuestos(List<Puesto> listaDePuestos) {
        this.listaDePuestos = listaDePuestos;
    }

    public static Map<String, double[]> getHistorialDeNomina() {
        return historialDeNomina;
    }

    public static void setHistorialDeNomina(Map<String, double[]> historialDeNomina) {
        Main.historialDeNomina = historialDeNomina;
    }

    public static double[] getNominaEmpleado() {
        return nominaEmpleado;
    }

    public static void setNominaEmpleado(double[] nominaEmpleado) {
        Main.nominaEmpleado = nominaEmpleado;
    }

    public static double[] getNominaCompleta() {
        return nominaCompleta;
    }

    public static void setNominaCompleta(double[] nominaCompleta) {
        Main.nominaCompleta = nominaCompleta;
    }

    // Metodos de las interfaces
    public void registroDeEmpleados() {
        listaDeEmpleados = new ArrayList<>();
    }

    public void registroDePuestos() {
        listaDePuestos = new ArrayList<>();
    }
    @Override
    public void nuevoEmpleado(Empleado empleado) {
        listaDeEmpleados.add(empleado);
        System.out.println("Se ha registrado un nuevo empleado: " + empleado.getNombre());
    }

    @Override
    public void bajaDeEmpleado(Empleado empleado) {
        listaDeEmpleados.remove(empleado);
        System.out.println("Se ha eliminado un empleado: " + empleado.getNombre());
    }

    @Override
    public void actualizarEmpleado(Empleado empleado, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
        empleado.setNombre(nuevoNombre);
        empleado.setApellido(nuevoApellido);
        empleado.setEdad(nuevaEdad);
        System.out.println("Se han actualizado los datos del empleado: " + empleado.getNombre());
    }

    @Override
    public void registroDiasTrabajados(Empleado empleado, int diasTrabajados) {
        if (diasTrabajados > 20) {
            System.out.println("Error: la cantidad de días laborados al mes no puede ser mayor a 20.");
        } else {
            empleado.setDiasTrabajados(diasTrabajados);
        }
    }

    @Override
    public void registroDiasTrabajados(int diasTrabajados) {
        if (diasTrabajados > 20) {
            System.out.println("Error: la cantidad de días laborados al mes no puede ser mayor a 20.");
        } else {
            for (Empleado empleado : listaDeEmpleados) {
                empleado.setDiasTrabajados(diasTrabajados);
            }
        }
    }

    @Override
    public void registroHorasExtra(Empleado empleado, int horasExtra) {
        if (horasExtra > 40) {
            System.out.println("Error: el maximo permitido de horas extra al mes es 40.");
        } else if (horasExtra < 1) {
            System.out.println("Error: por favor ingrese una cantidad valida de horas extra.");
        } else {
            empleado.setHorasExtra(horasExtra);
        }
    }

    @Override
    public void registroHorasExtra(int horasExtra) {
        if (horasExtra > 40) {
            System.out.println("Error: el maximo permitido de horas extra al mes es 40.");
        } else if (horasExtra < 1) {
            System.out.println("Error: por favor ingrese una cantidad valida de horas extra.");
        } else {
            for (Empleado empleado : listaDeEmpleados) {
                empleado.setHorasExtra(horasExtra);
            }
        }
    }

    @Override
    public void nuevoPuesto(Puesto puesto) {
        listaDePuestos.add(puesto);
        System.out.println("Se ha registrado un nuevo puesto: " + puesto.getNombrePuesto());
    }

    @Override
    public Empleado buscarEmpleadoPorID(int idEmpleado) {
        for (Empleado empleado : listaDeEmpleados) {
            if (empleado.getId() == idEmpleado) {
                return empleado;
            }
        }
        return null;
    }

    @Override
    public void calcularNominaEmpleado(int idEmpleado) {
        Empleado empleado = buscarEmpleadoPorID(idEmpleado);
        Puesto puestoEmpleado = empleado.getPuesto();

        double sueldoBaseEmpleado = empleado.getDiasTrabajados() * puestoEmpleado.getSalarioPorDia();
        double sueldoHorasExtra = empleado.getHorasExtra() * puestoEmpleado.getPagoHoraExtra();

        double[] salarioEmpleado = new double[2];

        salarioEmpleado[0] = sueldoBaseEmpleado;
        salarioEmpleado[1] = sueldoHorasExtra;

        setNominaEmpleado(salarioEmpleado);
    }

    @Override
    // Convertir el return type en void y agregar la sentencia de guardado.
    public void calcularNominaCompleta() {
        double[] salarioTotal = new double[2];

        for (Empleado empleado : listaDeEmpleados) {
            // Salario
            salarioTotal[0] += empleado.getDiasTrabajados() * empleado.getPuesto().getSalarioPorDia();
            // Horas extra
            salarioTotal[1] += empleado.getHorasExtra() * empleado.getPuesto().getPagoHoraExtra();
        }

        setNominaCompleta(salarioTotal);

        System.out.println("¿Desea guardar la nómina en el historial? 1 (Si) - 2 (No)");
        int respuesta = new Scanner(System.in).nextInt();

        StringBuilder mes = null;

        if (respuesta == 1) {
            System.out.println("¿A qué mes corresponde la información?");
            mes = new StringBuilder(new Scanner(System.in).nextLine());
        }

        assert mes != null;
        guardarNomina(mes.toString());

    }

    @Override
    public void guardarNomina(String mes) {
        for (Map.Entry<String, double[]> entradaNomina : historialDeNomina.entrySet()) {
            String mesHistorial = entradaNomina.getKey();
            if (mesHistorial.equalsIgnoreCase(mes)) {
                historialDeNomina.put(mesHistorial, getNominaCompleta());
            }
        }
    }

    @Override
    public void verHistorialDeNomina() {
        System.out.println("A continuacion se muestra la nómina del año: ");
        for (Map.Entry<String, double[]> entradaNomina : historialDeNomina.entrySet()) {
            String mes = entradaNomina.getKey();
            double[] nomina = entradaNomina.getValue();
            System.out.print("Mes: " + mes + "Salario: " + nomina[0] + "Horas extra: " + nomina[1]);
            System.out.println();
        }
    }

    public static void inicializarHistorialDeNomina() {
        historialDeNomina = new HashMap<>();

        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        double[] nominaInicial = new double[] {0.0, 0.0};

        for (String mes : meses) {
            historialDeNomina.put(mes, nominaInicial);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializar historial de nomina
        inicializarHistorialDeNomina();
    }
}

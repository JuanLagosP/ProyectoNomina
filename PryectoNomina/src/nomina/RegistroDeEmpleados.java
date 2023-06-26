package nomina;

public interface RegistroDeEmpleados {
    public void nuevoEmpleado(Empleado empleado);
    public void bajaDeEmpleado(Empleado empleado);
    public void actualizarEmpleado(Empleado empleado, String nuevoNombre, String nuevoApellido, int nuevaEdad);
    public void registroDiasTrabajados(Empleado empleado, int diasTrabajados);

    public void registroDiasTrabajados(int diasTrabajados);
    public void registroHorasExtra(Empleado empleado, int horasExtra);
    public void registroHorasExtra(int horasExtra);
    public Empleado buscarEmpleadoPorID(int idEmpleado);

}

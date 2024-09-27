package me.Rrhh.servicio;

import me.Rrhh.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado>listarEmpleados();
    public Empleado buscarPorId(Integer id);
    public Empleado guardarEmpleado(Empleado empleado);

    public void eliminarEmpleado(Empleado empleado);
}

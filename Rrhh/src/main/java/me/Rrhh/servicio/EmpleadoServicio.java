package me.Rrhh.servicio;

import me.Rrhh.modelo.Empleado;
import me.Rrhh.repositorio.IEmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements  IEmpleadoServicio{

    @Autowired
    private IEmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return this.empleadoRepositorio.findAll() ;
    }

    @Override
    public Empleado buscarPorId(Integer id) {
        return this.empleadoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return this.empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
        this.empleadoRepositorio.delete(empleado);
    }
}

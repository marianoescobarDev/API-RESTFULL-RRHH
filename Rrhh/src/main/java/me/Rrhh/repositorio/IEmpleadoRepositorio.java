package me.Rrhh.repositorio;

import me.Rrhh.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoRepositorio extends JpaRepository<Empleado,Integer> {
}

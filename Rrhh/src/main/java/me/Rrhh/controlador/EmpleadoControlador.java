package me.Rrhh.controlador;


import me.Rrhh.excepcion.RecursoNoEncontradoException;
import me.Rrhh.modelo.Empleado;
import me.Rrhh.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rrhh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {

    private static final Logger logger= LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private IEmpleadoServicio empleadoServicio;

    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        var empleados= this.empleadoServicio.listarEmpleados();
        return empleados;
    }

    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        return empleadoServicio.guardarEmpleado(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable Integer id){
        Empleado empleado = this.empleadoServicio.buscarPorId(id);
        if(empleado==null){
            throw new RecursoNoEncontradoException("No se encontro el id" + id);
        }
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleadoR){
        Empleado empleado = this.empleadoServicio.buscarPorId(id);
        if(empleado==null){
            throw new RecursoNoEncontradoException("No se encontro el id" + id);
        }
        empleado.setDepartamento(empleadoR.getDepartamento());
        empleado.setNombre(empleadoR.getNombre());
        empleado.setSueldo(empleadoR.getSueldo());
        empleadoServicio.guardarEmpleado(empleado);

        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleado(@PathVariable Integer id){
        Empleado empleado = this.empleadoServicio.buscarPorId(id);
        if(empleado==null)throw new RecursoNoEncontradoException("El id no existe");
        empleadoServicio.eliminarEmpleado(empleado);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


}

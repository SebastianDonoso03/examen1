package Donosos.donosos.Donosocliente;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DonosoClienteRepository extends CrudRepository<DonosoCliente, Long> {

    List<DonosoCliente> findAll();

    // Método para encontrar un cliente por nombre
    DonosoCliente findByNombre(String nombre);

    // Método para eliminar un cliente por nombre
    void deleteByNombre(String nombre);

}

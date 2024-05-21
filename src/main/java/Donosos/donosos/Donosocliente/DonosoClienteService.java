package Donosos.donosos.Donosocliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DonosoClienteService 
{
    @Autowired
    private DonosoClienteRepository donosoClienteRepository;

    //crear
    public DonosoCliente save (DonosoCliente entity)
    {
        return donosoClienteRepository.save(entity);
    }
     // By Id
    public DonosoCliente findById(Long id)
    {
        return donosoClienteRepository.findById(id).orElse(null);
    }

    // Delete by id
    // public void deleteById(Long id)
    // {
    //     donosoClienteRepository.deleteById(id);
    // }
    //All
    public List<DonosoCliente> findAll()
    {
        return donosoClienteRepository.findAll();
    }
    

    public ResponseEntity<DonosoCliente> updateById(Long id, DonosoCliente clienteActualizada){
        try{
            DonosoCliente clienteExistente = findById(id);

            if (clienteExistente == null){
                return ResponseEntity.notFound().build();
            }
            
            //actualizar campos
            if(clienteActualizada.getNombre()!= null){
                clienteExistente.setNombre(clienteActualizada.getNombre());
            }

            //guardar datos
            DonosoCliente clienteguardada = save(clienteExistente);
            //Return
            return ResponseEntity.ok(clienteguardada);

            
        
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    public ResponseEntity<Void> deleteByNombre(String nombre) {
        DonosoCliente cliente = donosoClienteRepository.findByNombre(nombre);
        if (cliente != null) {
            donosoClienteRepository.deleteByNombre(nombre);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

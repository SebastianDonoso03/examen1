package Donosos.donosos.DonosoProducto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DonosoProductoService 
{
    @Autowired
    private DonosoProductoRepository donosoProductoRepository;
    
    //Create

    public DonosoProducto save(DonosoProducto entity)
    {
        return donosoProductoRepository.save(entity);
    }

    // By Id
    public DonosoProducto findById(Long id)
    {
        return donosoProductoRepository.findById(id).orElse(null);
    }

    // Delete by id
    public void deleteById(Long id)
    {
        donosoProductoRepository.deleteById(id);
    }
    //All
    public List<DonosoProducto> findAll()
    {
        return donosoProductoRepository.findAll();
    }

    public ResponseEntity<DonosoProducto> updateById(Long id, DonosoProducto productoactualizado){
        try{
            DonosoProducto productoExistente = findById(id);

            if (productoExistente == null){
                return ResponseEntity.notFound().build();
            }
            
            //actualizar campos
            if(productoactualizado.getNombre()!= null){
                productoExistente.setNombre(productoactualizado.getNombre());
            }
            
            if(productoactualizado.getEstado()!= null)
            {
                productoExistente.setEstado(productoactualizado.getEstado());
            }

            //guardar datos
            DonosoProducto productoGuardada = save(productoExistente);
            //Return
            return ResponseEntity.ok(productoGuardada);

            
        
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}

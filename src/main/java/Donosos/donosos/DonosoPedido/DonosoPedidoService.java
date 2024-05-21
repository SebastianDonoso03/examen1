package Donosos.donosos.DonosoPedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DonosoPedidoService 
{
     @Autowired
    private DonosoPedidoRepository donosoPedidoRepository;
    
    //Create

    public DonosoPedido save(DonosoPedido entity)
    {
        return donosoPedidoRepository.save(entity);
    }

    // By Id
    public DonosoPedido findById(Long id)
    {
        return donosoPedidoRepository.findById(id).orElse(null);
    }

    // Delete by id
    public void deleteById(Long id)
    {
        donosoPedidoRepository.deleteById(id);
    }
    //All
    public List<DonosoPedido> findAll()
    {
        return donosoPedidoRepository.findAll();
    }

    public ResponseEntity<DonosoPedido> updateById(Long id, DonosoPedido DonosoPedidoActualizada){
        try{
            DonosoPedido DonosoPedidoExistente = findById(id);

            if (DonosoPedidoExistente == null){
                return ResponseEntity.notFound().build();
            }
            
            //actualizar campos
            if(DonosoPedidoActualizada.getTotal()!= null){
                DonosoPedidoExistente.setTotal(DonosoPedidoActualizada.getTotal());
            }
            //guardar datos
            DonosoPedido DonosoPedidoGuardada = save(DonosoPedidoExistente);
            //Return
            return ResponseEntity.ok(DonosoPedidoGuardada);

            
        
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    } 
}

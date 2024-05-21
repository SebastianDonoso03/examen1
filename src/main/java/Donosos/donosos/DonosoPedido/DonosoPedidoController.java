package Donosos.donosos.DonosoPedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/")
public class DonosoPedidoController 
{
  @Autowired
    private DonosoPedidoService donosoPedidoService;
    
    //Create
    @PostMapping(value = "pedidos")
    public DonosoPedido save(@RequestBody DonosoPedido entity)
    {
        return donosoPedidoService.save(entity);
    }
    //Select by Id
    @GetMapping(value = "pedidos{id}")
    public DonosoPedido findById(@PathVariable Long id)
    {
        return donosoPedidoService.findById(id);
    }

    //Update
    @PutMapping(value = "pedidos")
    public DonosoPedido update(@RequestBody DonosoPedido entity)
    {
        return donosoPedidoService.save(entity);
    }

    //Delete
    @DeleteMapping(value = "pedidos")
    public void delete(@PathVariable Long id)
    {
        donosoPedidoService.deleteById(id);
    }

    //ALl
    @GetMapping(value = "pedidos")
    public List<DonosoPedido> findAll()
    {
        return donosoPedidoService.findAll();
    }

    //Update by id
    
    @PutMapping(value = "pedidos/{id}")
    public ResponseEntity<DonosoPedido> updateById(@PathVariable Long id, @RequestBody DonosoPedido entity)
    {
        return donosoPedidoService.updateById(id, entity);
    }
}

package Donosos.donosos.Donosocliente;

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
public class DonosoClienteController 
{
     @Autowired
    private DonosoClienteService donosoClienteService;
    
    //Create
    @PostMapping(value = "cliente")
    public DonosoCliente save(@RequestBody DonosoCliente entity)
    {
        return donosoClienteService.save(entity);
    }
    //Select by Id
    @GetMapping(value = "cliente{id}")
    public DonosoCliente findById(@PathVariable Long id)
    {
        return donosoClienteService.findById(id);
    }

    //Update
    @PutMapping(value = "cliente")
    public DonosoCliente update(@RequestBody DonosoCliente entity)
    {
        return donosoClienteService.save(entity);
    }

    //Delete
    // @DeleteMapping(value = "cliente")
    // public void delete(@PathVariable Long id)
    // {
    //     donosoClienteService.deleteById(id);
    // }

    //ALl
    @GetMapping(value = "cliente")
    public List<DonosoCliente> findAll()
    {
        return donosoClienteService.findAll();
    }

    //Update by id
    
    @PutMapping(value = "cliente/{id}")
    public ResponseEntity<DonosoCliente> updateById(@PathVariable Long id, @RequestBody DonosoCliente entity)
    {
        return donosoClienteService.updateById(id, entity);
    }

    @DeleteMapping(value = "cliente/nombre/{nombre}")
    public ResponseEntity<Void> deleteByNombre(@PathVariable String nombre) {
        return donosoClienteService.deleteByNombre(nombre);
    }

}

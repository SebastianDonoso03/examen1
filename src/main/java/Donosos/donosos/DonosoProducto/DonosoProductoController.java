package Donosos.donosos.DonosoProducto;

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
public class DonosoProductoController 
{
      @Autowired
    private DonosoProductoService donosoProductoService;
    
    //Create
    @PostMapping(value = "producto")
    public DonosoProducto save(@RequestBody DonosoProducto entity)
    {
        return donosoProductoService.save(entity);
    }
    //Select by Id
    @GetMapping(value = "producto{id}")
    public DonosoProducto findById(@PathVariable Long id)
    {
        return donosoProductoService.findById(id);
    }

    //Update
    @PutMapping(value = "producto")
    public DonosoProducto update(@RequestBody DonosoProducto entity)
    {
        return donosoProductoService.save(entity);
    }

    //Delete
    @DeleteMapping(value = "producto")
    public void delete(@PathVariable Long id)
    {
        donosoProductoService.deleteById(id);
    }

    //ALl
    @GetMapping(value = "producto")
    public List<DonosoProducto> findAll()
    {
        return donosoProductoService.findAll();
    }

    //Update by id
    
    @PutMapping(value = "producto/{id}")
    public ResponseEntity<DonosoProducto> updateById(@PathVariable Long id, @RequestBody DonosoProducto entity)
    {
        return donosoProductoService.updateById(id, entity);
    }
}

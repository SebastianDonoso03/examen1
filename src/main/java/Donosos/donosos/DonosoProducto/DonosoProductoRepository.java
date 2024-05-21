package Donosos.donosos.DonosoProducto;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DonosoProductoRepository extends CrudRepository<DonosoProducto, Long>
{
    List<DonosoProducto> findAll();
}

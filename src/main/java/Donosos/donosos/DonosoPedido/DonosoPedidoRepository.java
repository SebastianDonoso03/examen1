package Donosos.donosos.DonosoPedido;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface DonosoPedidoRepository extends CrudRepository<DonosoPedido, Long>{
    List<DonosoPedido> findAll();
}

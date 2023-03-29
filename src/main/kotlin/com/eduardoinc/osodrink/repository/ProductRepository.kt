import com.eduardoinc.osodrink.dao.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, String>

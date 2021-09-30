package cl.grupo2.proyectofinal.modelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativoRepositorio extends CrudRepository<Administrativo, Integer> {

}

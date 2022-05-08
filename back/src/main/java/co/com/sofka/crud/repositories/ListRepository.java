package co.com.sofka.crud.repositories;

import co.com.sofka.crud.entities.ListEntity;
import org.springframework.data.repository.CrudRepository;

public interface ListRepository extends CrudRepository<ListEntity, Integer> {
}

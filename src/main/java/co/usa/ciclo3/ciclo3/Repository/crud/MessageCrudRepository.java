package co.usa.ciclo3.ciclo3.Repository.crud;

import co.usa.ciclo3.ciclo3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}

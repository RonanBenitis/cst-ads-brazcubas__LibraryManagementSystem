package  com.biblioteca.model.dao;

import java.util.List;

import com.biblioteca.model.entity.AbstractEntity;

public interface IDAO<T extends AbstractEntity> {

  void cadastrar(T entidade);

  void atualizar(T entidade);

  void excluir(int id);

  T buscar(int id);

  List<T> listar();

}

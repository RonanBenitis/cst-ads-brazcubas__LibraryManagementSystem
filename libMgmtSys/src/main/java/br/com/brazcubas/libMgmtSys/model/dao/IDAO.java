package br.com.brazcubas.libMgmtSys.model.dao;

import java.util.List;
import br.com.brazcubas.libMgmtSys.model.entity.AbstractEntity;

public interface IDAO<T extends AbstractEntity> {
    void cadastrar(T entidade);
    void atualizar(T entidade);
    void excluir(int id);
    T buscar(int id);
    List<T> listar();
}

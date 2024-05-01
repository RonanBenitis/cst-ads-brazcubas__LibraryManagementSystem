package br.com.brazcubas.libMgmtSys.model.dao;

import java.util.List;
import br.com.brazcubas.libMgmtSys.model.entity.AbstractEntity;

public interface IDAO<T extends AbstractEntity> {
    //>>>> REGISTER CONTROL 
    void cadastrar(T entidade);
    void atualizar(T entidade);
    void excluir(int id);
    T buscar(int id);
    List<T> listar();
    //>>>> EMPRESTIMO CONTROL
    void emprestar(T entidade);
    void devolver(int id);
    T buscarEmpr(int id);
    List<T> listarEmprest();
}

package com.todo.list.api_todo_list.functions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    @Modifying
    @Query("update Tarefa t set t.status=true where t.id=:id ")
    public void marcarTarefaComoConcluida(@Param("id") Long idTarefa);
}

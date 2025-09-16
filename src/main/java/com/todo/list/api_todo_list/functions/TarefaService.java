package com.todo.list.api_todo_list.functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    TarefaRepository tarefaRepository;


    public TarefaModel salvar(TarefaModel tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<TarefaModel> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public void removerTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}

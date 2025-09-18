package com.todo.list.api_todo_list.functions;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    @Autowired
    TarefaRepository tarefaRepository;


    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    public void removerTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }

    @Transactional
    public void MarcarConcluida(Long id) {
        tarefaRepository.marcarTarefaComoConcluida(id);

    }

    @Transactional
    public void editarTarefa(Long id, Tarefa t) {
        tarefaRepository.editarTarefa(id, t.getNome(), t.getDescricao(), t.getTipodePrio());
    }
}

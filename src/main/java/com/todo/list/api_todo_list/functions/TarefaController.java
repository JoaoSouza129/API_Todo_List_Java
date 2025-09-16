package com.todo.list.api_todo_list.functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/API")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;

    @PostMapping("/create")
    public ResponseEntity<TarefaModel> create(@RequestBody TarefaModel tarefaModel) {
        return ResponseEntity.ok(tarefaService.salvar(tarefaModel));
    }

    @GetMapping("/list")
    public ResponseEntity<List<TarefaModel>> listarTarefa() {
        return ResponseEntity.ok(tarefaService.listarTarefas());
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removerTarefa(@PathVariable("id") Long id) {
        tarefaService.removerTarefa(id);
        return ResponseEntity.ok("Tarefa removido com sucesso");
    }
}

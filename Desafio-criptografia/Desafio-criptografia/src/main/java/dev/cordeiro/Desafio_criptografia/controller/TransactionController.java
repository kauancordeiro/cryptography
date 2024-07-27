package dev.cordeiro.Desafio_criptografia.controller;

import dev.cordeiro.Desafio_criptografia.controller.dtos.CreateTransactionRequest;
import dev.cordeiro.Desafio_criptografia.controller.dtos.TransactionResponse;
import dev.cordeiro.Desafio_criptografia.controller.dtos.UpdateTransactionRequest;
import dev.cordeiro.Desafio_criptografia.service.TransactionService;
import org.hibernate.sql.Update;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("transactions")
public class TransactionController {

    private final TransactionService service;


    public TransactionController(TransactionService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Void> create (@RequestBody CreateTransactionRequest request){
        service.create(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<TransactionResponse>> listAll(@RequestParam(name = "page", defaultValue = "0")Integer page,
                                                             @RequestParam(name = "pageSize",defaultValue = "10")Integer pageSize){
        var body = service.listAll(page, pageSize);
        return ResponseEntity.ok(body);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> findById(@PathVariable Long id){
        var body = service.findById(id);
        return ResponseEntity.ok(body);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody UpdateTransactionRequest request){
        service.update(id,request);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

package com.bichinhos.CapSync_Back_End.controller;

import com.bichinhos.CapSync_Back_End.dto.request.StackRequest;
import com.bichinhos.CapSync_Back_End.dto.response.StackResponse;
import com.bichinhos.CapSync_Back_End.service.impl.StackServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/stacks")
@RequiredArgsConstructor
public class StackController {

    private final StackServiceImpl stackService;

    @GetMapping
    public ResponseEntity<Page<StackResponse>> getAllStacks(Pageable pageable){

        Page<StackResponse> users = stackService.getAllStacks(pageable);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StackResponse> getStackById(@PathVariable(value = "id") Long id){

        StackResponse user = stackService.getStackById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Void> saveStack(@RequestBody @Valid StackRequest stackRequest){

        StackResponse stackResponse = stackService.createStack(stackRequest);

        return ResponseEntity.created(URI.create("/users/" + stackResponse.id())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StackResponse> updateStack(@PathVariable(name = "id") Long id, @RequestBody StackRequest stackRequest) {

        StackResponse stackResponse = stackService.updateStackById(id, stackRequest);

        return ResponseEntity.ok(stackResponse);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteStackById(@PathVariable(value = "id") Long id){

        stackService.deleteStackById(id);
        return ResponseEntity.noContent().build();
    }

}

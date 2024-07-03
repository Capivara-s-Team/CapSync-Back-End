package com.bichinhos.CapSync_Back_End.controller;

import com.bichinhos.CapSync_Back_End.dto.request.SquadRequest;
import com.bichinhos.CapSync_Back_End.dto.response.SquadResponse;
import com.bichinhos.CapSync_Back_End.service.impl.SquadServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/squads")
public class SquadController {

    private final SquadServiceImpl squadService;

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<SquadResponse> getSquadById(@PathVariable(name = "id") Long id){
        SquadResponse squadResponse = squadService.getSquadById(id);

        return ResponseEntity.ok(squadResponse);
    }

    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @GetMapping
    public ResponseEntity<Page<SquadResponse>> getAllSquads(Pageable pageable){
        Page<SquadResponse> squads = squadService.getAll(pageable);

        return ResponseEntity.ok(squads);
    }
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @PostMapping
    public ResponseEntity<Void> saveSquad(@RequestBody @Valid SquadRequest squadRequest){
        SquadResponse squadResponse = squadService.createSquad(squadRequest);
        return ResponseEntity.created(URI.create("/squads/" + squadResponse.id())).build();
    }
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<SquadResponse> updateSquad(@PathVariable(name = "id") Long id,
                                                     @RequestBody @Valid SquadRequest squadRequest){

        SquadResponse squadResponse = squadService.updateSquadById(id, squadRequest);
        return ResponseEntity.ok(squadResponse);
    }
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSquadById(@PathVariable(name = "id") Long id){
        squadService.deleteSquadById(id);
        return ResponseEntity.noContent().build();
    }

}

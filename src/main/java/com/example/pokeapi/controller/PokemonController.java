package com.example.pokeapi.controller;

import com.example.pokeapi.entity.Pokemon;
import com.example.pokeapi.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService){
        this.pokemonService = pokemonService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    /*public ResponseEntity<ArrayList<Pokemon>> getPokemones(){
        ArrayList<Pokemon> pokemones = this.pokemonService.getPokemones();

        return new ResponseEntity<>(pokemones, HttpStatus.OK);
    }*/
    public ResponseEntity<List<Pokemon>> getPokemones(){
        List<Pokemon> pokemones = this.pokemonService.getPokemones();
        return new ResponseEntity<>(pokemones, HttpStatus.OK);
    }
}

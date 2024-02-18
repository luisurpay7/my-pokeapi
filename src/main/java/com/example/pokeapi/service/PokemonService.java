package com.example.pokeapi.service;

import com.example.pokeapi.entity.Pokemon;
import com.example.pokeapi.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public ArrayList<Pokemon> getPokemones(){
        ArrayList<Pokemon> pokemones = new ArrayList<Pokemon>(this.pokemonRepository.findAll());
        for(int i=0; i<pokemones.size(); i++){
            pokemones.get(i).setImage("http://localhost:8080/img/"+pokemones.get(i).getImage());
        }
        return pokemones;
    }
}

package com.example.pokeapi.service;

import com.example.pokeapi.entity.Pokemon;
import com.example.pokeapi.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    @Value("${base.url}")
    private String baseUrl;

    @Autowired
    private PokemonRepository pokemonRepository;

    /*public ArrayList<Pokemon> getPokemones(){
        ArrayList<Pokemon> pokemones = new ArrayList<>(this.pokemonRepository.findAll());
        for(int i=0; i<pokemones.size(); i++){
            pokemones.get(i).setImage("http://localhost:8080/img/"+pokemones.get(i).getImage());
        }
        return pokemones;
    }*/

    public List<Pokemon> getPokemones(){
        List<Pokemon> pokemones = this.pokemonRepository.findAll();
        for (Pokemon pokemon : pokemones) {
            pokemon.setImage(baseUrl + "/img/" + pokemon.getImage());
        }
        return pokemones;
    }
}

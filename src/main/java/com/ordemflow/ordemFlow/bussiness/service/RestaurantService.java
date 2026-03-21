package com.ordemflow.ordemFlow.bussiness.service;

import com.ordemflow.ordemFlow.infrastructure.Entity.Restaurant;
import com.ordemflow.ordemFlow.infrastructure.exception.ResourceNotFoundException;
import com.ordemflow.ordemFlow.infrastructure.exception.conflictionException;
import com.ordemflow.ordemFlow.infrastructure.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;


    public Restaurant saveRestaurant(Restaurant restaurant) {

        existsByEmail(restaurant.getEmail());

        return restaurantRepository.save(restaurant);


    }


    public void existsByEmail(String email) {
        if (verificarEmailExistente(email)) {
            throw new conflictionException("O email " + email + "já está em uso.");
        }
    }


    public boolean verificarEmailExistente(String email) {
        return restaurantRepository.existsByEmail(email);
    }

    public List<Restaurant> findList() {
        List<Restaurant> restaurants = restaurantRepository.findAll();

        if (restaurants.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum restaurante encontrado no sistema.");
        }

        return restaurants;
    }

    public Restaurant byFindId(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurante com ID " + id + " não encontrado."));
    }

    public Restaurant putFindId(Long id, Restaurant restaurant) {
        Restaurant existingRestaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurante com ID " + id + " não encontrado"));

        if (!existingRestaurant.getEmail().equals(restaurant.getEmail())) {
            existsByEmail(restaurant.getEmail());
        }

        existingRestaurant.setName(restaurant.getName());
        existingRestaurant.setEmail(restaurant.getEmail());
        existingRestaurant.setDescription(restaurant.getDescription());
        existingRestaurant.setPhone(restaurant.getPhone());
        existingRestaurant.setImagemUrl(restaurant.getImagemUrl());

        return restaurantRepository.save(existingRestaurant);
    }

    public void deleteRestaurat(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurante com ID " + id + " não encontrado."));

        restaurantRepository.deleteById(id);
    }
}

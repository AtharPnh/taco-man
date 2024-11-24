package com.springinaction.tacoman.service;

import com.springinaction.tacoman.repository.TacoOrderRepo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class OrderAdminService {
    private TacoOrderRepo orderRepo;

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAllOrders(){
        orderRepo.deleteAll();
    }
}

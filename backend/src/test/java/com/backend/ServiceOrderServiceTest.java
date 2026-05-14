package com.backend;

import com.backend.model.entity.OrderService;
import com.backend.repository.OrderServiceRepository;
import com.backend.service.ServiceOrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class ServiceOrderServiceTest {

    @Mock
    private OrderServiceRepository orderServiceRepository;

    @InjectMocks
    private ServiceOrderService serviceOrderService;

    @Test
    void findById(){

        OrderService orderService = new OrderService();
        orderService.setServiceNumber(1);
        orderService.setDiagnosis("Test Order Service");

        Mockito.when(orderServiceRepository.findById(1)).thenReturn(Optional.of(orderService));

        OrderService result = serviceOrderService.getOrderServiceById(1);

        assertNotNull(result);
        assertEquals(1, result.getServiceNumber());
        assertEquals("Test Order Service", result.getDiagnosis());

    }
}

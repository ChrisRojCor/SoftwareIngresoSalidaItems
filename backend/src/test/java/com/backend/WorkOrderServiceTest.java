package com.backend;

import com.backend.model.dto.WorkOrderResponseDTO;
import com.backend.model.entity.WorkOrder;
import com.backend.repository.WorkOrderRepository;
import com.backend.service.WorkOrderService;
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
public class WorkOrderServiceTest {

    @Mock
    private WorkOrderRepository workOrderRepository;

    @InjectMocks
    private WorkOrderService workOrderService;

    @Test
    void findById(){

        WorkOrder workOrder = new WorkOrder();
        workOrder.setServiceNumber(1);
        workOrder.setDiagnosis("Test Work Order");

        Mockito.when(workOrderRepository.findById(1)).thenReturn(Optional.of(workOrder));

        WorkOrderResponseDTO result = workOrderService.getWorkOrderById(1);

        assertNotNull(result);
        assertEquals(1, result.getServiceNumber());
        assertEquals("Test Work Order", result.getDiagnosis());

    }
}

package com.sisiback.api;
import com.sisiback.dao.SaleDAO;
import com.sisiback.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sale")
@CrossOrigin(origins = "*")
public class SaleAPI {

    @Autowired
    private SaleDAO saleDAO;

    @PostMapping("/create")
    public ResponseEntity<String> createSales(@RequestBody List<Sale> sales) throws JSONException {
        // Lógica para manejar la lista de ventas
        for (Sale sale : sales) {
            saleDAO.save(sale);
        }

        JSONObject response = new JSONObject();
        response.put("message", "Ventas creadas con éxito.");

        return ResponseEntity.ok(response.toString());
    }

    @GetMapping("/read")
    public List<Sale> read(){return saleDAO.findAll();}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id){saleDAO.deleteById(id);}

    @PutMapping("/update")
    public void update(@RequestBody Sale sale){saleDAO.save(sale);}
}

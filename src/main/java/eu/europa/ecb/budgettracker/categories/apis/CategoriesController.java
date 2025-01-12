package eu.europa.ecb.budgettracker.categories.apis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {

    @GetMapping
    public ResponseEntity<List<String>> categories() {
        return ResponseEntity.ok(List.of(
                "consultancy services",
                "licenses",
                "operations",
                "business travels"
        ));
    }
}

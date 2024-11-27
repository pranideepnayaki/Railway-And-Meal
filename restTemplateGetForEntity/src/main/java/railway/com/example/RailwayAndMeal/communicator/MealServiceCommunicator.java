package railway.com.example.RailwayAndMeal.communicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import railway.com.example.RailwayAndMeal.Entity.Meal;

@Component
public class MealServiceCommunicator {

    private final RestTemplate restTemplate;

    @Autowired
    public MealServiceCommunicator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    // Method to get meal details by PNR
    public Meal getMealByPnr(long pnr) {
        String mealServiceUrl = "http://localhost:8081/pantry/meal/" + pnr;  // Replace with the actual Meal Application URL
        ResponseEntity<Meal> response = restTemplate.getForEntity(mealServiceUrl, Meal.class);
        return response.getBody();
    }
}

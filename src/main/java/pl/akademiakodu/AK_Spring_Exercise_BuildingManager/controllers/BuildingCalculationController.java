package pl.akademiakodu.AK_Spring_Exercise_BuildingManager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models.Building;
import pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models.BuildingManager;
import pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models.UserInput;

@Controller
public class BuildingCalculationController {

    private BuildingManager buildingManager = new BuildingManager();

    @GetMapping("/build") public String buildingGet(Model model){
        model.addAttribute("userInput", new UserInput());
        return "build";
    }

    @PostMapping("/build") public String buildingPost(@ModelAttribute("userInput") UserInput userInput, Model model){
        Building potentialBuilding = new Building();
        potentialBuilding = buildingManager.totalCostCalculator(userInput.getWidth(), userInput.getLength(),
                userInput.getFloors(), userInput.getUndergroundFloors());
        return "build";
    }

}

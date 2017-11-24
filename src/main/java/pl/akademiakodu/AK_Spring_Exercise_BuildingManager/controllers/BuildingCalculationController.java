package pl.akademiakodu.AK_Spring_Exercise_BuildingManager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models.BuildingManager;
import pl.akademiakodu.AK_Spring_Exercise_BuildingManager.models.UserInput;

@Controller
public class BuildingCalculationController {

    private BuildingManager buildingManager = new BuildingManager();

    @GetMapping("/build") public String buildingGet(Model model){
        model.addAttribute("userInput", new UserInput());
        return "build";
    }

}

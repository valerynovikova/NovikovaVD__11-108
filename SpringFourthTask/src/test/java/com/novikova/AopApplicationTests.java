package com.novikova;

import com.novikova.controller.MainController;
import com.novikova.service.ValidationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopApplicationTests {
    @Autowired
    MainController mainController;
    @Test
    void testCheckingStuffWithAfter(){
        mainController.checkStuff();
    }
    @Autowired
    ValidationService validationService;
    @Test
    void testValidAroundAspect(){
        validationService.validateNumber(10);
    }
}

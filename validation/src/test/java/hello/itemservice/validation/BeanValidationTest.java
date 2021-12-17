package hello.itemservice.validation;

import hello.itemservice.domain.item.Item;
import hello.itemservice.web.validation.ValidationItemControllerV1;
import org.junit.jupiter.api.Test;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class BeanValidationTest {

    @Test
    void beanValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Item item = new Item("   ", 0, 10000);
        Set<ConstraintViolation<Item>> validations = validator.validate(item);

        for (ConstraintViolation<Item> violation : validations) {
            System.out.println("violation = " + violation);
            System.out.println("violation.getMessage() = " + violation.getMessage());
        }

    }



}








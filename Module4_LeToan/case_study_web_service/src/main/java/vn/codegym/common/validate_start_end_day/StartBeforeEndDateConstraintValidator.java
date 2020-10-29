package vn.codegym.common.validate_start_end_day;

import vn.codegym.model.Contract;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class StartBeforeEndDateConstraintValidator implements ConstraintValidator<ValidateStartBeforeEndDate, Contract> {
//    private ValidateStartBeforeEndDate annotation;
    @Override
    public void initialize(ValidateStartBeforeEndDate constraintAnnotation) {
//        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Contract contract, ConstraintValidatorContext context) {
        LocalDate startDate = LocalDate.parse(changeFormatDate(contract.getContractStartDate()));
        LocalDate endDate = LocalDate.parse(changeFormatDate(contract.getContractEndDate()));
        if (startDate.isAfter(endDate)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("EndDate must be greater than StartDate").addConstraintViolation();
            return false;
        }
        return true;
    }

    private String changeFormatDate(String input) {
        String[] array = input.split("/");
        return array[2]+'-'+array[1]+'-'+array[0];
    }
}

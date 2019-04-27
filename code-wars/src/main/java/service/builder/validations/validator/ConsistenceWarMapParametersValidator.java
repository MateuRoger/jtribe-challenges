package service.builder.validations.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import service.builder.validations.ConsistenceWarMapParameters;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ConsistenceWarMapParametersValidator implements
    ConstraintValidator<ConsistenceWarMapParameters, Object[]> {

  @Override
  public boolean isValid(Object[] value, ConstraintValidatorContext context) {
    if (!(value[0] instanceof Integer)
        || !(value[1] instanceof Integer)
        || !(value[2] instanceof Integer)) {
      throw new IllegalArgumentException(
          "Illegal method signature, expected two parameters of type LocalDate.");
    }

    return (int) value[1] > ((int) value[0] * (int) value[0]);
  }
}

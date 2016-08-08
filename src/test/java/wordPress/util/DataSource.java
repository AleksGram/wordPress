package wordPress.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface DataSource {

        public String xls() default "";
        public String json() default "";

}

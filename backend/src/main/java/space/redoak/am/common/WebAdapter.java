package space.redoak.am.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that an annotated class is a "WebAdapter".
 * Documents the bean as a specialized "@Controller".
 *
 * source: https://github.com/thombergs/buckpal
 * 
 * @author glenn
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface WebAdapter {

  @AliasFor(annotation = Component.class)
  String value() default "";

}

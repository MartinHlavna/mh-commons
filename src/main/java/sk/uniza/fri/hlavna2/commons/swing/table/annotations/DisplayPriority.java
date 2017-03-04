package sk.uniza.fri.hlavna2.commons.swing.table.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import sk.uniza.fri.hlavna2.commons.swing.table.BeanTableModel;

/**
 * Annotation that allows ordering of collumns (getters) in BeanTableModel
 *
 * @author Martin Hlavňa {@literal <mato.hlavna@gmail.com>}
 * @see BeanTableModel
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DisplayPriority {

    /**
     * Priority of order. Getter with least priority is leftmost
     *
     * @return Int number
     */
    public int priority();
}

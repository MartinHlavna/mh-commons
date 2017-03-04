package sk.uniza.fri.hlavna2.commons.swing.table.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import sk.uniza.fri.hlavna2.commons.swing.table.BeanTableModel;

/**
 * Overrides default collumn name in BeanTableModel.
 *
 * @author Martin Hlavňa {@literal <mato.hlavna@gmail.com>}
 * @see BeanTableModel
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TableCollumnName {

    /**
     * Name of the collumn
     *
     * @return Name that should display in Table
     */
    public String name();
}

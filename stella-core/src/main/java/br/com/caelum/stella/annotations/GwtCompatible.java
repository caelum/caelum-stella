package br.com.caelum.stella.annotations;

/**
 * Created at 26/08/13 11:05
 *
 * @author Danilo Reinert
 */

import java.lang.annotation.*;

/**
 * The presence of this annotation on a type indicates that the type may be
 * used with the
 * <a href="http://code.google.com/webtoolkit/">Google Web Toolkit</a> (GWT).
 * When applied to a method, the return type of the method is GWT compatible.
 * It's useful to indicate that an instance created by factory methods has a GWT
 * serializable type.  In the following example,
 *
 * <pre style="code">
 * {@literal @}GwtCompatible
 * class Lists {
 *   ...
 *   {@literal @}GwtCompatible(serializable = true)
 *   static &lt;E> List&lt;E> newArrayList(E... elements) {
 *     ...
 *   }
 * }
 * </pre>
 * <p>The return value of {@code Lists.newArrayList(E[])} has GWT
 * serializable type.  It is also useful in specifying contracts of interface
 * methods.  In the following example,
 *
 * <pre style="code">
 * {@literal @}GwtCompatible
 * interface ListFactory {
 *   ...
 *   {@literal @}GwtCompatible(serializable = true)
 *   &lt;E> List&lt;E> newArrayList(E... elements);
 * }
 * </pre>
 * <p>The {@code newArrayList(E[])} method of all implementations of {@code
 * ListFactory} is expected to return a value with a GWT serializable type.
 *
 * //<p>Note that a {@code GwtCompatible} type may have some {@link
 * //GwtIncompatible} methods.
 *
 * @author Charles Fry
 * @author Hayward Chan
 */
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@GwtCompatible
public @interface GwtCompatible {

    /**
     * When {@code true}, the annotated type or the type of the method return
     * value is GWT serializable.
     *
     * @see <a href="http://code.google.com/webtoolkit/doc/latest/DevGuideServerCommunication.html#DevGuideSerializableTypes">
     *     Documentation about GWT serialization</a>
     */
    boolean serializable() default false;

    /**
     * When {@code true}, the annotated type is emulated in GWT. The emulated
     * source (also known as super-source) is different from the implementation
     * used by the JVM.
     *
     * @see <a href="http://code.google.com/webtoolkit/doc/latest/DevGuideOrganizingProjects.html#DevGuideModules">
     *     Documentation about GWT emulated source</a>
     */
    boolean emulated() default false;

    boolean patternConvertible() default false;
}

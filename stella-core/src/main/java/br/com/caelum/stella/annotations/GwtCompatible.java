package br.com.caelum.stella.annotations;

import java.lang.annotation.*;

/**
 * This annotation is based on Google's Guava GwtCompatible annotation.
 * @see <a href="http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/annotations/GwtCompatible.html">
 *     GwtCompatible</a>
 *
 * The presence of this annotation on a type indicates that the type may be
 * used with the
 * <a href="http://code.google.com/webtoolkit/">Google Web Toolkit</a> (GWT).
 *
 * @author Danilo Reinert
 */
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@GwtCompatible
public @interface GwtCompatible {

    /**
     * When {@code true}, the annotated type is emulated in GWT. The emulated
     * source (also known as super-source) is different from the implementation
     * used by the JVM.
     *
     * @see <a href="http://code.google.com/webtoolkit/doc/latest/DevGuideOrganizingProjects.html#DevGuideModules">
     *     Documentation about GWT emulated source</a>
     */
    boolean emulated() default false;

    /**
     * When {@code true}, the annotated type is copied to GWT and some replacements
     * are performed for providing compatibility.
     */
    boolean patternConvertible() default false;
}

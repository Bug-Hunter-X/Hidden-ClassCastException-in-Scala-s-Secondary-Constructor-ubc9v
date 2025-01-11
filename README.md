# Hidden ClassCastException in Scala Secondary Constructor

This example demonstrates a subtle bug that can occur when using `null.asInstanceOf[T]` within a secondary constructor in Scala.  This approach can lead to unexpected `ClassCastException` exceptions at runtime if `T` is not a nullable type (e.g., `Option[T]`,  `T?`, or a class that explicitly allows nulls).

The primary constructor takes a generic `T` value. However, the secondary constructor attempts to use `null.asInstanceOf[T]`, which is problematic. While the code compiles, when the generic type parameter `T` is a non-nullable type, this will cause a `ClassCastException` at runtime when the default value `null` is used. 

**Key Takeaway**:  Avoid directly using `null.asInstanceOf[T]` for default values in secondary constructors unless you're absolutely certain that the generic type `T` will always allow null values.  Use `Option[T]` or provide a default value of the correct type instead.
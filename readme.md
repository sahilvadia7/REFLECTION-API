# Java Reflection API Demonstration

This project provides a hands-on demonstration of key concepts and functionalities within Java's Reflection API. It illustrates how Java code can inspect and manipulate its own structure (classes, methods, fields, constructors) at runtime—a powerful capability fundamental to many advanced frameworks and dynamic applications.

---

## 📘 Overview

Java Reflection allows programs to examine and modify their own structure and behavior at runtime. This project helps understand:

- How to obtain `Class` objects using various methods.
- How to dynamically create instances of classes.
- How to discover and invoke methods.
- How to access and manipulate fields.
- Class loaders and package metadata.
- Advanced meta-programming techniques like direct memory access and annotation processing.

---

## ✨ Features Demonstrated

### 🔍 Obtaining Class Objects
- Using `.class` (e.g., `String.class`)
- Using `object.getClass()`
- Using `Class.forName("com.example.MyClass")`

### 🧱 Dynamic Instantiation
- Creating objects at runtime using `Constructor` objects.
- Handling parameterized constructors.

### 🧩 Method Invocation
- Discovering and invoking methods dynamically.
- Invoking private methods using `setAccessible(true)`.

### 🧬 Field Access
- Reading and writing to fields (can be expanded further).

### 📦 Package Metadata
- Accessing class’s package details.

### 🔄 Class Loader
- Understanding `ClassLoader.loadClass()`.

### 🔐 Accessing Final Classes
- Demonstrates instantiation and inspection of final classes.

### 💥 Low-Level Memory Operations (Unsafe API)
- Using `sun.misc.Unsafe` to:
  - Allocate raw off-heap memory.
  - Directly write/read bytes or primitives to memory.
  - Bypass Java’s memory safety and encapsulation.

### 🏷️ Custom Annotation Processing
- Defining annotations: `@Component`, `@Service`, `@Model`, `@AutoWired`
- Processing them at runtime for custom behavior.

### 🧠 Generic Type Introspection
- Inspecting types with `java.lang.reflect.Type`, `ParameterizedType`, etc.

### 🔠 Static Factory Method Access
- Accessing methods like `valueOf()` dynamically.

### ⚙️ Method Metadata
- Using `Method.getParameterCount()`, etc.

---

## 📚 Advanced Topics Covered

### ✅ Accessing Final Classes
- Using reflection to bypass normal restrictions of `final`.

### ☢️ sun.misc.Unsafe
- Dangerous and internal Java class.
- Used to demonstrate raw memory handling and final field mutation.

### 🏗️ Custom Annotations
- With different `ElementType`s and `RetentionPolicy`s.
- Enables dynamic behaviors at runtime.

### 🧰 DIY Dependency Injection Container
- Scans for annotated classes.
- Instantiates and injects dependencies using Reflection.
- Mimics core Spring features.

### 🔍 Deep Type Inspection
- Introspects method and class generics via:
  - `TypeVariable`
  - `ParameterizedType`
  - `GenericArrayType`

---

## 🧪 Technologies Used

- Java 17+
- `java.lang.reflect.*`
- Maven (optional build tool)

---

## 🚀 Setup and Running

### Clone the Repository

```bash
git clone https://github.com/sahilvadia/REFLECTION-API.git
cd REFLECTION-API
````

### Build the Project (if Maven)

```bash
mvn clean install
```

### Run Main Class

#### ✅ DI Container:

```bash
mvn exec:java -Dexec.mainClass="org.reflection.runner.advanced.di.MyDIContext"
```

#### ⚠️ Unsafe API (Requires JVM Flags):

```bash
# Unsafe Integer Manipulation
java --add-opens java.base/jdk.internal.misc=ALL-UNNAMED --add-opens java.base/java.lang=ALL-UNNAMED org.reflection.runner.advanced.unsafe.UnsafeIntegerManipulation

# Unsafe Memory Access
java --add-opens java.base/jdk.internal.misc=ALL-UNNAMED org.reflection.runner.advanced.unsafe.UnsafeMemoryAccessDemo
```



## 🗂️ Package Structure Overview

| Package                                     | Description                                                              |
| ------------------------------------------- | ------------------------------------------------------------------------ |
| `org.reflection.runner.basic`               | Fundamental demos (e.g., `objectDotClass`, `Class.forName`, `loadClass`) |
| `org.reflection.runner.advanced.annotation` | Custom annotations like `@AutoWired`, `@Component`, etc.                 |
| `org.reflection.runner.advanced.bean`       | Sample bean classes like `Student` with `@Model`                         |
| `org.reflection.runner.advanced.service`    | Service classes like `StudentService`, using field injection             |
| `org.reflection.runner.advanced.di`         | Core DI container logic (`MyDIContext`)                                  |
| `org.reflection.runner.advanced.unsafe`     | `Unsafe` demos: `UnsafeIntegerManipulation`, `UnsafeMemoryAccessDemo`    |
| `org.reflection.runner.advanced.type`       | Generic type inspection with `TypeUseReflection`                         |

---

## 🔑 Key Concepts

* **Runtime Type Info**: Using `Class` to inspect metadata at runtime.
* **Dynamic Behavior**: Creating/invoking objects/methods dynamically.
* **Introspection**: Reading class/method/generic structures.
* **Manipulation**: Reading/writing fields/methods via reflection.
* **Class Loaders**: How classes are dynamically loaded.
* **Exception Handling**: Proper handling of common reflection-related exceptions.
* **Meta-Programming**: Combining annotations + reflection for frameworks.
* **Unsafe Operations**: Understanding how internal memory operations work.

---

## 🛠️ Contribution Opportunities

Want to grow this further? Consider contributing:

* Field Access Demos: Add examples of `get`/`set` on private fields.
* Array Reflection: Manipulate arrays using `java.lang.reflect.Array`.
* Proxy API: Add examples using `Proxy` and `InvocationHandler`.
* Compile-Time Annotation Processing.
* Benchmarking Reflection vs. Direct Calls.
* Advanced Exception & Circular Dependency Handling in DI.

---

## 🤝 Contributing

Contributions welcome! Please fork, clone, open an issue or submit a pull request.

---

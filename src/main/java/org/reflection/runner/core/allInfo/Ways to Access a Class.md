# Ways to Access a Class Using Reflection Api


### 1. Using `.class` literal

#### Example
- ` Class<?> clazz = Person.class;`

#### - Advantage
- Best for : Know class at compile time
- it is type safe.
- Doesn't require Object.

#### - Disadvantage
- No Dynamic (you must know the class name at compile time)

### 2. Using `Object.getClass()
#### Example
- `Person person = new Person(1,"student1");`
- `Class<?> clazz = person.getClass();`

#### - Advantage
- Best for : If you already have the class object and you want to class metadata.
- Dynamically get the class info form the object

#### - Disadvantage
- not generic type safe
- not use when object is null

### 3. Using `Class.forName("Fully qualified")`
#### Example
-  `Class<?> clazz = Class.forName("org.student");`

#### - Advantages
- Fully dynamic at runtime
- Useful in framework and config-driven system

#### - Disadvantage
- Throw the Exception(`ClassNotFoundException`)
- slow and error-prone if name wrong 

### 4. Using`ClassLoader.loadClass("classname")`

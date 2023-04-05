# Behavior parameterization

# Introducción

El patrón de diseño de software "Behaivor Parameterization" ayuda a manejar cambios frecuentes en 
los requerimientos solicitados por el cliente. El patrón permite que un método reciba comportamiento
a través de la parametrización y lo use internamente.

- La parametrización de comportamientos es la capacidad de un método de tomar varios comportamientos diferentes como parámetros y utilizarlos internamente para realizar diferentes comportamientos.
- La parametrización de comportamientos le permite adaptar mejor su código a las necesidades cambiantes y ahorrar esfuerzos de ingeniería en el futuro.

## ⛈️Problema

El granjero podría querer una funcionalidad para encontrar todas las manzanas verdes en su inventario. Pero al día siguiente podría decirte: "En realidad, también quiero encontrar todas las manzanas que pesen más de 150 g. ¿Cómo puede hacer frente a estos requisitos cambiantes? Idealmente, le gustaría minimizar su esfuerzo de ingeniería.

## Código base

### domain - models

```java
public record Apple(String id, String color, Double weight) {
}
```

### domain - ports

```java
public interface AppleRepository {
    Optional<ArrayList<Apple>> searchAll();
}
```

### domain - exceptions

```java
public class DomainError extends RuntimeException {
    private final String errorMessage;
    
    public DomainError(String errorMessage) {
        super(errorMessage);

        this.errorMessage = errorMessage;
    }

    public String errorMessage() {
        return this.errorMessage;
    }
}
```

```java
public class AppleNoContent extends DomainError {
    public AppleNoContent(String identifier) {
        super(format("The apples <%s> don´t exists", identifier));
    }
}
```

```java
public class AppleNotFound extends DomainError {
    public AppleNotFound() {
        super("No apples found");
    }
}
```

### services
```java
@Service
public class AppleFinder {
    private final AppleRepository repository;

    public AppleFinder(AppleRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Apple> find() {
        var apples = repository.searchAll();

        if (apples.filter(ArrayList::isEmpty).isPresent()) throw new AppleNotFound();

        return apples.get();
    }
}
```

### infrastructure - persistence

```java
@Repository
public class InMemoryAppleRepository implements AppleRepository {
    private final ArrayList<Apple> apples = new ArrayList<>() {
        {
            add( new Apple("1", "green", 160D));
            add( new Apple("2", "yellow", 140.5D));
            add( new Apple("3",  "green", 139.8D));
            add( new Apple("4",  "yellow", 199.D));
        }
    };
    
    @Override
    public Optional<ArrayList<Apple>> searchAll() {
        return Optional.ofNullable(apples);
    }
}
```

### ui - console

```java
public class GetApplesConsole {
public static void main(String[] args) {
    try {
        var repository = new InMemoryAppleRepository();
        var services = new AppleFinder(repository);
        var apples = services.find();

          System.out.println(apples);

          System.out.println(services.findGreenApplesByColor(apples));

          System.out.println(services.findApplesByColor(apples, "yellow"));

          System.out.println(services.findApplesByWeight(apples, 150D));

          System.out.println(services.findApplesByWeightAndColor(apples, "green", 150D));
        }catch (AppleNotFound e) {
           System.out.println(e.errorMessage());
        }
    }
}
```
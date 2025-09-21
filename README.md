# Calculadora.java

Este código Java implementa una aplicación de calculadora simple utilizando Swing para la interfaz gráfica de usuario (GUI). La calculadora soporta operaciones aritméticas básicas como suma, resta, multiplicación y división.

<img width="400" height="537" alt="image" src="https://github.com/user-attachments/assets/21034b80-0b1d-4f86-b6a0-534faf339f3b" />

## Descripción General

La clase `Calculadora` extiende `JFrame` e implementa la interfaz `ActionListener` para manejar las interacciones del usuario con los botones de la calculadora.

## Miembros de la Clase

-   `display`: Un `JTextField` para mostrar la entrada del usuario y los resultados.
-   `numButtons`: Un array de objetos `JButton` que representan los botones numéricos (0-9).
-   `funcButtons`: Un array de objetos `JButton` que representan los botones de función (+, -, \*, /, ., =, Del, C).
-   `num1`, `num2`, `resut`: Variables de tipo `double` para almacenar el primer número, el segundo número y el resultado del cálculo, respectivamente.
-   `operador`: Una variable de tipo `char` para almacenar el operador seleccionado.

## Constructor

El constructor `Calculadora()` inicializa los componentes de la GUI:

-   Establece el título, la operación de cierre por defecto, el tamaño, el layout, la capacidad de redimensionamiento y la ubicación del `JFrame`.
-   Crea y configura el `JTextField` llamado `display` para la entrada y salida de datos.
-   Crea y configura los botones de función (+, -, \*, /, ., =, Del, C) utilizando un bucle y el array `funcLabels`.
-   Crea y configura los botones numéricos (0-9) utilizando un bucle.
-   Establece las posiciones de los botones "Del" y "C".
-   Crea un `JPanel` con un `GridLayout` para organizar los botones en una cuadrícula.
-   Añade los botones numéricos y de función al panel en un orden específico definido por el array `buttonOrder`. Esto determina el diseño visual de los botones en la calculadora.
-   Añade el panel, el display y los botones "Del"/"C" al `JFrame`.
-   Establece la visibilidad del `JFrame` a `true`, lo que hace que la calculadora sea visible para el usuario.

## Método `actionPerformed`

Este método es el controlador de eventos para los clicks de los botones:

-   Obtiene el comando de acción del `ActionEvent`. El comando de acción es el texto del botón que se ha clickeado.
-   Si el comando es un dígito (0-9), añade el dígito al campo de texto `display`. Si el campo de texto contiene "0", lo reemplaza con el dígito clickeado; de lo contrario, añade el dígito al final del texto existente.
-   Si el comando es ".", añade un punto decimal al campo de texto `display`, pero solo si el campo de texto no contiene ya un punto decimal.
-   Si el comando es un operador (+, -, \*, /), almacena el primer número (`num1`) convirtiendo el texto del campo de texto `display` a un `double`, y almacena el operador en la variable `operador`. Después, limpia el campo de texto `display` para que el usuario pueda introducir el segundo número.
-   Si el comando es "=", realiza el cálculo basado en el operador almacenado:
    -   Convierte el texto del campo de texto `display` a un `double` y lo almacena en `num2`.
    -   Utiliza una sentencia `switch` para realizar la operación apropiada en función del valor de `operador`.
    -   Si el operador es "+", suma `num1` y `num2` y almacena el resultado en `resut`.
    -   Si el operador es "-", resta `num2` de `num1` y almacena el resultado en `resut`.
    -   Si el operador es "\*", multiplica `num1` y `num2` y almacena el resultado en `resut`.
    -   Si el operador es "/", divide `num1` entre `num2` y almacena el resultado en `resut`. Si `num2` es 0, establece `resut` a `Double.NaN` (Not a Number) para indicar un error.
    -   Muestra el resultado en el campo de texto `display`. Si el resultado es `Double.NaN`, muestra "Error". Si el resultado es un número entero, lo muestra como un entero; de lo contrario, lo muestra como un `double`.
    -   Almacena el resultado en `num1` para que el usuario pueda continuar realizando cálculos con el resultado actual.
-   Si el comando es "C", borra el campo de texto `display` y reinicia los números almacenados (`num1`, `num2` y `resut`) a 0.
-   Si el comando es "Del", borra el último carácter introducido en el campo de texto `display`. Si solo hay un carácter, lo reemplaza con "0".

## Método `main`

El método `main` crea una instancia de la clase `Calculadora`:

-   Establece el "look and feel" de la aplicación para que coincida con el del sistema operativo del usuario. Esto hace que la calculadora tenga un aspecto nativo en diferentes plataformas.
-   Maneja posibles excepciones que puedan ocurrir al establecer el "look and feel".
-   Crea un nuevo objeto `Calculadora`, lo que inicializa y muestra la interfaz gráfica de la calculadora.

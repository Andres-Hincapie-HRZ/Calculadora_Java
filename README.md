# Calculadora en Java con Interfaz Gráfica
## Descripción
Esta es una calculadora básica desarrollada en Java que utiliza la librería Swing para crear una interfaz gráfica de usuario (GUI). La calculadora permite realizar operaciones aritméticas básicas como suma, resta, multiplicación y división.

<img width="1242" height="694" alt="image" src="https://github.com/user-attachments/assets/af22744a-cfa8-408a-ad45-bc10739b34ed" />

<img width="400" height="537" alt="image" src="https://github.com/user-attachments/assets/21034b80-0b1d-4f86-b6a0-534faf339f3b" />

## Características
- **Interfaz gráfica intuitiva** con botones numéricos y operadores
- **Operaciones básicas**: suma (+), resta (-), multiplicación (×), división (÷)
- **Funciones adicionales**:
  - Punto decimal (.)
  - Botón de borrar último dígito (Del)
  - Botón de limpiar pantalla (C)
  - Encadenamiento de operaciones
- **Manejo de errores**: previene división por cero
- **Diseño responsivo**: ventana de tamaño fijo y centrada

## Estructura del Código

### Clase Principal: `Calculadora`
La clase `Calculadora` extiende `JFrame` e implementa `ActionListener` para manejar eventos de los botones.

#### Variables de Instancia
- `display`: Campo de texto para mostrar números y resultados
- `numButtons[]`: Array de botones numéricos (0-9)
- `funcButtons[]`: Array de botones de función (+, -, ×, ÷, ., =, Del, C)
- `num1`, `num2`, `result`: Variables para almacenar números y resultados
- `operator`: Variable para almacenar el operador seleccionado

#### Métodos Principales

##### Constructor `Calculadora()`
Configura la ventana principal y todos los componentes:
- Establece título, tamaño y propiedades de la ventana
- Crea y configura el campo de texto (display)
- Inicializa botones numéricos y de función
- Organiza los botones en un panel con diseño de cuadrícula 4x4
- Posiciona botones especiales (Del y C) fuera de la cuadrícula

##### Método `actionPerformed(ActionEvent e)`
Maneja todos los eventos de clic en botones:

**Números (0-9)**:
- Si el display muestra "0", lo reemplaza con el número
- Si no, concatena el número al texto existente

**Punto decimal (.)**:
- Solo permite un punto decimal por número

**Operadores (+, -, ×, ÷)**:
- Guarda el primer número en `num1`
- Almacena el operador seleccionado
- Limpia el display para el segundo número

**Igual (=)**:
- Obtiene el segundo número (`num2`)
- Realiza la operación según el operador
- Maneja división por cero mostrando "Error"
- Muestra el resultado (entero si es posible, decimal si es necesario)
- Permite encadenamiento de operaciones

**Botón C (Clear)**:
- Resetea el display a "0"
- Reinicia todas las variables

**Botón Del (Delete)**:
- Elimina el último carácter del display
- Si queda vacío, muestra "0"

##### Método `main(String[] args)`
- Establece el "look and feel" del sistema operativo
- Crea una instancia de la calculadora para iniciar la aplicación

## Diseño de la Interfaz

### Distribución de Botones
```
┌─────────────────────────┐
│         Display         │
├─────────────────────────┤
│  Del  │   C   │         │
├───────┼───────┼─────────┤
│   1   │   2   │   3   + │
├───────┼───────┼─────────┤
│   4   │   5   │   6   - │
├───────┼───────┼─────────┤
│   7   │   8   │   9   × │
├───────┼───────┼─────────┤
│   .   │   0   │   =   ÷ │
└───────┴───────┴─────────┘
```

### Características Visuales
- **Tamaño de ventana**: 420x550 píxeles
- **Fuente**: Arial Bold, tamaño 18-20
- **Campo de texto**: Alineado a la derecha, no editable
- **Botones**: Sin foco, diseño cuadrado
- **Espaciado**: 10 píxeles entre botones

## Cómo Ejecutar

### Requisitos
- Java Development Kit (JDK) 8 o superior
- Compilador Java (javac)

### Pasos para Ejecutar
1. **Compilar el código**:
   ```bash
   javac Calculadora.java
   ```

2. **Ejecutar la aplicación**:
   ```bash
   java Calculadora
   ```

## Funcionalidades Detalladas

### Operaciones Aritméticas
- **Suma**: `num1 + num2`
- **Resta**: `num1 - num2`
- **Multiplicación**: `num1 × num2`
- **División**: `num1 ÷ num2` (con protección contra división por cero)

### Manejo de Números
- **Números enteros**: Se muestran sin decimales cuando es posible
- **Números decimales**: Se muestran con decimales cuando es necesario
- **Punto decimal**: Solo se permite uno por número
- **Encadenamiento**: El resultado de una operación puede usarse como primer número de la siguiente

### Funciones Especiales
- **Borrar (Del)**: Elimina el último dígito ingresado
- **Limpiar (C)**: Resetea completamente la calculadora
- **Manejo de errores**: Muestra "Error" en caso de división por cero

## Consideraciones Técnicas

### Librerías Utilizadas
- `javax.swing.*`: Para componentes de interfaz gráfica
- `java.awt.*`: Para funcionalidades básicas de GUI
- `java.awt.event.*`: Para manejo de eventos

### Patrones de Diseño
- **ActionListener**: Para manejar eventos de botones
- **JFrame**: Como ventana principal
- **GridLayout**: Para organizar botones en cuadrícula
- **Null Layout**: Para posicionamiento manual de componentes

### Manejo de Excepciones
- Protección contra división por cero
- Manejo de errores en configuración de "look and feel"

## Posibles Mejoras Futuras
- Agregar más operaciones (potencia, raíz cuadrada, etc.)
- Implementar historial de operaciones
- Agregar soporte para teclado
- Mejorar el diseño visual
- Agregar sonidos de retroalimentación
- Implementar operaciones con paréntesis

## Autor
Código desarrollado como ejemplo de aplicación Java con interfaz gráfica usando Swing.

## Licencia
Este código es de dominio público y puede ser usado libremente para fines educativos.

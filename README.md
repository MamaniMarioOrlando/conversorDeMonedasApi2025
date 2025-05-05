# 💱 Conversor de Monedas - Java + API REST

Este proyecto en Java realiza el consumo de una API REST pública para obtener tasas de cambio de monedas en tiempo real, utilizando `HttpClient` y `Gson`. Muestra cómo estructurar un proyecto limpio, modular y de fácil mantenimiento para acceder a servicios externos.

---

## 🚀 Tecnologías Utilizadas

- Java 17+ (recomendado)
- API pública: [ExchangeRate API](https://www.exchangerate-api.com/)
- Gson (para parseo de JSON)
- Java HttpClient (para solicitudes HTTP modernas)

---

## 📦 Estructura del Proyecto

```
src/
└── com/ejemplo/
    ├── dto/
    │   └── CurrencyDto.java          # Representa la estructura del JSON de la API
    ├── util/
    │   └── HttpClientService.java   # Encapsula la lógica para hacer peticiones HTTP
    ├── Exceptions/
    │   └── SoloNumerosException.java   # Manejo de Excepciones
    ├── service/
    │   └── ExchangeRateService.java # Orquesta la consulta y conversión del JSON
    └── app/
        └── ExchangeApp.java         # Clase principal que ejecuta el flujo del programa
```

---

## 📄 Descripción del Flujo

1. Se realiza una petición GET a la API de tasas de cambio.
2. La respuesta JSON se convierte automáticamente en un `record` (`CurrencyDto`) usando Gson.
3. Se valida si la respuesta fue exitosa.
4. Se imprimen tasas de cambio seleccionadas (ej. USD a EUR, JPY, ARS).

---
## ▶️ Cómo Ejecutarlo

### Requisitos

- Java 17 o superior instalado
- Acceso a Internet

### Paso a paso

1. Clona o descarga el repositorio.
2. Asegúrate de tener el archivo `CurrencyDto.java` correctamente definido.
3. Ejecuta la clase `ExchangeApp` desde tu IDE o por consola:

```bash
javac -d out src/com/ejemplo/**/*.java
java -cp out com.ejemplo.app.ExchangeApp
```

---

## 📌 Personalización

- Puedes cambiar la moneda base modificando la URL en `ExchangeRateService.java`.
- Puedes agregar más monedas al resultado modificando el `System.out.println(...)` en `ExchangeApp`.

---

## 📚 Recursos

- [Documentación de la API](https://www.exchangerate-api.com/docs)
- [Guía Gson - Google](https://github.com/google/gson)

---

## 🛡️ Licencia

Este proyecto es solo para fines educativos y demostrativos. Puedes adaptarlo libremente a tus necesidades.

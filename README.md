La aplicación tendrá los siguientes elementos:

- Splash Screen con una foto tuya tipo carnet (actual) en el centro y debajo de la foto tu nombre y apellido. La Splash Screen debe durar 3 segundos. Si no existen datos de usuario guardados en DataStore se navegará al OnBoarding, por lo contrario, si sí que existen datos de usuarios guardados en DataStore se recuperarán y se navegará a la pantalla principal.

- Onboarding con una única pantalla en la que se pedirá al usuario su nombre (solo letras y longitud mínima 3) y su número de teléfono (solo números y de longitud 9). La pantalla también contendrá tu foto carnet junto a tu nombre y un botón que solo estará activo cuando los dos campos contengan un dato correcto. Cuando se pulse el botón se almacenarán los datos en DataStore y se navegará a la pantalla principal.

- Pantalla principal que contendrá tu foto carnet junto a tu nombre y, además, el nombre y el número de teléfono del usuario y un botón para cerrar sesión. Al cerrar sesión se borrarán los datos de Data Store y se navegará al Onboarding.

Se debe usar Navegación, ViewModel, LiveData y DataStore.

La interfaz debe tener colores diferentes a los colores por defecto.

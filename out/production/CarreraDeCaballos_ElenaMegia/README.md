# CarreraDeCaballos_ElenaMegia


Tarea carrera de caballos concurrente
1) El programa debe pedir al usuario cuantos caballos desea que corran en la
carrera.
2) El programa debe crear tantos procesos Caballo, como caballos deban correr.
3) El programa queda a la espera de que el usuario pulse Intro, para simular dar
el pistoletazo de salida.
4) En ese momento los caballos empiezan a correr. Para simular este
comportamiento de la carrera los procesos caballos tienen un bucle con un
contador que indica la distancia de la carrera (por ejemplo 100m). En este
contador se duerme al proceso una cantidad aleatoria (por ejemplo entre 10 y
50 ms.) y se incrementa en 1 el contador.
5) Cuando el caballo ha terminado el recorrido imprime el tiempo que ha
tardado.
6) El tiempo se medirá con un proceso Reloj. El reloj tendrá un método iniciar,
que servirá para que los caballos puedan consultar para ver si ya pueden
empezar a correr.
7) Al terminar los caballos consultan en el reloj el tiempo transcurrido.
8) Cuando han terminado todos los caballos el programa principal saca una lista
con las clasificaciones y la lista de tiempos de todos los caballos que han
corrido en la carrera. 

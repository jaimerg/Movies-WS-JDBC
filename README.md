# Movies-WS-JDBC
Gestión de películas de una forma sofisticada y realista mediante múltiples clases
Para el presente ejercicio diseñaremos un modelo de dominio que contemplará las siguientes entidades: Película, Actor,Temática y Nacionalidad. La relación entre películas y actores es N/M. La relación entre películas y temáticas es N/1 y la relación entre películas y nacionalidades es N/M.

Implementar este modelo de datos en MySQL e insertar una serie de filas en cada una de las tablas con datos de ejemplo.

Posteriormente, tienes que implementar las siguientes consultas:

1. Dado un nombre de un actor (el nombre del actor se podrá suministrar de forma parcial y la consulta ha de ser insensible a mayúsculas y minúsculas), devolver la información detallada de todas las películas en las que ha participado. El orden de los resultados devueltos a de ser descendente en función del número de ventas.

2. Devolver todas las películas tales que la temática/género sea comedia.

3. Devolver todas las películas tales que la temática sea comedia y la nacionalidad francesa.

4. Devolver las películas tales que la temática sea comedia, la nacionalidad francesa y la fecha de publicación sea durante la década de los 90.

5. Devolver las películas tales que la temática sea comedia, la nacionalidad francesa, la fecha de publicación sea desde 1990 hasta la actualidad y aparezca el actor Jean Reno.

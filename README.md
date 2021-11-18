**PPKWU lab4**
----
Rest API, które otrzymany ciąg znaków przekazuje do zadania 3 i zwraca rezultat w postaci jednego z czterech formatów:
txt ("rodzaj znaków: %d\n..."), json, xml i csv. Formaty zwracanych i pobieranych danych są "wybierane" przy wywołaniu
API. API posiada również endpoint, w którym przekazujemy dane (archiwalne, np. z pliku: txt,json,csv) z zadania 3 (w
dowolnym formacie), a zadanie 4 dokonuje konwersji do jednego z czterech formatów: txt ("rodzaj znaków: %d\n..."), json,
xml i csv.

* **SKŁADNIA**

 ``` 
ścieżkaApi/{tekst}/{formatZad3}/{formatZad4}
```

* **Parametry**

 ```
{tekst} - ciąg znaków przekazywany do API z zadania 3
{formatZad3} - format zwracany przez API z zadania 3
{formatZad4} - format do ktorego konwertujemy
 ```

* **Metoda**

```
GET
```

